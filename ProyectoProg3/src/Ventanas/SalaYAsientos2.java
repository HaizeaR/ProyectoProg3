package Ventanas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BD.BDprueba2;
import Elementos.Asiento;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class SalaYAsientos2 extends JFrame {
	
	final static int[] FILAS = {50, 100, 150, 200, 250, 300, 350, 400, 450, 500};
	final static int[] COLUMNAS = {50, 100, 150, 200, 250, 300, 350, 400, 450, 500};
	final static ImageIcon iconoOcupado = new ImageIcon("src/img/asiento_r.png");
	final static ImageIcon iconoLibre = new ImageIcon("src/img/asiento_g.png"); 
	final static ImageIcon iconoSelec = new ImageIcon("src/img/asiento_v.png");
	
	JButton bAtras, bNext; 
	JPanel pBotonera; 
	ArrayList<Asiento> asientos  = new ArrayList<>(); 

	public SalaYAsientos2() {
		setSize(575,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int cod_asiento = 0; 
		
		JPanel panel = new JPanel();
		JPanel pantalla = new JPanel();
		pantalla.setSize(450, 500);
		pantalla.setLocation(getHeight(), getWidth());
		pantalla.setBackground(Color.blue);
		
		
		// cambiar a layout NULL 
		
		
		
		//panel.setLayout(new GridLayout(FILAS, COLUMNAS));
		panel.setLayout(null);
		panel.setBounds(20, 70, 200, 140);
		
		for(int y=50; y<COLUMNAS[COLUMNAS.length - 1]; y= y+50) {
			for(int x=50; x<FILAS[FILAS.length - 1]; x = x+50) {
				JButton button = new JButton(iconoLibre);
				button.setBounds(x, y, 50, 50);
				cod_asiento ++; 
				Asiento a = new Asiento(cod_asiento, x, y, false);
				asientos.add(a);
		
				//System.out.println(a);
				

				getContentPane().add(panel, BorderLayout.CENTER);
				getContentPane().add(pantalla, BorderLayout.NORTH);
				//add(pantalla);
	
				
				button.addActionListener(new ActionListener() {
					
					// Añadir la opcion de que si esta "comprado" se quede en rojo 
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton buttonPressed = (JButton) e.getSource();
						
						
						
						if(buttonPressed.getIcon().equals(iconoLibre)) {
							buttonPressed.setIcon(iconoSelec);
						} else {
							buttonPressed.setIcon(iconoLibre);
						}
						
					}
				});
				//button.setLocation(x+100, y+100);
			
				panel.add(button);
						
			}
		
		}
		
		
	
		pBotonera = new JPanel(); 
		

		bAtras = new JButton("Atras"); 
		pBotonera.add(bAtras);
		bNext = new JButton ("Compra" ); 
		pBotonera.add(bNext);
		getContentPane().add(pBotonera, BorderLayout.SOUTH);

		bAtras.addActionListener((ActionEvent e) -> {volverAtras();});
		
		// tras la compra actualizar los asientos ocupados 
		// cambiar boolean en el momento que cambia el boolean cambiar color a rojo
		
		bNext.addActionListener((ActionEvent e) -> {LogInYCompra(); } );
		
		
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				//BD.initBD();
				
				BDprueba2.abrirConexion("Cine2.db");
			for(Asiento a : asientos) {
				BD.BDprueba2.insertarAsiento(a);
			}
				
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {}
	
			@Override
			public void windowClosed(WindowEvent e) {
				
				BDprueba2.cerrarConexion();
			}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
	
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
	public void LogInYCompra() {
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
	
	
//	public void guardarAsientos() {
//		for(Asiento a: asientos) {
//			BD.BDprueba2.insertarAsiento(a);
//		}
//	};
	
	
	
	
	

	public static void main(String[] args) {
		SalaYAsientos2 ventSYA = new SalaYAsientos2(); 
		ventSYA.setVisible(true);
		
	}
	
}