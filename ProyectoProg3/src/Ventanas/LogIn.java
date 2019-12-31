package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.PrintStream;
import java.io.Reader;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.*;

import BD.BDprueba2;




/** Ventana de LOGIN que permite a un usuario terminar su compra
 * @author Unai, Mireya y Haizea
 *
 */

// FALTA 
// - validar que el usuario está en la BD, si no está mandar a registrar 
// - Mejorar ventana

public class LogIn extends JFrame {
	
	
	static JButton bConfirmar, bRegistrar, bAtras, bAdmin;
	static JLabel lCorreo, lContrasena,lLogin,lPelicula, lSala, lHora, lAsiento; 
	static JTextField tfCorreo; 
	static JPasswordField jpContrasena; 
	//private static JDialog v;
	

	

	public LogIn() {
		
		setSize(600,400);
		setLocation(300, 200);
		setTitle("LOG IN");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		
		
		// EDITAR PARA QUE SE VEA 
		
		JPanel pSuperior = new JPanel();
		getContentPane().add(pSuperior, BorderLayout.NORTH);
		lLogin = new JLabel("LOG IN");
		lLogin.setFont(new java.awt.Font("Tahoma", 1, 18));
		pSuperior.add(lLogin);
		
		
		JPanel pInfoCompra = new JPanel(); 
		
		// Definir más adelante 
		// tenemos que meter en un panel la información de compra
		// fecha, hora , asientos ... 
		
		lPelicula = new JLabel("Pelicula: "); 
		lHora = new JLabel("Hora: "  ); 
		lSala = new JLabel("Sala: "); 
		lAsiento = new JLabel("Asiento/s: "); 
		
		pInfoCompra.add(lPelicula); 
		pInfoCompra.add( lHora);
		pInfoCompra.add( lSala );
		pInfoCompra.add(lAsiento);
		
		
		pInfoCompra.setBackground(Color.white);
		getContentPane().add(pInfoCompra, BorderLayout.NORTH);
		
		JPanel pCentral = new JPanel(); 
		
		getContentPane().add(pCentral, BorderLayout.CENTER);
	
		
		lCorreo = new JLabel("Correo :"); 
		lContrasena = new JLabel("Contraseña :");
		
		tfCorreo = new JTextField(10); 
		jpContrasena = new JPasswordField(10);
	
		
		pCentral.add(lCorreo);
		pCentral.add(tfCorreo);
		
		pCentral.add(lContrasena);
		pCentral.add(jpContrasena); 
		

	
		JPanel pBotonera = new JPanel(); 
		getContentPane().add(pBotonera, BorderLayout.SOUTH);
		
		bConfirmar = new JButton("Confirmar"); 
		
			//bConfirmar.setBackground(Color.cyan);
		bRegistrar = new JButton("Registrar"); 
		bAtras = new JButton("Atras");
		bAdmin = new JButton("Admin");
	
		pBotonera.add(bAtras); 
		pBotonera.add(bConfirmar); 
		pBotonera.add(bRegistrar); 
		pBotonera.add(bAdmin);
		
		
		// Action Events para los botones 
		
		bAtras.addActionListener((ActionEvent e) -> {volverAtras();});
		bRegistrar.addActionListener((ActionEvent e) -> {accedeRegistro(); } );
		bConfirmar.addActionListener((ActionEvent e) -> {confirmarLogIn();});
		bAdmin.addActionListener((ActionEvent e) -> {ventanaAdmin();});

		
	
	}
	
	private void volverAtras() {
		Thread t1 = new Thread() {
			public void run() {
				//LogIn.guardaConfig();
				setVisible(false);
				// te devuelve a la sala de asientos o vuelves a la cartelera ??? 
				Cartelera.main(null); 

				dispose();
			}				
		}; 
		t1.start();
	}
	
	
	
	/** Método que contiene el hilo que nos permite
	 * cambiar de ventana de Login a ventana registro 
	 */
	private void accedeRegistro() {
		Thread t2 = new Thread() {
			public void run() {
				//LogIn.guardaConfig();
				setVisible(false);
				Registro.main(null); 

				dispose();
			}				
		}; 
		t2.start();
	}
	
	
	private void confirmCompra() {
		Thread t3 = new Thread() {
			public void run() {
				//LogIn.guardaConfig();
				setVisible(false);
				ConfCompra.main(null); 

				dispose();
			}				
		}; 
		t3.start();
		
	}
	private void ventanaAdmin() {
		Thread t4 = new Thread() {
			public void run() {
				
				
			
				
				
				setVisible(false);
				LogInAdmin.main(null); 

				dispose();
			}				
		}; 
		t4.start();
		
	}
//	
//	private void ventanaAdmin2() {
//		Thread t4 = new Thread() {
//			public void run() {
//				
//				String cod = JOptionPane.showInputDialog("Código Admin: "); 
//				if( cod == null) {
//					System.out.println("Introduce código");
//					
//				}
//				else if( cod = "123"  ) {
//					setVisible(false);
//					LogInAdmin.main(null); 
//
//					dispose();
//				}
//			
//				
//				
//				
//			}				
//		}; 
//		t4.start();
//		
//	}
	
	
	
	

	
	

	

//	public static void guardaConfig() {
//		try {
//			PrintStream ps = new PrintStream( "config.txt" );
//			ps.println( v.getWidth() );
//			ps.println( v.getHeight() );
//			ps.println( v.getX() );
//			ps.println( v.getY() );
//
//			ps.close();
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog( null, "Error en creación de fichero config.txt", "Error de configuración", JOptionPane.ERROR_MESSAGE );
//		}
//	}
//
//
//	public static void cargaConfig() {
//		try {
//			Scanner scanner = new Scanner( new File("config.txt") );
//			String linea = scanner.nextLine(); // anchura y altura
//			String linea2 = scanner.nextLine();
//			v.setSize( Integer.parseInt(linea), Integer.parseInt(linea2) );
//			linea = scanner.nextLine(); // x e y
//			linea2 = scanner.nextLine();
//			v.setLocation( Integer.parseInt(linea), Integer.parseInt(linea2) );
//	
//			
//			scanner.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
	

	 
	public void confirmarLogIn() {
		//Connection conn = BDprueba2.abrirConexion( "Cine2.db" );
		Connection conn = BDprueba2.initBD("Cine2.db");
		String SQL = ""; 
		try {
			Statement stat = conn.createStatement();
			SQL = "select correo, contrasena from cliente"; 

			ResultSet rs = stat.executeQuery( SQL );
			while(rs.next()) {
				String correo = rs.getString("correo"); 
				String contrasena = rs.getString("contrasena"); 
				//char[] con = rs.get

//				char [] c = jpContrasena.getPassword(); 
//				String contrasenaVentana =	c.toString(); 
				
//				System.out.println(contrasenaVentana);
//				System.out.println("//");
//				System.out.println(contrasena);
				//String contrasenaVentana = jpContrasena.getPassword().toString();
				
				// Asi funiona si en la BD tenemos 12345678
				// si lo tenemos "codificado" no funciona
				String valorEnTexto = new String( jpContrasena.getPassword() );

				if ( correo.compareTo(tfCorreo.getText()) == 0) {
					System.out.println("entra");

					if (valorEnTexto.compareTo(contrasena) == 0 ) {
						System.out.println("entra");
						
						confirmCompra();


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

	
	
	
	
	public static void main(String[] args) {
		LogIn ventLogin = new LogIn(); 
		ventLogin.setVisible(true);
		
	}
	

}