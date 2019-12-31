package Ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FuncionesAdmin extends JFrame{
	
	
	JPanel pPrincipal; 
	JButton bNuevaPeli, bRegistrarAdmin; 
	
	
	public FuncionesAdmin() {
		
		setSize(600,400);
		setLocation(300, 200);

		setTitle("Funciones Admin");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		
		
		pPrincipal = new JPanel(); 
		
		bNuevaPeli = new JButton("Guardar nuevas peliculas"); 
		pPrincipal.add(bNuevaPeli); 
		
		bNuevaPeli.addActionListener((ActionEvent e) -> {guardarPeli();});
		
		
		
		
		
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
