package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;



// Queremos que se creen paneles de forma recursiva 
// para cada Pelicula que se proyecta esa semana 
// queremos que se muestre en un panel su fotografia 
// Acciones: hacer click en el panel y que se abra la ventana individual correspondiente


/** Ventana que muestra todas las películas de la semana
 * @author Unai, Mireya y Haizea
 *
 */

public class Cartelera extends JFrame {
	
	
	
	JPanel panel; 

	public Cartelera() {
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
	}

	
	public static void main(String[] args) {
		Cartelera ventC = new Cartelera(); 
		ventC.setVisible(true);
	}
	
}
