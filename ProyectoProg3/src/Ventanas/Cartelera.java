package Ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

// Queremos que se creen paneles de forma recursiva 
// para cada Pelicula que se proyecta esa semana 
// queremos que se muestre en un panel su fotografia 
// Acciones: hacer click en el panel y que se abra la ventana individual correspondiente

/**
 * Ventana que muestra todas las películas de la semana
 * 
 * @author Unai, Mireya y Haizea
 *
 */

public class Cartelera extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3774209182538684535L;
	private static JFrame v;
	private static ArrayList<String> pelis;

	public Cartelera() {

		setSize(600, 600);
		setTitle("Cartelera");
		JPanel cartelera = new JPanel();
		cartelera.setLayout(new GridLayout());
		pelis = new ArrayList();
		pelis.add("Frozen_2.jpg");
		pelis.add( "Vengadores_Endgame.jpg");
		
		for (String peli : pelis) {
			ImageIcon img = new ImageIcon("src/img/" + peli);
			JButton cartelera1 = new JButton(img);
			cartelera.add(cartelera1);
			
			cartelera1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Thread t2 = new Thread() {
						public void run() {

							setVisible(false);
							PeliculaIndividual.main(null);

							dispose();
						}
					};
					t2.start();
				}
			});

			
		}
		getContentPane().add(cartelera, BorderLayout.CENTER);

		////////////////////////// EVENTOS///////////////////////////

		

		

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
				//saveTextFile(getX(), getY(), getHeight(), getWidth());
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
				//loadTextFile();
			}

		});

	}

//	public static void saveTextFile(double x, double y, double height, double width) {
//		try {
//			PrintStream ps = new PrintStream("tamCartelera.txt");
//
//			ps.println(x + ";" + y + ";" + height + ";" + width);
//
//			ps.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	public static void loadTextFile() {
//		try {
//			Scanner sc = new Scanner(new FileInputStream("tamCartelera.txt"));
//			while (sc.hasNext()) {
//				String linea = sc.nextLine();
//				String params[] = linea.split(";");
//				v.setBounds(Integer.parseInt(params[0]), Integer.parseInt(params[1]), Integer.parseInt(params[2]),
//						Integer.parseInt(params[3]));
//				sc.close();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	public static void main(String[] args) {
		Cartelera ventC = new Cartelera();
		ventC.setVisible(true);
	}

}