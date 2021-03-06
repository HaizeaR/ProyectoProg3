

	
	
	

	 
package Admin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;


import javax.swing.*;

import Elementos.Admin;
import Elementos.Cliente; 

import BD.BDprueba2;

/**Ventana que permite registrar a un usuario
 * 
 * @author Unai, Mireya y Haizea
 *
 */

// FALTA: 
// - Meter en base de datos usuario registrado 
// - No guardar un usuario si tienen error de PATRON 
// - 

public class RegistrarAdmin extends JFrame {


	
	
	private static final long serialVersionUID = 1L;
	static JButton  bRegistrar, bAtras;
	static JLabel lCorreo, lContrasena, lNombre, lApellido, lDNI,  lRegistro; 
	static JTextField tfCorreo,tfNombre, tfApellido, tfDNI; 
	static JPasswordField jpContrasena; 


	public static ArrayList<Cliente> clientes = new ArrayList<>();
	
	// Patrón de correo electronico
	public static Pattern patCorreo = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	
	// Patrón DNI
	public static Pattern patDNI = Pattern.compile("[0-9]{7,8}[A-Za-z]");
	

	public RegistrarAdmin() {

		setSize(600,400);
		setLocation(300, 200);

		setTitle("Registro");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );


		// EDITAR PARA QUE SE VEA 

		JPanel pSuperior = new JPanel();
		getContentPane().add(pSuperior, BorderLayout.NORTH);
		lRegistro = new JLabel("Registro de nuevo Administrador");
		lRegistro.setFont(new java.awt.Font("Tahoma", 1, 18));
		pSuperior.add(lRegistro);


		JPanel pCentral = new JPanel(); 

		// COnseguir que se pongan en fila 

		getContentPane().add(pCentral, BorderLayout.CENTER);
		pCentral.setLayout(new BoxLayout(pCentral, WIDTH));

		
		lCorreo = new JLabel("Correo :"); 
		lContrasena = new JLabel("Contraseña :");
		lNombre = new JLabel("Nombre: "); 
		lApellido = new JLabel("Apellido: ");
		lDNI = new JLabel("DNI: ");
		


		tfNombre = new JTextField(10);
		tfApellido = new JTextField(10);
		tfDNI = new JTextField(10);
		tfCorreo = new JTextField(20); 
		jpContrasena = new JPasswordField(10);
	

		pCentral.add(lNombre); 
		pCentral.add(tfNombre);

		pCentral.add(lApellido); 
		pCentral.add(tfApellido);
		
		pCentral.add(lDNI);
		pCentral.add(tfDNI);


		pCentral.add(lCorreo);
		pCentral.add(tfCorreo);

		pCentral.add(lContrasena);
		pCentral.add(jpContrasena); 

	


		JPanel pBotonera = new JPanel(); 
		getContentPane().add(pBotonera, BorderLayout.SOUTH);


		bRegistrar = new JButton("Registrar"); 
		bAtras = new JButton("Atras");

		pBotonera.add(bAtras); 

		pBotonera.add(bRegistrar); 


		// Action Events para los botones 


		bAtras.addActionListener((ActionEvent e) -> {volverAtras();}); // Vuelve a la de LOGIN

		bRegistrar.addActionListener((ActionEvent e) -> {Registrar();} ); // Procede a registrar el usuario 
		
		// si es correcto el registo JOptionPanel de Bienvenido y pantalla de fin de compra o login ??
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				//BD.initBD();
				// creo que tampoco hace falta aqui
				//BDprueba2.abrirConexion("cine2.db");
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {}
	
			@Override
			public void windowClosed(WindowEvent e) {
				
			//	BDprueba2.cerrarConexion();
			}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		

		
		
		 // si es correcto el registo JOptionPanel de Bienvenido y pantalla de fin de compra o login ??
		 
	}

	public void volverAtras() {
		Thread t1 = new Thread() {
			public void run() {
				setVisible(false);
				LogInAdmin.main(null); 

				dispose();
			}				
		}; 
		t1.start();

	}
	
	
	// Sacar error si falta algun dato o tiene algún dato incorrecto(de un tipo no deseado) 
	// No permitir que se registre un correo ya registrado 


	public void Registrar() {
		// metodo que tiene que guardar datos recibidos en los distintos 
		//tf y guardarlos como datos de nuevo Cliente 
		
				// Comprobar que ya no está en el array 

				Admin admin;

				String nombre = tfNombre.getText(); 
				String apellido = tfApellido.getText();
				
				String DNI = tfDNI.getText();
				DNI.toString();
				comprobarDNI(DNI);
				
				String correo = tfCorreo.getText(); 
				comprobarCorreo(correo, true);
				
				String contrasena = new String( jpContrasena.getPassword() );

				comprobarContrasena(contrasena);
				
				
				// comprobar que en el numero de tarjeta NO tiene letras 
				// si tiene letras que de error y no te deja registrar el cliente 

				 admin = new Admin (DNI, nombre,apellido,correo,contrasena); 
				// System.out.println(cliente.toString());
				
			
				
			
				BDprueba2.insertarAdmin(admin);
			
				

	}
	

	
	
	/////////////////////////////////////////////////////////////////////
	//                      Pattern                                    //
	/////////////////////////////////////////////////////////////////////

	

	/** Método que comprueba que el DNI tiene 9 carácteres
	 * @param DNI
	 */
	public static boolean comprobarDNI(String DNI) {
		if(patDNI.matcher(DNI).matches()) {
			System.out.println(DNI + " cumple el patrón");
			return patDNI.matcher(DNI).matches();
		} else {
			System.out.println(DNI + " no cumple el patrón");
			JOptionPane.showMessageDialog(null, "El DNI debe seguir el siguiente patrón: 12345678A");
			return false;
		}
	}
	
	// Se podría hacer la contraseña con un patrón
	/** Método que comprueba que la contraseña tiene al menos 8 carácteres
	 * @param contraseña
	 */
	public void comprobarContrasena(String contrasena) {
		if(contrasena.length() < 8) {
			JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 8 carácteres");
		}
	}

	/** Método que comprueba que el correo cumple el patrón
	 * @param correo
	 * @return true si lo cumple, false si no lo cumple
	 */
	public static boolean comprobarCorreo(String correo, boolean showErrorWindow) {
		if(patCorreo.matcher(correo).matches()) {
			System.out.println(correo + " cumple el patrón");
			return patCorreo.matcher(correo).matches();
		} else {
			if(showErrorWindow)
			System.out.println(correo + " no cumple el patrón");
			JOptionPane.showMessageDialog(null, "Correo no válido");
			return false;
		}
	}

	
	
	/////////////////////////////////////////////////////////////////////
	//                      MAIN                                       //
	/////////////////////////////////////////////////////////////////////

	
	
	
	public static void main(String[] args) {
		RegistrarAdmin ventRegistrarAdmin = new RegistrarAdmin(); 
		ventRegistrarAdmin.setVisible(true);


	}


	

	
	
	
}







