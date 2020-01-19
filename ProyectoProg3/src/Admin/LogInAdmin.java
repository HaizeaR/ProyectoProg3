package Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BD.BDprueba2;
import Ventanas.LogIn;

public class LogInAdmin extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JButton bRegistrar, bAtras, bEntrar;
	static JLabel lCorreo, lContrasena,lLogin, lTitulo; 
	static JTextField tfCorreo; 
	static JPasswordField jpContrasena; 
	//private static JDialog v;
	

	

	public LogInAdmin() {
		
		setSize(600,400);
		setLocation(300, 200);
		setTitle("LOG IN ADMIN");
		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		
		
		// EDITAR PARA QUE SE VEA 
		
	
		
		
		JPanel pInfoCompra = new JPanel(); 
		
		// Definir más adelante 
		// tenemos que meter en un panel la información de compra
		// fecha, hora , asientos ... 
		
		pInfoCompra.setBackground(Color.white);
		getContentPane().add(pInfoCompra, BorderLayout.NORTH);
		
		JPanel pTitulo = new JPanel(); 
		getContentPane().add(pTitulo, BorderLayout.NORTH); 
		pTitulo.setBackground(Color.GRAY);
		lTitulo = new JLabel("ADMINISTRADOR");
		lTitulo.setFont(new java.awt.Font("Tahoma", 1, 30));
		
		pTitulo.add(lTitulo);
		
		
		
		
		
		JPanel pCentral = new JPanel(); 
		pCentral.setBackground(Color.GRAY);
		
		
		
		getContentPane().add(pCentral, BorderLayout.CENTER);
	
		
		lCorreo = new JLabel("Correo :"); 
		lContrasena = new JLabel("Contrasena :");
		
		tfCorreo = new JTextField(10); 
		jpContrasena = new JPasswordField(10);
		
		
		
	
		
		pCentral.add(lCorreo);
		pCentral.add(tfCorreo);
		
		pCentral.add(lContrasena);
		pCentral.add(jpContrasena); 
		

	
		JPanel pBotonera = new JPanel(); 
		getContentPane().add(pBotonera, BorderLayout.SOUTH);
		
		
			//bConfirmar.setBackground(Color.cyan);
		bEntrar = new JButton("Entrar");
		bRegistrar = new JButton("Registrar"); 
		bAtras = new JButton("Atras");
	
		pBotonera.add(bAtras); 
		pBotonera.add(bEntrar);
		pBotonera.add(bRegistrar); 
		
		
		// Action Events para los botones 
		bEntrar.addActionListener((ActionEvent e) -> {confirmarLogIn(); });
		bAtras.addActionListener((ActionEvent e) -> {volverAtrasA();});
		bRegistrar.addActionListener((ActionEvent e) -> {accedeRegistroA(); } );

		
	
	}
	
	
	
	
	public void confirmarLogIn() {
		//Connection conn = BDprueba2.abrirConexion( "Cine2.db" );
		Connection conn = BDprueba2.initBD("Cine2.db");
		String SQL = ""; 
		try {
			Statement stat = conn.createStatement();
			SQL = "select correo, contrasena from admin"; 

			ResultSet rs = stat.executeQuery( SQL );
			while(rs.next()) {
				String correo = rs.getString("correo"); 
		
				
				String contrasena = rs.getString("contrasena"); 
				
				String valorEnTexto = new String( jpContrasena.getPassword() );
				
		
				
				

				if ( correo.compareTo(tfCorreo.getText()) == 0) {
					System.out.println("entra");

					if (valorEnTexto.compareTo(contrasena) == 0 ) {
						System.out.println("entra");
						
						irAMenu();


					}else{
						JOptionPane.showMessageDialog(null, "ERROR contraseña incorrecta ");
					}
					

				}
			}

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	
	
	private void irAMenu() {
		Thread t = new Thread() {
			public void run() {
				//LogIn.guardaConfig();
				setVisible(false);
				FuncionesAdmin.main(null); 

				dispose();
			}				
		}; 
		t.start();
	}
	
	
	
	
	private void volverAtrasA() {
		Thread t1 = new Thread() {
			public void run() {
				//LogIn.guardaConfig();
				setVisible(false);
				LogIn.main(null); 

				dispose();
			}				
		}; 
		t1.start();
	}
	
	
	
	/** Método que contiene el hilo que nos permite
	 * cambiar de ventana de Login a ventana registro 
	 */
	private void accedeRegistroA() {
		Thread t2 = new Thread() {
			public void run() {
				//LogIn.guardaConfig();
				setVisible(false);
				RegistrarAdmin.main(null); 

				dispose();
			}				
		}; 
		t2.start();
	}

	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogInAdmin ventLogin = new LogInAdmin(); 
		ventLogin.setVisible(true);
		
	}

}
