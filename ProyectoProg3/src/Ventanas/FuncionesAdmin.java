package Ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import BD.BDprueba2;

public class FuncionesAdmin extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pPrincipal; 
	JButton bNuevaPeli, bRegistrarAdmin, bReiniciarBD; 
	Connection con; 
	Statement st; 
	
	public FuncionesAdmin() {
		
		setSize(600,400);
		setLocation(300, 200);

		setTitle("Funciones Admin");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		
		
		pPrincipal = new JPanel(); 
		
		bNuevaPeli = new JButton("Guardar nuevas peliculas"); 
		bReiniciarBD = new JButton("ReiniciarBD");
		
		pPrincipal.add(bNuevaPeli); 
		pPrincipal.add(bReiniciarBD); 
		
		bNuevaPeli.addActionListener((ActionEvent e) -> {guardarPeli();});
		
		bReiniciarBD.addActionListener((ActionEvent e) -> {BDprueba2.reiniciarBD(con);}); 
		// NO FUNCIONA
		
		
		
		
		getContentPane().add(pPrincipal,BorderLayout.CENTER); 
		
		
		
		
	}
	
	
	public void guardarPeli() {
		Thread t = new Thread() {
			public void run() {
				setVisible(false);
				anadirPeliAdmin.main(null); 

				dispose();
			}				
		}; 
		t.start();
		
	}
	
	public static void main(String[] args) {
		FuncionesAdmin vFA = new FuncionesAdmin(); 
		vFA.setVisible(true);
	}
	
}
