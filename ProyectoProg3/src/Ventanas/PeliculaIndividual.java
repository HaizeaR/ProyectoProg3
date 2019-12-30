package Ventanas;

import javax.swing.table.TableColumn;

import BD.BDprueba2;
import sun.util.calendar.JulianCalendar;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/** Ventana donde se muestra información de la perlicula individual
 * con sus horarios
 * @author Unai, Mireya y Haizea
 *
 */
public class PeliculaIndividual extends JFrame{

	JPanel pPeli, pFoto, pBotonera; 
	//JTextArea taDescrip; 
	JTextPane tpDescrip;
	JTable tabla; 
	JButton bAtras, bNext; 
	



	public PeliculaIndividual() {
		setSize(600, 600);
		setTitle("Peli individual");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ImageIcon img = new ImageIcon("src/img/" + peli);

		pPeli = new JPanel(); 
		getContentPane().add(pPeli, BorderLayout.CENTER); 

		pFoto = new JPanel(); 
		
		
		
		
//		ImageIcon img = new ImageIcon("src/img/" + peli);
//		JButton cartelera1 = new JButton(img);
//		
		
		tpDescrip = new JTextPane(); 


		pPeli.setLayout(new BorderLayout());
		pPeli.add(pFoto, BorderLayout.WEST); 
		pPeli.add(tpDescrip, BorderLayout.CENTER); 


		tabla = new JTable(); 
		getContentPane().add(tabla, BorderLayout.SOUTH); 

		pBotonera = new JPanel(); 
		

		
		bAtras = new JButton("Atras"); 
		pBotonera.add(bAtras);
		bNext = new JButton ("Siguiente" ); 
		pBotonera.add(bNext);
		getContentPane().add(pBotonera, BorderLayout.NORTH);

		bAtras.addActionListener((ActionEvent e) -> {volverAtras();});
		bNext.addActionListener((ActionEvent e) -> {SeleccionAsientos(); } );
		
	}
	
	public void sacarDatos() {
		Connection con = BDprueba2.initBD("peliculas.bd");
		
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

	/** Método utilizado para ir a la ventana de selección de asientos 
	 * Hilo que se activa cuando se pulsa el botón Siguente
	 * 
	 */
	public void SeleccionAsientos() {
		Thread t2 = new Thread() {
			public void run() {
				//LogIn.guardaConfig();
				setVisible(false);
				SalaYAsientos2.main(null); 

				dispose();
			}				
		}; 
		t2.start();
		
	}
	


	public static void main(String[] args) {
		PeliculaIndividual v = new PeliculaIndividual(); 
		v.setVisible(true);
	}

}