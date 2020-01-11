package Ventanas;

import BD.BDprueba2;
import Elementos.Asiento;

import javax.swing.*;
import javax.swing.table.TableModel;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.prism.Image;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Ventana donde se muestra información de la perlicula individual
 * con sus horarios
 * @author Unai, Mireya y Haizea
 *
 */
public class PeliculaIndividual extends JFrame{

	
	
	JPanel pPeli, pBotonera, pBotoneraHorario;

	JLabel lFoto; 
	
	//JTextArea taDescrip; 
	JTextPane tpDescrip;
	JTable tabla; 
	JButton bAtras, bNext; 
	static String pelicula;
	int cod_peli;
	JTable tablaHorario; 
	TableModel mTabla; 


	public PeliculaIndividual() {
		setSize(600, 600);
		setTitle("Peli individual");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

		pPeli = new JPanel(); 
		getContentPane().add(pPeli,BorderLayout.CENTER); 
		lFoto = new JLabel( new ImageIcon("src/img/"+ pelicula + ".jpg"));
		
		
		//Image img2 = new 
		
//		ImageIcon img = new ImageIcon("src/img/" + peli);
//		JButton cartelera1 = new JButton(img);
//		
		tpDescrip = new JTextPane(); 
		
		
	
		


		pPeli.setLayout(new BorderLayout());
		pPeli.add(lFoto, BorderLayout.WEST); 
		pPeli.add(tpDescrip, BorderLayout.NORTH); 

		

		tablaHorario = new JTable(); 
		getContentPane().add(tablaHorario,BorderLayout.SOUTH);
		

		pBotonera = new JPanel(); 
		pBotoneraHorario = new JPanel();
		
		bAtras = new JButton("Atras"); 
		pBotonera.add(bAtras);
		bNext = new JButton ("Siguiente" ); 
		pBotonera.add(bNext);
		getContentPane().add(pBotonera, BorderLayout.NORTH);
		
		/////////
		Connection con = BDprueba2.initBD("Cine2.db");
		try {
			Statement stmt = con.createStatement();
			String sentSQL = "SELECT * FROM sesion where ID_peli = '" + cod_peli + "'";
			ResultSet rs = stmt.executeQuery(sentSQL);
			System.out.println(sentSQL);
			while( rs.next()) {
				String horario = rs.getString("horaI");
				JButton button = new JButton(horario);
				pBotoneraHorario.add(button);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		/////////

		
		pPeli.add(pBotoneraHorario, BorderLayout.EAST);
		
		bAtras.addActionListener((ActionEvent e) -> {volverAtras();});
		bNext.addActionListener((ActionEvent e) -> {SeleccionAsientos(); } );
		
	}
	
	public static void nombrePeli(String peli) {
		
		pelicula = peli.substring(0, peli.length()-4);
		System.out.println(pelicula);
	}
	
	public void sacarDatos() {
		Connection con = BDprueba2.initBD("Cine2.db");
		String sentSQL = ""; 
		try {
			
			Statement st = con.createStatement();
			sentSQL = "select * from pelicula where titulo_peli = '" + pelicula + "'";
			System.out.println(sentSQL);
			ResultSet rs = st.executeQuery(sentSQL);
		
			
			
			while(rs.next()) {
				System.out.println("entra");
				String titulo = rs.getString("titulo_peli");
				String descripcion = rs.getString("descrip_peli");
				cod_peli = rs.getInt("cod_peli");
				System.out.println(descripcion);
				int duracion = rs.getInt("duracion_peli");
				tpDescrip.setText(descripcion);
			}
			//rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
	public void SeleccionAsientos() {
		Thread t2 = new Thread() {
			public void run() {
				//LogIn.guardaConfig();
				setVisible(false);
				SalaYAsientos2.main(null); 

				dispose();
			}				
		}; 
		t2.start();
		
	}
	

// Vamos a implementar un JTABLE que contanga la información de las seisiones 
	// Creo que podemos crear una estructura 
	// Un HashMap que tenga como clave un String ( nombre de peli) y un SET que tenga 
	// las fechas y los horarios 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		PeliculaIndividual v = new PeliculaIndividual(); 
		v.setVisible(true);
		v.sacarDatos();
	}

}