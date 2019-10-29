package Ventanas;

import javax.swing.JFrame;
import javax.swing.table.TableColumn;

import sun.util.calendar.JulianCalendar;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class PeliculaIndividual extends JFrame{

	JPanel pPeli, pFoto; 
	//JTextArea taDescrip; 
	JTextPane tpDescrip;
	JTable tabla; 
	JButton bAtras; 



	public PeliculaIndividual() {
		setSize(600, 600);
		setTitle("Peli individual");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		pPeli = new JPanel(); 
		getContentPane().add(pPeli, BorderLayout.CENTER); 

		pFoto = new JPanel(); 
		tpDescrip = new JTextPane(); 


		
		pPeli.setLayout(new BorderLayout());
		pPeli.add(pFoto, BorderLayout.WEST); 
		pPeli.add(tpDescrip, BorderLayout.CENTER); 


		tabla = new JTable(); 
		getContentPane().add(tabla, BorderLayout.SOUTH); 

		bAtras = new JButton("Atras"); 
		getContentPane().add(bAtras, BorderLayout.NORTH);


		bAtras.addActionListener((ActionEvent e) -> {volverAtras();});


	}

	/** Método utilizado para volver a la panatalla de la cartelera
	 * Hilo que se activa cuando se pulsa el botón de Atras 
	 * 
	 */
	public void volverAtras() {
		Thread t1 = new Thread() {
			public void run() {
				//LogIn.guardaConfig();
				setVisible(false);
				Cartelera.main(null); 

				dispose();
			}				
		}; 
		t1.start();

	}




	public static void main(String[] args) {
		PeliculaIndividual v = new PeliculaIndividual(); 
		v.setVisible(true);
	}

}
