
 
package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;


import javax.swing.*;


import Elementos.Cliente; 
import BD.BD;

/**Ventana que permite registrar a un usuario
 * 
 * @author Unai, Mireya y Haizea
 *
 */

// FALTA: 
// - Meter en base de datos usuario registrado 
// - No guardar un usuario si tienen error de PATRON 
// - 

public class Registro extends JFrame {

	
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	
	
	private static final long serialVersionUID = 1L;
	static JButton  bRegistrar, bAtras;
	static JLabel lCorreo, lContrasena, lNombre, lApellido, lDNI, lNumero_tarjeta, lRegistro; 
	static JTextField tfCorreo,tfNombre, tfApellido, tfDNI, tfNumero_tarjeta; 
	static JPasswordField jpContrasena; 
	long num_tarjeta;

	public static ArrayList<Cliente> clientes = new ArrayList<>();
	
	// Patrón de correo electronico
	public static Pattern patCorreo = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	// Patrón número de tarjeta
	public static Pattern patNumTarjeta = Pattern.compile("[0-9]+");
	
	// Patrón DNI
	public static Pattern patDNI = Pattern.compile("[0-9]{7,8}[A-Za-z]");
	

	public Registro() {

		setSize(600,400);
		setLocation(300, 200);

		setTitle("Registro");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );


		// EDITAR PARA QUE SE VEA 

		JPanel pSuperior = new JPanel();
		getContentPane().add(pSuperior, BorderLayout.NORTH);
		lRegistro = new JLabel("Registro de nuevo usuario");
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
		lNumero_tarjeta = new JLabel("Num tarjeta: "); 


		tfNombre = new JTextField(10);
		tfApellido = new JTextField(10);
		tfDNI = new JTextField(10);
		tfCorreo = new JTextField(20); 
		jpContrasena = new JPasswordField(10);
		tfNumero_tarjeta = new JTextField(15);

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

		pCentral.add(lNumero_tarjeta); 
		pCentral.add(tfNumero_tarjeta);


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
		 

	}

	public void volverAtras() {
		Thread t1 = new Thread() {
			public void run() {
				setVisible(false);
				LogIn.main(null); 

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


				Cliente cliente;

				String nombre = tfNombre.getText(); 
				String apellido = tfApellido.getText();
				
				String DNI = tfDNI.getText();
				comprobarDNI(DNI);
				
				String correo = tfCorreo.getText(); 
				comprobarCorreo(correo, true);
				
				char[] contrasena = jpContrasena.getPassword();
				comprobarContrasena(contrasena);
				

			

				// comprobar que en el numero de tarjeta NO tiene letras 
				// si tiene letras que de error y no te deja registrar el cliente 

				comprobarNumTarjeta(tfNumero_tarjeta.getText(), true);
			
				
				try {
					
				num_tarjeta = Long.parseLong(tfNumero_tarjeta.getText());
				
				}catch(Exception e) {}

				cliente = new Cliente (DNI, nombre,apellido,correo,contrasena,num_tarjeta); 
				BD.clienteInsert(st, cliente);
			
				
				// cliente = new Cliente (nombre,apellido,correo,contrasena,num_tarjeta); 
				//clientes.add(cliente);
				
//				try {
//
//					for(Cliente c: clientes) {
//						
//						if (cliente.equals(c)) {
//							JOptionPane.showMessageDialog(null, "Usuario ya existente");
//							System.out.println("Error");
//							
//						}else {
//							clientes.add(cliente);
//						}
//					}
//					System.out.println(clientes);
//				}
//				catch(Exception e) {}

	}
	
	/** Método que comprueba que el DNI tiene 9 carácteres
	 * @param DNI
	 */
	public static boolean comprobarDNI(String DNI) {
		if(patDNI.matcher(DNI).matches()) {
			System.out.println(DNI + " cumple el patrón");
			return patDNI.matcher(DNI).matches();
		} else {
			System.out.println(DNI + " no cumple el patrón");
			JOptionPane.showMessageDialog(null, "DNI no válido");
			return false;
		}
	}
	
	/** Método que comprueba que la contraseña tiene al menos 8 carácteres
	 * @param contraseña
	 */
	public void comprobarContrasena(char[] contrasena) {
		if(contrasena.length < 8) {
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
	
	/** Método que comprueba que la tarjeta cumple el patrón de tener sólo números
	 * @param numTarjeta
	 * @return true si lo cumple, false si no lo cumple
	 */
	public static boolean comprobarNumTarjeta(String numTarjeta, boolean showErrorWindow) {
		if(patNumTarjeta.matcher(numTarjeta).matches()) {
			System.out.println(numTarjeta + " cumple el patrón");
			return patNumTarjeta.matcher(numTarjeta).matches();
		} else {
			if(showErrorWindow)
			System.out.println(numTarjeta + " no cumple el patrón");
			JOptionPane.showMessageDialog(null, "Número de tarjeta no válido");
			return false;
		}
	}

	public static void main(String[] args) {
		Registro ventRegistrar = new Registro(); 
		ventRegistrar.setVisible(true);


	}


	
	
	// REVISAR - FALTA HACER QUE SALTA MENSAJE CUANDO ES IGUAL 
	// jpContrasena.getPassword().toString() !!! - pasar a string ?? 
	// AREGLAR 
	
	private static void agregarUsuario() {
		if (!tfCorreo.getText().isEmpty() && !jpContrasena.getPassword().toString().isEmpty()) {
			// Añadir resto de campos que NO pueden estar vacios
			
			String com = "";
			try {
				com = "select * from Cliente where nick = '" + tfCorreo.getText() + "'";
				rs = st.executeQuery( com );
				if (!rs.next()) {
			
					com = "insert into Cliente ( correo, contrasena ) values ('"+ 
							tfCorreo.getText() +"', '" + jpContrasena.getPassword().toString() + "')";

				}	

			}

			catch(SQLException e) {
				System.out.println( "Último comando: " + com );
				e.printStackTrace();
			}
		}
	}
	
	
	
}


