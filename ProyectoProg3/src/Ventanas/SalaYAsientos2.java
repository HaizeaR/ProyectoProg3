package Ventanas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.ws.api.Component;

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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SalaYAsientos2 extends JFrame {

	final static int[] FILAS = { 50, 100, 150, 200, 250, 300, 350, 400, 450, 500 };
	final static int[] COLUMNAS = { 50, 100, 150, 200, 250, 300, 350, 400, 450, 500 };
	final static ImageIcon iconoOcupado = new ImageIcon("src/img/asiento_r.png");
	final static ImageIcon iconoLibre = new ImageIcon("src/img/asiento_g.png");
	final static ImageIcon iconoSelec = new ImageIcon("src/img/asiento_v.png");
	final static ArrayList<Asiento> codigoAS = new ArrayList<Asiento>();
	static String codS;
	static String id_sala;
	static String pelicula;
	static String horaI;
	static String fecha;

	final static JPanel panel = new JPanel();
	JButton bAtras, bNext;
	JPanel pBotonera;
	static ArrayList<Asiento> asientos = new ArrayList<>();
	Connection con;
	Statement st;

	public SalaYAsientos2() {
		setSize(575, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
// int cod_asiento = 0;

		JPanel pantalla = new JPanel();
		pantalla.setSize(450, 500);
		pantalla.setLocation(getHeight(), getWidth());
		pantalla.setBackground(Color.blue);

// cambiar a layout NULL

// panel.setLayout(new GridLayout(FILAS, COLUMNAS));
		panel.setLayout(null);
		panel.setBounds(20, 70, 200, 140);

		if (compruebaEsixte() == false) {
			System.out.println("Creando asientos: ");
			int codigo_asiento = 0;
			for (int y = 50; y < COLUMNAS[COLUMNAS.length - 1]; y = y + 50) {
				for (int x = 50; x < FILAS[FILAS.length - 1]; x = x + 50) {
					JButton button = new JButton(iconoLibre);
					button.setBounds(x, y, 50, 50);
					codigo_asiento++;
					Asiento a = new Asiento(codigo_asiento, x, y, false, Integer.parseInt(PeliculaIndividual.codSala));
					System.out.println(a.toString());
					asientos.add(a);

					button.addActionListener(new ActionListener() {

// Añadir la opcion de que si esta "comprado" se quede en rojo

						@Override
						public void actionPerformed(ActionEvent e) {
							JButton buttonPressed = (JButton) e.getSource();

							if (buttonPressed.getIcon().equals(iconoLibre)) {
								buttonPressed.setIcon(iconoSelec);
							} else {
								buttonPressed.setIcon(iconoLibre);
							}

						}
					});
// button.setLocation(x+100, y+100);

					panel.add(button);

				}
				cargaAsientos();
			}
		} else {
			System.out.println("Sacando asientos de base de datos");
			Connection con = BDprueba2.initBD("Cine2.db");
			try {
				Statement stmt = con.createStatement();
				String sentSQL = "SELECT * FROM asiento where ID_sala = " + PeliculaIndividual.codSala ;
				ResultSet rs = stmt.executeQuery(sentSQL);

				while (rs.next()) {
					int cod_asiento = rs.getInt("codigo");
					int fila = rs.getInt("fila");
					int columna = rs.getInt("columna");
					boolean ocupado = rs.getBoolean("ocupado");
					JButton button = new JButton(iconoLibre);
					button.setBounds(fila, columna, 50, 50);
					Asiento a = new Asiento(cod_asiento, fila, columna, ocupado, Integer.parseInt(PeliculaIndividual.codSala));
					asientos.add(a);

					getContentPane().add(panel, BorderLayout.CENTER);
					getContentPane().add(pantalla, BorderLayout.NORTH);
// add(pantalla);

					button.addActionListener(new ActionListener() {

// Añadir la opcion de que si esta "comprado" se quede en rojo

						@Override
						public void actionPerformed(ActionEvent e) {
							JButton buttonPressed = (JButton) e.getSource();

							if (buttonPressed.getIcon().equals(iconoLibre)) {
								buttonPressed.setIcon(iconoSelec);
							} else {
								buttonPressed.setIcon(iconoLibre);
							}

						}
					});
// button.setLocation(x+100, y+100);

					panel.add(button);

				}
				rs.close();

			} catch (SQLException e) {
// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

// for(int y=50; y<COLUMNAS[COLUMNAS.length - 1]; y= y+50) {
// for(int x=50; x<FILAS[FILAS.length - 1]; x = x+50) {
// JButton button = new JButton(iconoLibre);
// button.setBounds(x, y, 50, 50);
// cod_asiento ++;
// Asiento a = new Asiento(cod_asiento, x, y, false);
// asientos.add(a);

// System.out.println(a);

//
// getContentPane().add(panel, BorderLayout.CENTER);
// getContentPane().add(pantalla, BorderLayout.NORTH);
// //add(pantalla);
//
//
// button.addActionListener(new ActionListener() {
//
// // Añadir la opcion de que si esta "comprado" se quede en rojo
//
// @Override
// public void actionPerformed(ActionEvent e) {
// JButton buttonPressed = (JButton) e.getSource();
//
//
//
// if(buttonPressed.getIcon().equals(iconoLibre)) {
// buttonPressed.setIcon(iconoSelec);
// } else {
// buttonPressed.setIcon(iconoLibre);
// }
//
// }
// });
// //button.setLocation(x+100, y+100);
//
// panel.add(button);
//
// }
//
// }

		pBotonera = new JPanel();

		bAtras = new JButton("Atras");
		pBotonera.add(bAtras);
		bNext = new JButton("Compra");
		pBotonera.add(bNext);
		getContentPane().add(pBotonera, BorderLayout.SOUTH);

		bAtras.addActionListener((ActionEvent e) -> {
			volverAtras();
		});

// tras la compra actualizar los asientos ocupados
// cambiar boolean en el momento que cambia el boolean cambiar color a rojo

		bNext.addActionListener((ActionEvent e) -> {
			LogInYCompra();
		});

		addWindowListener(new WindowListener() {

			@Override

			public void windowOpened(WindowEvent e) {
				// if (compruebaEsixte() == true) {

// revisar que si está dentro de la BD no lo inserte ??
// creo qye es el error que da
				// cargaAsientos();
				// }

			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
			}

			@Override
			public void windowClosed(WindowEvent e) {

// BDprueba2.cerrarConexion();
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

		});

	}

	public static void cargaAsientos() {
		for (Asiento a : asientos) {
			BDprueba2.insertarAsiento(a);
		}
	}

	public static void crearAsientosBD() {
		Connection con = BDprueba2.initBD("Cine2.db");
		try {
			Statement stmt = con.createStatement();
			String sentSQL = "SELECT * FROM ASIENTO where numero_sala = " + PeliculaIndividual.codSala;
			ResultSet rs = stmt.executeQuery(sentSQL);

			while (rs.next()) {
				int cod_asiento = rs.getInt("codigo");
				int x = rs.getInt("x");
				int y = rs.getInt("y");
				boolean ocupado = rs.getBoolean("ocupado");
				JButton button = new JButton(iconoLibre);
				button.setBounds(x, y, 50, 50);
				Asiento a = new Asiento(cod_asiento, x, y, false, Integer.parseInt(PeliculaIndividual.codSala));
				asientos.add(a);

			}

		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean compruebaEsixte() {
		Connection con = BDprueba2.initBD("Cine2.db");
		try {
			Statement stmt = con.createStatement();
			String sentSQL = "SELECT * FROM ASIENTO where ID_sala = " + PeliculaIndividual.codSala;
			ResultSet rs = stmt.executeQuery(sentSQL);

			while (rs.next()) {
				int cod_asiento = rs.getInt("codigo");
				if (cod_asiento == -1) {
					return false;
				} else {
					return true;
				}
			}

		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Método utilizado para volver a la panatalla de la cartelera Hilo que se
	 * activa cuando se pulsa el botón de Atras
	 *
	 */
	public void volverAtras() {
		Thread t1 = new Thread() {
			public void run() {
// LogIn.guardaConfig();
				setVisible(false);
				Cartelera.main(null);

				dispose();
			}
		};
		t1.start();

	}

	/**
	 * Método utilizado para ir a la ventana de selección de asientos Hilo que se
	 * activa cuando se pulsa el botón Siguente
	 *
	 */
	public void LogInYCompra() {
		Thread t2 = new Thread() {
			public void run() {
// LogIn.guardaConfig();
				setVisible(false);
				getAsientosSeleccionados();
				getCodSesion();
				getId_sala();
				getPelicula();
				getHoraFechaPeli();
				System.out.println("Asientos selccionados: ");
				for (Asiento i : codigoAS) {
					System.out.println(i.toString());
				}
				LogIn.main(null);

				dispose();
			}
		};
		t2.start();

	}
	
	public static void getHoraFechaPeli() {
		Connection con = BDprueba2.initBD("Cine2.db");
		try {
			Statement stmt = con.createStatement();
			String sentSQL = "SELECT * FROM SESION where cod_sesion = " + codS;
			ResultSet rs = stmt.executeQuery(sentSQL);

			while (rs.next()) {
				horaI = rs.getString("horaI");
				fecha = rs.getString("fecha");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void getCodSesion() {
		codS = PeliculaIndividual.codS;
		
		
	}
	public static void getId_sala() {
		id_sala = PeliculaIndividual.codSala;
		
		
	}
	public static void getPelicula() {
		pelicula = PeliculaIndividual.pelicula;
		
		
	}

	public static void getAsientosSeleccionados() {
		for (java.awt.Component b : panel.getComponents()) {
			if (b instanceof JButton) {
				if (((JButton) b).getIcon().equals(iconoSelec)) {
					for (Asiento a : asientos) {
						if (b.getX() == a.getColumna() && b.getY() == a.getFila() && a.getId_sala() == Integer.parseInt(PeliculaIndividual.codSala)) {
							codigoAS.add(a);
						}

					}
				}

			}
		}
	}

	// public void guardarAsientos() {
// for(Asiento a: asientos) {
// BD.BDprueba2.insertarAsiento(a);
// }
// };

	public static void main(String[] args) {
		SalaYAsientos2 ventSYA = new SalaYAsientos2();
		ventSYA.setVisible(true);

	}

}
