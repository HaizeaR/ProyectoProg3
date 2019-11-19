package Ventanas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalaYAsientos2 extends JFrame {
	
	final static int FILAS = 4;
	final static int COLUMNAS = 4;
	final static ImageIcon iconoOcupado = new ImageIcon("src/img/asiento_r.png");
	final static ImageIcon iconoLibre = new ImageIcon("src/img/asiento_v.png"); 

	public SalaYAsientos2() {
		setSize(600,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(FILAS, COLUMNAS));
		panel.setBounds(20, 70, 200, 140);
		
		for(int y=0; y<COLUMNAS; y++) {
			for(int x=0; x<FILAS; x++) {
				JButton button = new JButton(iconoLibre);
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton buttonPressed = (JButton) e.getSource();
						if(buttonPressed.getIcon().equals(iconoLibre)) {
							buttonPressed.setIcon(iconoOcupado);
						} else {
							buttonPressed.setIcon(iconoLibre);
						}
						
					}
				});
				panel.add(button);
			}
		}
		
	
		getContentPane().add(panel, BorderLayout.NORTH);
		
		
		
	}

	public static void main(String[] args) {
		SalaYAsientos2 ventSYA = new SalaYAsientos2(); 
		ventSYA.setVisible(true);
	}
	
}