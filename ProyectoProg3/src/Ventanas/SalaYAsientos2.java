package Ventanas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Elementos.Asiento;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalaYAsientos2 extends JFrame {
	
	final static int[] FILAS = {50, 100, 150, 200, 250, 300, 350, 400, 450, 500};
	final static int[] COLUMNAS = {50, 100, 150, 200, 250, 300, 350, 400, 450, 500};
	final static ImageIcon iconoOcupado = new ImageIcon("src/img/asiento_r.png");
	final static ImageIcon iconoLibre = new ImageIcon("src/img/asiento_g.png"); 
	final static ImageIcon iconoSelec = new ImageIcon("src/img/asiento_v.png");

	public SalaYAsientos2() {
		setSize(575,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int cod_asiento = 0; 
		
		JPanel panel = new JPanel();
		JPanel pantalla = new JPanel();
		pantalla.setSize(450, 500);
		pantalla.setLocation(getHeight(), getWidth());
		pantalla.setBackground(Color.blue);
		
		ImageIcon img = new ImageIcon("src/img/bander30.gif");
		JLabel pantalla2 = new JLabel(img); 
		pantalla2.setBounds(0, 0 , 450, 500);
		add(pantalla2);
		
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
				//BD.BD.asientoInsert(a);
				// metodo añadir a BD 
				
				
				System.out.println(a);
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
		
	
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(pantalla, BorderLayout.NORTH);
		//add(pantalla);
		
	}

	public static void main(String[] args) {
		SalaYAsientos2 ventSYA = new SalaYAsientos2(); 
		ventSYA.setVisible(true);
	}
	
}