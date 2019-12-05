package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInAdmin extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JButton bRegistrar, bAtras;
	static JLabel lCorreo, lContrasena,lLogin; 
	static JTextField tfCorreo; 
	static JPasswordField jpContrasena; 
	//private static JDialog v;
	

	

	public LogInAdmin() {
		
		setSize(600,400);
		setLocation(300, 200);
		setTitle("LOG IN ADMIN");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		
		
		// EDITAR PARA QUE SE VEA 
		
		JPanel pSuperior = new JPanel();
		getContentPane().add(pSuperior, BorderLayout.NORTH);
		lLogin = new JLabel("LOG IN ADMIN");
		lLogin.setFont(new java.awt.Font("Tahoma", 1, 18));
		pSuperior.add(lLogin);
		
		
		JPanel pInfoCompra = new JPanel(); 
		
		// Definir más adelante 
		// tenemos que meter en un panel la información de compra
		// fecha, hora , asientos ... 
		
		pInfoCompra.setBackground(Color.white);
		getContentPane().add(pInfoCompra, BorderLayout.NORTH);
		
		JPanel pCentral = new JPanel(); 
		
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
		bRegistrar = new JButton("Registrar"); 
		bAtras = new JButton("Atras");
	
		pBotonera.add(bAtras); 
		pBotonera.add(bRegistrar); 
		
		
		// Action Events para los botones 
		
		bAtras.addActionListener((ActionEvent e) -> {volverAtrasA();});
		bRegistrar.addActionListener((ActionEvent e) -> {accedeRegistroA(); } );

		
	
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
