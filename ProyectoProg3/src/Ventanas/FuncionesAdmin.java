package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import BD.BDprueba2;

public class FuncionesAdmin extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pPrincipal, pDrch , pNorte; 
	JButton bNuevaPeli, bRegistrarAdmin, bReiniciarBD, bVolver, bNuevoCine, bNuevaSesion; 
	JLabel lbimagen;
	JLabel lInicio; 
	Connection con; 
	Statement st; 
	
	public FuncionesAdmin() {
		
		setSize(600,400);
		setLocation(300, 200);

		setTitle("Funciones Admin");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		
		// PANEL NORTE
		pNorte = new JPanel();
		lInicio = new JLabel("FUNCIONES ADMINISTRADOR"); 
		lInicio.setFont(new java.awt.Font("Tahoma", 1, 18));
		lInicio.setBackground( Color.magenta);
		pNorte.add(lInicio); 
		
		
		
		
		
		//// PANEL PRINCIPAL 
		pPrincipal = new JPanel(); 
		pPrincipal.setLayout(new  BoxLayout(pPrincipal, WIDTH));
		
		
		bNuevaPeli = new JButton("Guardad nueva PELICULA"); 
		bNuevoCine = new JButton("Crear un nuevo CINE"); 
		bNuevaSesion = new JButton("Crear una nueva SESIÓN"); 
		bReiniciarBD = new JButton("Reiniciar BD");
		bVolver = new JButton("Volver"); 
		
		
		pPrincipal.add(bNuevaPeli); 
		pPrincipal.add(bNuevoCine);
		pPrincipal.add(bNuevaSesion);
		pPrincipal.add(bReiniciarBD); 
		pPrincipal.add(bVolver);
		
		
		
		
		//// PANEL DERECHO
		pDrch  = new JPanel();
		lbimagen = new JLabel(new ImageIcon("src/img/icon2.png"));
		lbimagen.setSize(10, 10);
		
		pDrch.add(lbimagen);
		
		
		
		
		
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pPrincipal,BorderLayout.CENTER); 
		getContentPane().add(pDrch, BorderLayout.EAST);
		

		bNuevaPeli.addActionListener((ActionEvent e) -> {guardarPeli();});
		bNuevoCine.addActionListener((ActionEvent e) -> {crearCine();});
		bNuevaSesion.addActionListener((ActionEvent e) -> {crearSesion();});
		bVolver.addActionListener((ActionEvent e) -> {volver();});
		
		//bReiniciarBD.addActionListener((ActionEvent e) -> {BDprueba2.reiniciarBD(con);}); 
		// NO FUNCIONA
		
		
		
		
		
		

	}
	
	
	public void guardarPeli() {
		
				setVisible(false);
				anadirPeliAdmin.main(null); 
				dispose();
			}				
	

	public void volver() {
	
				setVisible(false);
				LogInAdmin.main(null); 
				dispose();
		}				
		 
	public void crearCine() {
		
		setVisible(false);
		anadirCine.main(null); 
		dispose();
	}	
public void crearSesion() {
		
		setVisible(false);
		anadirSesion.main(null); 
		dispose();
	}	
	
	
	
	
	public static void main(String[] args) {
		FuncionesAdmin vFA = new FuncionesAdmin(); 
		vFA.setVisible(true);
	}
	
}
