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
import Elementos.Cine;

/**
 * Clase que permite a un ADMINISTRADOR registrar // añadir un nuevo CINE 
 * @author Unai Mendiondo, Mireya Quintana, Haizea Rodriguez
 *
 */
public class anadirCine extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel pBotonera, pTitulo, pAnadir; 
	JLabel jlID, jlNombre, jlDir;
	JTextField tfID, tfNombre, tfDir; 
	JButton bAdmin, bMenuAdmin, bAnadir; 



	public anadirCine() {


		setSize(600,400);
		setLocation(300, 200);

		setTitle("Crear CINE");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );



		/// PANEL AÑADIR /////

		pAnadir = new JPanel(); 

		jlID = new JLabel("ID cine: "); 
		tfID = new JTextField(); 
		pAnadir.add(jlID); 
		pAnadir.add(tfID);

		jlNombre = new JLabel("Nombre cine: "); 
		tfNombre = new JTextField(); 
		pAnadir.add(jlNombre); 
		pAnadir.add(tfNombre);

		jlDir = new JLabel ("Dirección: "); 
		tfDir = new JTextField(); 
		pAnadir.add(jlDir); 
		pAnadir.add(tfDir);



		getContentPane().add(pAnadir,BorderLayout.CENTER); 

		pAnadir.setLayout(new BoxLayout(pAnadir, WIDTH));

		///////////

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
		bAnadir.addActionListener((ActionEvent e) -> {crearCine();});

	}

	// BOTON AÑADIR
	public void volverAdmin() {

		setVisible(false);
		LogInAdmin.main(null); 
		dispose();

	}

	// BOTOTN IR A MENÚ
	public void irMenuAdmin() {

		setVisible(false);
		FuncionesAdmin.main(null); 

		dispose();

	}

	// BOTON CREAR CINE 
	public void crearCine() {
		
		// metodo que tiene que guardar datos recibidos en los distintos 
		//tf y guardarlos como datos de nuevo Cliente 

		// Comprobar que ya no está en el array 

		Cine cine;

		String id = tfID.getText(); 
		int ID = Integer.valueOf(id);


		String nombre = tfNombre.getText();

		String dir = tfDir.getText();

		// comprobar que en el numero de tarjeta NO tiene letras 
		// si tiene letras que de error y no te deja registrar el cliente 

		cine = new Cine(ID, nombre, dir);
		// System.out.println(cliente.toString());

		BDprueba2.insertCine(cine);






	}

	// MAIN 
	public static void main(String[] args) {
		anadirCine venAnadirCine = new anadirCine(); 
		venAnadirCine.setVisible(true);
	}


}


