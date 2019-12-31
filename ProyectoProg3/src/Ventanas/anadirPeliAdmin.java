package Ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class anadirPeliAdmin extends JFrame {
	
	
	
	JPanel pBotonera, pTitulo, pAnadir; 
	JLabel jlTitulo, jlDescripcion, jlDuracion, jlCodigo; 
	JTextField tfTitulo, tfDescripcion, tfDuracion, tfCodigo; 
	JButton bAdmin, bMenuAdmin; 
	
	
	
	public anadirPeliAdmin() {
		
		
		setSize(600,400);
		setLocation(300, 200);

		setTitle("Añadir Peliculas");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		
		
		
		/// PANEL AÑADIR /////
		
		pAnadir = new JPanel(); 
		
		jlCodigo = new JLabel("Codigo: "); 
		tfCodigo = new JTextField(); 
		pAnadir.add(jlCodigo); 
		pAnadir.add(tfCodigo);
		
		jlTitulo = new JLabel("Titulo: "); 
		tfTitulo = new JTextField(); 
		pAnadir.add(jlTitulo); 
		pAnadir.add(tfTitulo);
		
		jlDescripcion = new JLabel ("Descripcion: "); 
		tfDescripcion = new JTextField(); 
		pAnadir.add(jlDescripcion); 
		pAnadir.add(tfDescripcion);
		
		jlDuracion = new JLabel("Duracion: "); 
		tfDuracion = new JTextField(); 
		
		pAnadir.add(jlDuracion); 
		pAnadir.add(tfDuracion);
		
		getContentPane().add(pAnadir,BorderLayout.CENTER); 
		
		pAnadir.setLayout(new BoxLayout(pAnadir, WIDTH));
		
	///////////
		
		//// BOTONERA 
		
		
		pBotonera = new JPanel(); 
		
		bAdmin = new JButton("Inicio Admin"); 
		pBotonera.add(bAdmin);
		
		bMenuAdmin = new JButton("Menú Admin");
		
		pBotonera.add(bMenuAdmin); 
		

		getContentPane().add(pBotonera, BorderLayout.SOUTH); 
		
		// ACCIONES DE BOTONES 
		
		bAdmin.addActionListener((ActionEvent e) -> {volverAdmin(); } );
		bMenuAdmin.addActionListener((ActionEvent e ) -> {irMenuAdmin();} );

		
		
	}
	
	public void volverAdmin() {
		Thread t = new Thread() {
			public void run() {
				setVisible(false);
				LogInAdmin.main(null); 

				dispose();
			}				
		}; 
		t.start();

	}
	

	public void irMenuAdmin() {
		Thread t1 = new Thread() {
			public void run() {
				setVisible(false);
				FuncionesAdmin.main(null); 

				dispose();
			}				
		}; 
		t1.start();

	}
	
	
	public static void main(String[] args) {
		anadirPeliAdmin venAnadirPeli = new anadirPeliAdmin(); 
		venAnadirPeli.setVisible(true);
	}
	

}
