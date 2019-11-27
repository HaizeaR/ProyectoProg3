package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Elementos.Cliente;

// Clase que contiene los métodos básicos y de conexión de nuestra BD
// Metodo conectar y cerrar 
// Añadir elementos a tablas
// Tabla USUARIO - Admin y Cliente
// Tabla Pelicula
// Tabla Asiento

public class BD {

	private static Connection conexion;

	private static boolean LOGGING = true;

	/**
	 * Inicializa una BD SQLITE y devuelve una conexión con ella
	 * 
	 * @param nombreBD Nombre de fichero de la base de datos
	 * @return Conexión con la base de datos indicada. Si hay algún error, se
	 *         devuelve null
	 */
	public static Connection initBD() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:cine.db");
			log(Level.INFO, "Conectada base de datos " + "cine.db", null);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			log(Level.SEVERE, "Error en conexi�n de base de datos " + "cine.db", e);
			return null;
		}
	}

	private static void cerrarBD(Connection conexion) {

		try {
			// if (stmt!=null) stmt.close();
			if (conexion != null)
				conexion.close();
			System.out.println("Cierre de base de datos");
		} catch (SQLException e) {
			e.printStackTrace();

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

	public static boolean clienteInsert(Statement st, Cliente cliente) {
		String sentSQL = "";
		try {
			sentSQL = "insert into cliente(dni, nombre, apellido, contrasena, n_tarjeta) values(" + "'"
					+ secu(cliente.getDNI()) + "', " + 
					cliente.getNombre() + "', " + 
					cliente.getApellido() + "', "+ 
					cliente.getContrasena().toString() + "', " + 
					cliente.getNumero_tarjeta() + 
					")";

			int val = st.executeUpdate(sentSQL);
			log(Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null);
			if (val != 1) { // Se tiene que a�adir 1 - error si no
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
	// M�todos privados //
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