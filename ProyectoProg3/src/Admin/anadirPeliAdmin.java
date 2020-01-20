package Admin;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BD.BDprueba2;

import Elementos.Pelicula;

/**
 * Clase que permite a un ADMINISTRADOR registrar // añadir una nueva PELI 
 * @author Unai Mendiondo, Mireya Quintana, Haizea Rodriguez
 *
 */
public class anadirPeliAdmin extends JFrame {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel pBotonera, pTitulo, pAnadir; 
	JLabel jlTitulo, jlDescripcion, jlDuracion, jlCodigo; 
	JTextField tfTitulo, tfDescripcion, tfDuracion, tfCodigo; 
	JButton bAdmin, bMenuAdmin, bAnadir; 
	
	
	
	public anadirPeliAdmin() {
		
		
		setSize(600,400);
		setLocation(300, 200);

		setTitle("Añadir Peliculas");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		
		
		
		/// PANEL AÑADIR /////
		
		pAnadir = new JPanel(); 
		
		jlCodigo = new JLabel("Codigo: "); 
		tfCodigo = new JTextField(); 
		pAnadir.add(jlCodigo); 
		pAnadir.add(tfCodigo);
		
		jlTitulo = new JLabel("Titulo: "); 
		tfTitulo = new JTextField(); 
		pAnadir.add(jlTitulo); 
		pAnadir.add(tfTitulo);
		
		jlDescripcion = new JLabel ("Descripcion: "); 
		tfDescripcion = new JTextField(); 
		pAnadir.add(jlDescripcion); 
		pAnadir.add(tfDescripcion);
		
		jlDuracion = new JLabel("Duracion: "); 
		tfDuracion = new JTextField(); 
		
		pAnadir.add(jlDuracion); 
		pAnadir.add(tfDuracion);
		
		getContentPane().add(pAnadir,BorderLayout.CENTER); 
		
		pAnadir.setLayout(new BoxLayout(pAnadir, WIDTH));
		
		
		
		//// BOTONERA 
		
		
		pBotonera = new JPanel(); 
		
		bAdmin = new JButton("Inicio Admin"); 
		pBotonera.add(bAdmin);
		
		bMenuAdmin = new JButton("Menú Admin");
		pBotonera.add(bMenuAdmin); 
		
		bAnadir = new JButton("Anadir"); 
		pBotonera.add(bAnadir);
		
		

		getContentPane().add(pBotonera, BorderLayout.SOUTH); 
		
		// ACCIONES DE BOTONES 
		
		bAdmin.addActionListener((ActionEvent e) -> {volverAdmin(); } );
		bMenuAdmin.addActionListener((ActionEvent e ) -> {irMenuAdmin();} );
		bAnadir.addActionListener((ActionEvent e) -> {anadiPeli();});
		
		

	}
	// BOTON VOLVER
	public void volverAdmin() {
		
				setVisible(false);
				LogInAdmin.main(null); 
				dispose();
		
	}
	
	// BOTON IR A MENÚ
	public void irMenuAdmin() {
	
				setVisible(false);
				FuncionesAdmin.main(null); 
				dispose();
		

	}
	
	// BOTON AÑADIR PELI
	public void anadiPeli() {
		// metodo que tiene que guardar datos recibidos en los distintos 
		//tf y guardarlos como datos de nuevo Cliente 
		
				// Comprobar que ya no está en el array 

				Pelicula peli;

				String codigo = tfCodigo.getText(); 
				int cod = Integer.valueOf(codigo);
				
			 
				String titulo = tfTitulo.getText();
				
				String descrip = tfDescripcion.getText();
				
				String duracion = tfDuracion.getText(); 
				int dur = Integer.valueOf(duracion);

				// comprobar que en el numero de tarjeta NO tiene letras 
				// si tiene letras que de error y no te deja registrar el cliente 

				 peli = new Pelicula(cod, titulo, descrip, dur);
				// System.out.println(cliente.toString());
				
				  BDprueba2.insertPelicula(peli);
			
				
			
			
				

	}
	
	// MAIN 
	public static void main(String[] args) {
		anadirPeliAdmin venAnadirPeli = new anadirPeliAdmin(); 
		venAnadirPeli.setVisible(true);
	}
	

}
