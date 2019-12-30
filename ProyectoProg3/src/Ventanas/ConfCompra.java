package Ventanas;



import javax.swing.JFrame;

/** Ventana donde se muestran los datos del ticket una vez confirmada la compra
 * @author Unai, Mireya y Haizea
 *
 */
public class ConfCompra extends JFrame {
	
	
	
	
	public ConfCompra(){
		setSize(600,400);
		setLocation(300, 200);
	}
	

	public static void main(String[] args) {
		ConfCompra vc = new ConfCompra(); 
		vc.setVisible(true);
	}

}