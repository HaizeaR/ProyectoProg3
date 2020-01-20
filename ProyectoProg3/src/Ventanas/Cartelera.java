package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import Admin.LogInAdmin;
import BD.BDprueba2;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BackgroundImage;

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
	public static ArrayList<String> pelis;
	public static String pelicula;
	static Connection con;

	public Cartelera() {

		setSize(600, 600);
		setTitle("Cartelera");
		con = BDprueba2.conexion;
		pelis = new ArrayList<String>();
		pelis.add("Frozen2.jpg");	
		pelis.add( "VengadoresEndgame.jpg");
		pelis.add("Jumanji.jpg");
		pelis.add("Interestelar.jpg");
		
		JPanel panelContenidos = new JPanel();
		panelContenidos.setBackground(Color.WHITE);
		panelContenidos.setLayout(new BorderLayout());
		setContentPane(panelContenidos);
		
		JPanel norte = new JPanel();  
		norte.setBackground(Color.WHITE);
		norte.setLayout(new GridLayout(1,1));
		
		panelContenidos.add(norte, BorderLayout.NORTH);
		
		JLabel imagen = new JLabel(new ImageIcon("src/img/screen.png"));
		norte.add(imagen);
		
		
		JPanel cartelera = new JPanel();
		cartelera.setBackground(Color.WHITE);
		cartelera.setLayout(new GridLayout(2, 2));
		
		panelContenidos.add(cartelera, BorderLayout.CENTER);
		
		 
		//OPCION 2
		JScrollPane sp = new JScrollPane(cartelera);
		panelContenidos.add(sp, BorderLayout.CENTER);
		
		 // Scroll
		
		for (String peli : pelis) {
			ImageIcon img = new ImageIcon("src/img/" + peli);
			
			JButton cartelera1 = new JButton(img);
			
			
			
			//REVISAR
			//cartelera1.setMargin(new Insets(0, 0, 0, 0));

			cartelera1.setSize(img.getIconWidth(), img.getIconHeight());
			
			
			cartelera.add(cartelera1);
			
			cartelera1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Thread t2 = new Thread() {
						public void run() {
							
							setVisible(false);
							PeliculaIndividual.nombrePeli(peli);
							PeliculaIndividual.main(null);

							dispose();
						}
					};
					t2.start();
				}
			});

			
		}
		
	
		//getContentPane().add(imagen, BorderLayout.NORTH);
		getContentPane().add(cartelera, BorderLayout.CENTER);
		
		JButton bAdmin = new JButton("Administrador"); 
		
		
		
		
		getContentPane().add(bAdmin, BorderLayout.SOUTH); 
		// Scroll
		getContentPane().add(sp, BorderLayout.WEST);
		// Scroll

		////////////////////////// EVENTOS///////////////////////////

		

		

//		addWindowListener(new WindowListener() {
//
//			@Override
//			public void windowClosed(WindowEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void windowActivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				//saveTextFile(getX(), getY(), getHeight(), getWidth());
//				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//			}
//
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void windowIconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void windowOpened(WindowEvent e) {
//				// TODO Auto-generated method stub
//				//loadTextFile();
//				//BD.BDprueba2.abrirConexion("Cine2.db");
//			}
//
//		});
		
		
		bAdmin.addActionListener((ActionEvent e) -> {irAdmin();});

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
	
	
	private void irAdmin() {
		Thread t4 = new Thread() {
			public void run() {
				
				
				  String c = JOptionPane.showInputDialog("Clave ADMIN");
				  
				  // solo se abre la ventana de ADMIN si se introduce código 
				  // 123
				  // mejorar seguridad de esto ?
				  
				  if (c.compareTo("123") == 0) {
					  setVisible(false);
						LogInAdmin.main(null); 

						dispose();
				  }
				
				
				
			}				
		}; 
		t4.start();
		
	}
	

	public static void main(String[] args) {
		Cartelera ventC = new Cartelera();
		ventC.setVisible(true);
	}

}