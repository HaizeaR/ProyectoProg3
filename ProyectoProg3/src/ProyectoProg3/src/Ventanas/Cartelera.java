package ProyectoProg3.src.Ventanas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JDialog;
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
	private static JFrame v;
	
	

	public Cartelera() {
		
		setSize(600, 600);
		setTitle("Cartelera");
		
	
		addWindowListener(new WindowListener() {		
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				saveTextFile(getX(), getY(), getHeight(), getWidth());
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				loadTextFile();
			}
			
		});
		
	}

	public static void saveTextFile(double x, double y, double height, double width) {
		try {
			PrintStream ps = new PrintStream("tamCartelera.txt");
			
				ps.println(x + ";" + y + ";" + height + ";" + width);
				
			ps.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadTextFile(){
		try {
			Scanner sc = new Scanner(new FileInputStream("tamCartelera.txt"));
			while(sc.hasNext()) {
			String linea = sc.nextLine();
			String params [] = linea.split(";");
			v.setBounds(Integer.parseInt(params[0]), Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]));
			sc.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Cartelera ventC = new Cartelera(); 
		ventC.setVisible(true);
	}
	
}
