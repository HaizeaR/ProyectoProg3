package Ventanas;

import javax.swing.JFrame;

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

	public SalaYAsientos() {
		setSize(600,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		SalaYAsientos ventSYA = new SalaYAsientos(); 
		ventSYA.setVisible(true);
	}
	
}
