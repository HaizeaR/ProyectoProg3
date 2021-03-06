package Ventanas;

import java.awt.*;
import java.awt.Color;

import java.awt.event.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.*;

import Admin.LogInAdmin;
import BD.BDprueba2;
import Elementos.Compra;




/** Ventana de LOGIN que permite a un usuario terminar su compra
 * @author Unai, Mireya y Haizea
 *
 */

// FALTA  
// - validar que el usuario está en la BD, si no está mandar a registrar 
// - Mejorar ventana

public class LogIn extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JButton bConfirmar, bRegistrar, bAtras, bAdmin;
	static JLabel lCorreo, lContrasena,lLogin,lPelicula, lSala, lHora, lAsiento, lbimagen; 
	static JTextField tfCorreo; 
	static JPasswordField jpContrasena; 
	int contador = 0; 
	static String correoCliente;
	
	//private static JDialog v;
	
	static Connection con;
	

	public LogIn() {
		
		setSize(600,400);
		setLocation(300, 200);
		setTitle("LOG IN");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		con = BDprueba2.conexion;
		
		
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
		
		// podemos hacer que sea un botón y la confirmación de compra sea
		// pulsando la foto
		
		lbimagen = new JLabel(new ImageIcon("src/img/icon.png"));
		lbimagen.setSize(10, 10);
		
		pCentral.add(lbimagen);


	
		
		
	
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
		
				//LogIn.guardaConfig();
				setVisible(false);
				// te devuelve a la sala de asientos o vuelves a la cartelera ??? 
				Cartelera.main(null); 

				dispose();
	
	}
	
	
	
	/** Método que contiene el hilo que nos permite
	 * cambiar de ventana de Login a ventana registro 
	 */
	private void accedeRegistro() {
	
				setVisible(false);
				Registro.main(null); 

				dispose();
	
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
				
				
				  String c = JOptionPane.showInputDialog("Clave ADMIN");
				  
				  // solo se abre la ventana de ADMIN si se introduce código 
				  // 123
				  // mejorar seguridad de esto ?
				  
				  if (c.compareTo("123") == 0) {
					  setVisible(false);
						LogInAdmin.main(null); 

						dispose();
				  }
				
				
				
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
		//Connection conn = BDprueba2.initBD("Cine2.db");
		String SQL = ""; 
		try {
			Statement stat = con.createStatement();
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
				
				//System.out.println(valorEnTexto);
				//System.out.println(contrasena);
				//Cipher cipher = Cipher.getInstance(algorithm);
				
				
				// en lugar de desencriptar el valor de la BD tenemos que encriptar el que 
				// sacamos del JTEXTFIELD de la misma forma
				
				if ( correo.compareTo(tfCorreo.getText()) == 0) {
					System.out.println("entra");
					correoCliente = tfCorreo.getText();
					

					if (valorEnTexto.compareTo(contrasena) == 0 ) {
						System.out.println("entra");
						
						confirmCompra();
						
						//Compra c = new Compra(contador, cod_asiento, cod_sesion, dNI)
						//BDprueba2.insertCompra(c); 
						contador ++; 

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