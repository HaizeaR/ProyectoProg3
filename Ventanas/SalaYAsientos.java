package Ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

import Elementos.*;

/** Ventana de selección de asientos
 * 
 * Verde - Seleccionado
 * Gris - Libre
 * Rojo - Ocupado ( no puede comprarse) 
 * 
 * @author Unai, Mireya y Haizea
 *
 */
public class SalaYAsientos extends JFrame {
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel pButacas,pInfoCompra, pBotonera; 

	 JButton bSiguente, bAtras; 
	 JLabel lPelicula, lSala, lHora; 


	public SalaYAsientos() {
		setSize(600,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		 pInfoCompra = new JPanel(); 
		getContentPane().add(pInfoCompra, BorderLayout.NORTH);
		
		lPelicula = new JLabel("Pelicula: "); 
		lHora = new JLabel("Hora: "  ); 
		lSala = new JLabel("Sala: "); 
		
		
		pInfoCompra.add(lPelicula); 
		pInfoCompra.add( lHora);
		pInfoCompra.add( lSala );
		
		pButacas = new JPanel(); 
		getContentPane().add(pInfoCompra, BorderLayout.CENTER);
		
		// Añadiriamos los asientos 
		
		pBotonera = new JPanel(); 
		getContentPane().add(pInfoCompra, BorderLayout.SOUTH);
		
		bSiguente = new JButton("Siguente"); 
		bAtras = new JButton("Atras");
	
		pBotonera.add(bAtras); 
		pBotonera.add(bSiguente); 
		
		bAtras.addActionListener((ActionEvent e) -> {volverAtras();});
		bSiguente.addActionListener((ActionEvent e) -> {accedeLogin();} );
		
		
		
		
	
		
		
		
		
		
		
	}
	
	private void volverAtras() {
		Thread t1 = new Thread() {
			public void run() {
				//LogIn.guardaConfig();
				setVisible(false);
				PeliculaIndividual.main(null); 

				dispose();
			}				
		}; 
		t1.start();
	}
	
	
	
	/** Método que contiene el hilo que nos permite
	 * cambiar de ventana de ASientos a ventana LOGIN 
	 */
	private void accedeLogin() {
		Thread t2 = new Thread() {
			public void run() {
				//LogIn.guardaConfig();
				setVisible(false);
				LogIn.main(null); 

				dispose();
			}				
		}; 
		t2.start();
	}
	
	public void dibujaAsiento() {
		Asiento a = new Asiento(1, 5, 5, 10);
		//a.dibujar();
	}
	

	public static void main(String[] args) {
		SalaYAsientos ventSYA = new SalaYAsientos(); 
		ventSYA.setVisible(true);
	}
	
}
