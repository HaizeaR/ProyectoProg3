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
	JButton bNuevaPeli, bRegistrarAdmin, bReiniciarBD, bVolver; 
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
		bVolver = new JButton("Volver"); 
		
		pPrincipal.add(bNuevaPeli); 
		pPrincipal.add(bReiniciarBD); 
		pPrincipal.add(bVolver);

		bNuevaPeli.addActionListener((ActionEvent e) -> {guardarPeli();});
		bVolver.addActionListener((ActionEvent e) -> {volver();});
		
		//bReiniciarBD.addActionListener((ActionEvent e) -> {BDprueba2.reiniciarBD(con);}); 
		// NO FUNCIONA
		
		
		
		
		getContentPane().add(pPrincipal,BorderLayout.CENTER); 
		

	}
	
	
	public void guardarPeli() {
		
				setVisible(false);
				anadirPeliAdmin.main(null); 
				dispose();
			}				
	

	public void volver() {
	
				setVisible(false);
				LogInAdmin.main(null); 
				dispose();
		}				
		 
	
		
	
	
	
	public static void main(String[] args) {
		FuncionesAdmin vFA = new FuncionesAdmin(); 
		vFA.setVisible(true);
	}
	
}
