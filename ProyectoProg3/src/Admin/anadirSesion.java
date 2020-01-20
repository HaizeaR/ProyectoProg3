




package Admin;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BD.BDprueba2;

import Elementos.Sesion;

/**
 * Clase que permite a un ADMINISTRADOR registrar // añadir un nueva SESION  
 * @author Unai Mendiondo, Mireya Quintana, Haizea Rodriguez
 *
 */
public class anadirSesion extends JFrame {
// luego borrar
	Statement st; 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// cod_sesion, fecha, horaI, ID_SALAm ID_PELI
	JPanel pBotonera, pTitulo, pAnadir; 
	JLabel jlcod_sesion, jlfecha, jlHoraI, jlId_sala, jlId_peli;
	JTextField tfcod_sesion, tffecha, tfHoraI, tfId_sala, tfId_peli; 
	JButton bAdmin, bMenuAdmin, bAnadir; 



	public anadirSesion() {


		setSize(600,400);
		setLocation(300, 200);


		setTitle("Añadir SESION");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );



		/// PANEL AÑADIR /////

		pAnadir = new JPanel(); 

		jlcod_sesion = new JLabel("Codigo de Sesion: "); 
		tfcod_sesion = new JTextField(); 
		pAnadir.add(jlcod_sesion); 
		pAnadir.add(tfcod_sesion);

		jlfecha = new JLabel("Fecha: "); 
		tffecha = new JTextField(); 
		pAnadir.add(jlfecha); 
		pAnadir.add(tffecha);

		jlHoraI = new JLabel ("Hora: "); 
		tfHoraI = new JTextField(); 
		pAnadir.add(jlHoraI); 
		pAnadir.add(tfHoraI);



		jlId_sala = new JLabel ("ID sala: "); 
		tfId_sala = new JTextField(); 
		pAnadir.add(jlId_sala); 
		pAnadir.add(tfId_sala);


		jlId_peli = new JLabel ("ID peli: "); 
		tfId_peli = new JTextField(); 
		pAnadir.add(jlId_peli); 
		pAnadir.add(tfId_peli);


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
		bAnadir.addActionListener((ActionEvent e) -> {crearSesion();});



	}

	// BOTON VOLVER ADMIN
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

	// BOTON CREAR SESION	
	public void crearSesion() {
		// metodo que tiene que guardar datos recibidos en los distintos 
		//tf y guardarlos como datos de nuevo Cliente 

		// Comprobar que ya no está en el array 

		Sesion sesion;

		String cod_sesion = tfcod_sesion.getText(); 
		int codigo = Integer.valueOf(cod_sesion);

		String f = tffecha.getText();
		Date fecha = Date.valueOf(f);

		String hora = tfHoraI.getText();

		String id_s = tfId_sala.getText(); 
		int ID_sala = Integer.valueOf(id_s); 


		String id_p = tfId_peli.getText(); 
		int ID_peli = Integer.valueOf(id_p); 


		// comprobar que en el numero de tarjeta NO tiene letras 
		// si tiene letras que de error y no te deja registrar el cliente 

		sesion  = new Sesion(codigo, fecha, hora, ID_sala, ID_peli);

		// System.out.println(cliente.toString());

		BDprueba2.insertSesion(sesion,st);


	}


	public static void main(String[] args) {
		anadirSesion venAnadirSesion = new anadirSesion(); 
		venAnadirSesion.setVisible(true);
	}


}



