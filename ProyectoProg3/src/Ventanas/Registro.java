package ProyectoProg3.src.Ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ProyectoProg3.src.Elementos.Cliente; 

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton  bRegistrar, bAtras;
	JLabel lCorreo, lContraseña, lNombre, lApellido, lNumero_tarjeta, lRegistro; 
	JTextField tfCorreo,tfNombre, tfApellido, tfNumero_tarjeta; 
	JPasswordField jpContraseña; 

	public static ArrayList<Cliente> clientes = new ArrayList<>(); 


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
		lContraseña = new JLabel("Contraseña :");
		lNombre = new JLabel("Nombre: "); 
		lApellido = new JLabel("Apellido: "); 
		lNumero_tarjeta = new JLabel("Num tarjeta: "); 


		tfNombre = new JTextField(10);
		tfApellido = new JTextField(10); 
		tfCorreo = new JTextField(20); 
		jpContraseña = new JPasswordField(10);
		tfNumero_tarjeta = new JTextField(15);

		pCentral.add(lNombre); 
		pCentral.add(tfNombre);

		pCentral.add(lApellido); 
		pCentral.add(tfApellido);


		pCentral.add(lCorreo);
		pCentral.add(tfCorreo);

		pCentral.add(lContraseña);
		pCentral.add(jpContraseña); 

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
	// Sacar error si falta algun dato o tiene algÃºn dato incorrecto(de un tipo no deseado) 
	// No permitir que se registre un correo ya registrado? 

	public void Registrar() {
		// metodo que tiene que guardar datos recibidos en los distintos 
		//tf y guardarlos como datos de nuevo Cliente 

		Thread t2 = new Thread() {
			public void run() {
				// Comprobar que ya no estÃ¡ en el array 


				Cliente cliente;

				String nombre = tfNombre.getText(); 
				String apellido = tfApellido.getText(); 
				String correo = tfCorreo.getText(); 
				char[] contraseña = jpContraseña.getPassword();
				// comprobar que en el numero de tarjeta NO tiene letras 
				// si tiene letras que de error y no te deja registrar el cliente 

				long num_tarjeta = Long.parseLong(tfNumero_tarjeta.getText());

				cliente = new Cliente (nombre,apellido,correo,contraseña,num_tarjeta); 

				clientes.add(cliente);

				System.out.println(clientes);	

//					 for(Cliente c: clientes) {
//						 System.out.println("Error");
//							if (c.equals(cliente)) {
//	
//								JOptionPane.showMessageDialog(null, "Usuario ya existente");
//								System.out.println("Error");
//							}else {
//								 clientes.add(cliente);
//							}
//						
//							 
//					 }
//					 System.out.println(clientes);

			}
		};

		t2.start();

	}


	public static void main(String[] args) {
		Registro ventRegistrar = new Registro(); 
		ventRegistrar.setVisible(true);


	}


}



