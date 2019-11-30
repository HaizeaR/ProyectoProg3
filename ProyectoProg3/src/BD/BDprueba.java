package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Elementos.Admin;
import Elementos.Cliente;

// Clase que contiene los metodos basicos y de conexion de nuestra BD
// Metodo conectar y cerrar 
// Anadir elementos a tablas
// Tabla USUARIO - Admin y Cliente
// Tabla Pelicula
// Tabla Asiento

public class BDprueba {



	private static boolean LOGGING = true;

	/**
	 * Inicializa una BD SQLITE y devuelve una conexion con ella
	 * 
	 * @param nombreBD Nombre de fichero de la base de datos
	 * @return Conexion con la base de datos indicada. Si hay algun error, se
	 *         devuelve null
	 */
	public static Connection initBD() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:cine.db");
			Statement st = con.createStatement();
			st.setQueryTimeout(30); 
			
			log(Level.INFO, "Conectada base de datos " + "cine.db", null);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			log(Level.SEVERE, "Error en conexi�n de base de datos " + "cine.db", e);
			return null;
		}
	}



	

	
	/**
	 * Cierra la base de datos abierta
	 * 
	 * @param con Conexi�n abierta de la BD
	 * @param st  Sentencia abierta de la BD
	 */
	public static void cerrarBD(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
			log(Level.INFO, "Cierre de base de datos", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error en cierre de base de datos", e);
		}
	}
	
	
//	/** Crea las tablas de la base de datos. Si ya existen, las deja tal cual. Devuelve un statement para trabajar con esa base de datos
//	 * @param con	Conexión ya creada y abierta a la base de datos
//	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
//	 */
//	public static Statement usarCrearTablasBD( Connection con ) {
//		try {
//			Statement st = con.createStatement();
//			st.setQueryTimeout(30);  // poner timeout 30 msg
//
//			log( Level.INFO, "Creada base de datos", null );
//			return st;
//		} catch (SQLException e) {
//			log( Level.SEVERE, "Error en creación de base de datos", e );
//			return null;
//		}
//	}

	
	
	// Intentarlo de esta forma en vez de la de clase BD 
	
	
//	public static void clienteInsert( ResultSet rs, Statement st, Cliente cliente, // añadir JTextFields ) {
//		if (!tfUsuario.getText().isEmpty() && !tfPassword.getText().isEmpty()) {
//			String com = "";
//			try {
//				// Ver si existe usuario
//				// Si queremos asegurar el string habría que hacer algo así...
//				// String nick = tfUsuario.getText().replaceAll( "'", "''" );
//				// ...si no, cuidado con lo que venga en el campo de entrada.
//				// "select * from Usuario where nick = 'admin'";
//				com = "select * from Cliente where correo = '" + tfUsuario.getText() + "'";
//				logger.log( Level.INFO, "BD: " + com );
//				rs = st.executeQuery( com );
//				if (!rs.next()) {
//					// "insert into Usuario ( nick, pass ) values ('admin', 'admin')";
//					com = "insert into Cliente ( DNI, nombre, apellido, correo, contrasena, ntarjeta ) values ('"+ 
//							tfNombre.getText() +"', '" + tfApellido.getText() +"', '"+ tfCorreo.getText() "')";
//					logger.log( Level.INFO, "BD: " + com );
//					int val = st.executeUpdate( com );
//					if (val!=1) {
//						//JOptionPane.showMessageDialog( ventana, "Error en inserción" );
//					}
//				} else {
//				//	JOptionPane.showMessageDialog( ventana, "Usuario " + tfUsuario.getText() + " ya existe" );
//				}
//			} catch (SQLException e2) {
//				System.out.println( "Último comando: " + com );
//				e2.printStackTrace();
//			}
//		} else {
//			//JOptionPane.showMessageDialog( ventana, "Debes rellenar los dos campos" );
//		}
//		
//	};
//



// Vuelve a pintarla no hace falta 
private static void actualizaTabla( ResultSet rs, Statement st , DefaultTableModel mUsuarios ) {
	String com = "";
	try {
		while (mUsuarios.getRowCount()>0) mUsuarios.removeRow(0); // Vacía el modelo para volverlo a cargar de la bd
		com = "select * from Usuario";
		logger.log( Level.INFO, "BD: " + com );
		rs = st.executeQuery( com );
		while (rs.next()) {
			String nick = rs.getString( "nick" );
			String pass = rs.getString( "pass" );
			Vector<String> fila = new Vector<>();
			fila.add( nick ); fila.add( pass );
			mUsuarios.addRow( fila );
		}
		
	} catch (SQLException e2) {
		System.out.println( "Último comando: " + com );
		e2.printStackTrace();
	}
}


	public static boolean adminInsert(Statement st, Admin admin) {
		String sentSQL = "";
		try {
			sentSQL = "insert into cliente(dni, nombre, apellido, contrasena) values(" + "'"
					+ secu(admin.getDNI()) + "', " + 
					admin.getNombre() + "', " + 
					admin.getApellido() + "', "+ 
					admin.getContrasena().toString() + 
					")";

			int val = st.executeUpdate(sentSQL);
			log(Level.INFO, "BD añadida " + val + " fila\t" + sentSQL, null);
			if (val != 1) { // Se tiene que añadir 1 - error si no
				log(Level.SEVERE, "Error en insert de BD\t" + sentSQL, null);
				return false;
			}
			return true;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error en BD\t" + sentSQL, e);
			return false;
		}
	}
	
	
	
	
	

	/////////////////////////////////////////////////////////////////////
	// Metodos privados //
	/////////////////////////////////////////////////////////////////////

	// Devuelve el string "securizado" para volcarlo en SQL
	private static String secu(String string) {
		return string.replaceAll("'", "''");
	}

	/////////////////////////////////////////////////////////////////////
	//                      Logging                                    //
	/////////////////////////////////////////////////////////////////////

	private static Logger logger = null;

	// M�todo local para loggear
	private static void log(Level level, String msg, Throwable excepcion) {
		if (!LOGGING)
			return;
		if (logger == null) { // Logger por defecto local:
			logger = Logger.getLogger(BD.class.getName()); // Nombre del logger - el de la clase
			logger.setLevel(Level.ALL); // Loguea todos los niveles
		}
		if (excepcion == null)
			logger.log(level, msg);
		else
			logger.log(level, msg, excepcion);
	}

}
