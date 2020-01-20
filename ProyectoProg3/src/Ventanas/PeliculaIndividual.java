package Ventanas;

import BD.BDprueba2;

import Elementos.TablaHorario;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.log.SysoLogger;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel pPeli, pBotonera, pHorario;

	JLabel lFoto; 
	
	//JTextArea taDescrip; 
	JTextPane tpDescrip;
	JTable tabla; 
	JButton bAtras, bNext; 
	static String pelicula;
	int cod_peli;
	JTable tablaHorario; 
	//TableModel mTabla; 
	JInternalFrame ventanaTabla;  // Frame interno que contiene la tabla horiario 
	
	


	public PeliculaIndividual() {
		setSize(600, 600);
		setTitle("Peli individual");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

		pPeli = new JPanel(); 
		getContentPane().add(pPeli,BorderLayout.CENTER); 
		lFoto = new JLabel( new ImageIcon("src/img/"+ pelicula + ".jpg"));
		

		
		tpDescrip = new JTextPane(); 
		
		
		pPeli.setLayout(new BorderLayout());
		pPeli.add(lFoto, BorderLayout.WEST); 
		pPeli.add(tpDescrip, BorderLayout.NORTH); 


		pHorario = new JPanel(); 
		getContentPane().add(pHorario, BorderLayout.SOUTH); 
		
		
		tablaHorario = new JTable(); 
		tablaHorario.setAutoscrolls(true);
		
	
		pHorario.add(new JScrollPane(tablaHorario), BorderLayout.SOUTH); 
		
		tablaHorario.setEnabled(false);
		
		
		

		pBotonera = new JPanel(); 
		//pBotoneraHorario = new JPanel();
		
		bAtras = new JButton("Atras"); 
		pBotonera.add(bAtras);
		bNext = new JButton ("Siguiente" ); 
		pBotonera.add(bNext);
		getContentPane().add(pBotonera, BorderLayout.NORTH);
		
		/////////
//		Connection con = BDprueba2.initBD("Cine2.db");
//		try {
//			Statement stmt = con.createStatement();
//			String sentSQL = "SELECT * FROM sesion where ID_peli = '" + cod_peli + "'";
//			ResultSet rs = stmt.executeQuery(sentSQL);
//			System.out.println(sentSQL);
//			while( rs.next()) {
//				String horario = rs.getString("horaI");
//				JButton button = new JButton(horario);
//				pBotoneraHorario.add(button);
//			}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		/////////

		
		//pPeli.add(pBotoneraHorario, BorderLayout.EAST);
		
		bAtras.addActionListener((ActionEvent e) -> {volverAtras();});
		bNext.addActionListener((ActionEvent e) -> {SeleccionAsientos(); } );
		tablaHorario.addMouseListener(new MouseAdapter() {
			
			@Override
			public void  mouseClicked(MouseEvent e) {
				if (e.getClickCount()>=2) {
					int fila = tablaHorario.rowAtPoint( e.getPoint() );
					int col = tablaHorario.rowAtPoint(e.getPoint());
					Object valor = tablaHorario.getValueAt( fila, col );
					String v = String.valueOf(valor);
					System.out.println(v);
					
					setVisible(false);

					SalaYAsientos2.main(null);

					dispose();
					
			
			}

			}
		});
	
		
	}

	
	
	// NO 
	
	/** Añade una ventana interna
	 * @param f	Ventana interna a añadir
	 * @param codVentana	Código de esa ventana
	 */
	public void addVentanaInterna( JInternalFrame f, String codVentana ) {
		pPeli.add( f , BorderLayout.SOUTH);
		//JMenuItem menuItem = new JMenuItem( codVentana ); 
		//menuItem.setActionCommand( codVentana );
		f.setName( codVentana );
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

	public int sacarCodigo() {
		Connection con = BDprueba2.initBD("Cine2.db");
		String sentSQL = ""; 
		try {
			
			Statement st = con.createStatement();
			sentSQL = "select * from pelicula where titulo_peli = '" + pelicula + "'";
			System.out.println(sentSQL);
			ResultSet rs = st.executeQuery(sentSQL);
		
			
			
			while(rs.next()) {
			
				cod_peli = rs.getInt("cod_peli");
				
			}
			//rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cod_peli; 
		
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
	

	private void mostrar() {
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new Object[] {"Fecha", "Hora"});
	
		

		Connection conn = BDprueba2.initBD("Cine2.db");
		String SQL = ""; 
		try {
			Statement stat = conn.createStatement();
			SQL = "select fecha,horaI from sesion where ID_peli =" + sacarCodigo() + ""; 
			
			

			ResultSet rs = stat.executeQuery( SQL );
			while(rs.next()) {
						
				modelo.addRow(new Object[] {rs.getString("fecha"),rs.getString("horaI")});
				
			}
			tablaHorario.setModel(modelo);
		}catch(Exception e){
			System.out.println(e);
			
		}
				
	}
	
	
//	public String sacarFechaDeBD() {
//		
//		Connection con = BDprueba2.initBD("Cine2.db");
//		String sentSQL = ""; 
//	
//		try {
//			
//			Statement st = con.createStatement();
//			sentSQL = "select fecha from sesion where ID_peli = '" + cod_peli + "'";
//			System.out.println(sentSQL);
//			ResultSet rs = st.executeQuery(sentSQL);
//		
//			
//			
//			while(rs.next()) {
//				String f = rs.getString("fecha"); 
//				return f; 
//				
//				
//			}
//			//return f;
//			//rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//		
//	}
//	
//	public void diaDeLaSemana() {
//		String fecha = sacarFechaDeBD(); 
//		getDiaSemana(fecha); 
//		System.out.println(getDiaSemana(fecha) );
//
//	}
//
//	
//	public String getDiaSemana(String fecha) {
//		String Valor_dia = null;
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Date fechaActual = null;
//		try {
//			fechaActual = df.parse(fecha);
//		} catch (ParseException e) {
//			System.err.println("No se ha podido parsear la fecha.");
//			e.printStackTrace();
//		}
//		GregorianCalendar fechaCalendario = new GregorianCalendar();
//		fechaCalendario.setTime(fechaActual);
//		int diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
//		if (diaSemana == 1) {
//			Valor_dia = "Domingo";
//		} else if (diaSemana == 2) {
//			Valor_dia = "Lunes";
//		} else if (diaSemana == 3) {
//			Valor_dia = "Martes";
//		} else if (diaSemana == 4) {
//			Valor_dia = "Miercoles";
//		} else if (diaSemana == 5) {
//			Valor_dia = "Jueves";
//		} else if (diaSemana == 6) {
//			Valor_dia = "Viernes";
//		} else if (diaSemana == 7) {
//			Valor_dia = "Sabado";
//		}
//		return Valor_dia;
//	}





	
	
	

	// Vamos a implementar un JTABLE que contanga la información de las seisiones 
	// Creo que podemos crear una estructura 
	// Un HashMap que tenga como clave un String ( nombre de peli) y un SET que tenga 
	// las fechas y los horarios 
	

	
	public static void main(String[] args) {
		PeliculaIndividual v = new PeliculaIndividual(); 
		//TablaHorario th = new TablaHorario(Tabla.leerBD(111)) ; 
		
		//NUEVO
//		TablaHorario tabla = new TablaHorario();
//		tabla.addColumna("Lunes", new String());
//		tabla.addColumna("Martes", new String());
//		tabla.addColumna("Miercoles", new String());
//		tabla.addColumna("Jueves", new String());
//		tabla.addColumna("Viernes", new String());
//		tabla.addColumna("Sabado", new String());
//		tabla.addColumna("Domingo", new String());
		
		
		//	VentanaTabla vT = new VentanaTabla(v, "TABLA", true);
		
		//NUEVO
	//	vT.setTabla(tabla);
		
		

		//VentanaTabla vT = new VentanaTabla(v, "TABLA", true);
		//vT.setTabla(th);
		//vT.setSize(50, 50);
		//v.addVentanaInterna( vT, "TABLA" );
		//vT.setVisible(true);
		
		v.mostrar();
		
	//	v.diaDeLaSemana();
		v.setVisible(true);
		
		v.sacarDatos();
	}
	
	
	
		
		
	}

	
	
	
	
	
	
	

