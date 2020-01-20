package Admin;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.*;


import javax.swing.*;


import BD.BDprueba2;
import Ventanas.LogIn;




/**
 * Clase del tipo ventana que permite a un ADMINISTRADOR hacer LOGIN y entrar en su cuenta
 * @author Unai Mendiondo, Mireya Quintana, Haizea Rodriguez
 *
 */
public class LogInAdmin extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ELEMENTOS 
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



		pInfoCompra.setBackground(Color.white);
		getContentPane().add(pInfoCompra, BorderLayout.NORTH);

		JPanel pTitulo = new JPanel(); 
		getContentPane().add(pTitulo, BorderLayout.NORTH); 
		pTitulo.setBackground(Color.GRAY);
		lTitulo = new JLabel("ADMINISTRADOR");
		lTitulo.setFont(new java.awt.Font("Tahoma", 1, 30));

		pTitulo.add(lTitulo);



		// PANEL CENTRAL 

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
			e.printStackTrace();
		}

	}




	private void irAMenu() {
		
				//LogIn.guardaConfig();
				setVisible(false);
				FuncionesAdmin.main(null); 
				dispose();
	
	}




	private void volverAtrasA() {
				//LogIn.guardaConfig();
				setVisible(false);
				LogIn.main(null); 
				dispose();
			}				
	

	/** Método que contiene el hilo que nos permite
	 * cambiar de ventana de Login a ventana registro 
	 */
	private void accedeRegistroA() {

				//LogIn.guardaConfig();
				setVisible(false);
				RegistrarAdmin.main(null); 
				dispose();
	
	}





	// MAIN 
	public static void main(String[] args) {
		LogInAdmin ventLogin = new LogInAdmin(); 
		ventLogin.setVisible(true);

	}

}
