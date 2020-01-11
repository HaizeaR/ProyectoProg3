package BD;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Elementos.Admin;
import Elementos.Asiento;
import Elementos.Cliente;
import Elementos.Sesion;

public class BDprueba2 {
	public static Connection conexion;
	public static Statement st;

	private static boolean LOGGING = true;

	/**
	 * Inicializa una BD SQLITE y devuelve una conexiÃ³n con ella
	 * 
	 * @param nombreBD Nombre de fichero de la base de datos
	 * @return ConexiÃ³n con la base de datos indicada. Si hay algÃºn error, se
	 *         devuelve null
	 */
	public static Connection initBD(String nombreBD) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
// log( Level.INFO, "Conectada base de datos " + nombreBD, null );
			return con;
		} catch (ClassNotFoundException | SQLException e) {
// log( Level.SEVERE, "Error en conexiÃ³n de base de datos " + nombreBD, e );
			return null;
		}
	}

	/**
	 * Crea las tablas de la base de datos. Si ya existen, las deja tal cual.
	 * Devuelve un statement para trabajar con esa base de datos
	 * 
	 * @param con ConexiÃ³n ya creada y abierta a la base de datos
	 * @return sentencia de trabajo si se crea correctamente, null si hay cualquier
	 *         error
	 */
	public static Statement usarCrearTablasBD(Connection con) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg
			try {
				String sent = "CREATE TABLE IF NOT EXISTS cliente (dni String PRIMARY KEY, nombre String, apellido string, correo String, contrasena varchar(20), n_tarjeta int(16));";

				statement.executeUpdate(sent);
				log(Level.INFO, "BD creación de tabla\t" + sent, null);

			} catch (SQLException e) {
			} // Tabla ya existe. Nada que hacer
			try {
				String sent = "CREATE TABLE IF NOT EXISTS admin (dni varchar(9) PRIMARY KEY, nombre varchar(100), apellido varchar(100), correo varchar(100), contrasena varchar(20));";

				statement.executeUpdate(sent);
				log(Level.INFO, "BD creación de tabla\t" + sent, null);

			} catch (SQLException e) {
			}
			try {
				String sent = "CREATE TABLE IF NOT EXISTS asiento (codigo INTEGER PRIMARY KEY, fila int(5), columna int(5), ocupado boolean);";

				statement.executeUpdate(sent);
				log(Level.INFO, "BD creación de tabla\t" + sent, null);

			} catch (SQLException e) {
			} // Tabla ya existe. Nada que hacer
			try {
				String sent = "CREATE TABLE IF NOT EXISTS pelicula (cod_peli INTEGER PRIMARY KEY, titulo_peli varchar(100), descrip_peli varchar(100), duracion_peli int (3));";

				statement.executeUpdate(sent);
				log(Level.INFO, "BD creación de tabla\t" + sent, null);

			} catch (SQLException e) {
			}
			try {
				String sent = "CREATE TABLE IF NOT EXISTS sala (numero_sala INTEGER PRIMARY KEY, capacidad sala int(3), ID_cine int(3));";

				statement.executeUpdate(sent);
				log(Level.INFO, "BD creación de tabla\t" + sent, null);

			} catch (SQLException e) {
			}
			try {
				String sent = "CREATE TABLE IF NOT EXISTS sesion (cod_sesion INTEGER PRIMARY KEY, fecha DATE, horaI String, ID_sala int(5), ID_peli int(5));";

				statement.executeUpdate(sent);
			} catch (SQLException e) {
			}
			try {
				String sent = "CREATE TABLE IF NOT EXISTS cine (ID_cine INTEGER PRIMARY KEY, nombre_cine varchar(50), direccion_cine varchar(150));";

				statement.executeUpdate(sent);
				log(Level.INFO, "BD creación de tabla\t" + sent, null);
			} catch (SQLException e) {
			}
			log(Level.INFO, "Creada base de datos", null);
			return statement;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error en creacion de base de datos", e);
			return null;
		}
	}

	/**
	 * Abre conexiÃ³n con la base de datos
	 * 
	 * @param nombreBD Nombre del fichero de base de datos
	 * @return true si la conexiÃ³n ha sido correcta, false en caso contrario CINE2
	 * 
	 */
	public static boolean insertTablas( Statement st) {
		try {

//System.out.println("ConexiÃ³n abierta");
//Class.forName("org.sqlite.JDBC"); // Carga la clase de BD para sqlite
//conexion = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);

// No lo pide el ejercicio, pero si se quiere crear la base de datos si no
// existe desde el propio programa habrÃ­a que hacer esto:
// creaciÃ³n bd

			try {
// INSERTAR VALORES POR DEFECTO EN CLIENTE

				String sent = "insert into pelicula values (111, 'Frozen2', 'Elsa quiere descubrir quiÃ©n es en realidad y por quÃ© posee un poder tan asombroso', '143' );";
				System.out.println(sent);
				st.executeUpdate(sent);
				log(Level.INFO, "BD insert en tabla\t" + sent, null);

				String sent1 = "insert into pelicula values (222, 'VengadoresEndgame', 'Los Vengadores restantes deben encontrar una manera de recuperar a sus aliados para un enfrentamiento Ã©pico con Thanos', '203' );";
				System.out.println(sent1);
				st.executeUpdate(sent1);
				log(Level.INFO, "BD insert en tabla\t" + sent1, null);

				String sent2 = "insert into cliente values ('12345678A', 'm', 'q', 'm.q@gmail.com', 12345678, 456789);";
				System.out.println(sent2);
				st.executeUpdate(sent2);
				log(Level.INFO, "BD insert en tabla\t" + sent2, null);

				String sent3 = "insert into cliente values ('16088533X', 'u', 'm', 'u.m@gmail.com', 12345678, 654321);";
				System.out.println(sent3);
				st.executeUpdate(sent3);
				log(Level.INFO, "BD insert en tabla\t" + sent3, null);

				String sent4 = "insert into cine values (122, 'IMAX', 'Arriquíbar Plaza, 4, 48001 Bilbo');";
				// System.out.println(sent4);
				st.executeUpdate(sent4);
				log(Level.INFO, "BD insert en tabla\t" + sent4, null);

				String sent5 = "insert into sala values (1, 80, 122);";
				System.out.println(sent5);
				st.executeUpdate(sent5);
				log(Level.INFO, "BD insert en tabla\t" + sent5, null);

				String sent6 = "insert into sala values (2, 100, 122);";
				// System.out.println(sent6);
				st.executeUpdate(sent6);
				log(Level.INFO, "BD insert en tabla\t" + sent6, null);

				String sent7 = "insert into sesion values ('1', '2019-05-01', '16:30', '1', '111');";
				System.out.println(sent7);
				st.executeUpdate(sent7);
				log(Level.INFO, "BD insert en tabla\t" + sent7, null);

				String sent8 = "insert into sesion values (2, '2019-05-01', '16:30', 2, 222);";
				// System.out.println(sent8);
				st.executeUpdate(sent8);
				log(Level.INFO, "BD insert en tabla\t" + sent8, null);

				String sent9 = "insert into sesion values (3, '2019-05-02', '16:30', 1, 111);";
				// System.out.println(sent9);
				st.executeUpdate(sent9);
				log(Level.INFO, "BD insert en tabla\t" + sent9, null);
			} catch (Exception e) {
			} // Es normal que haya error en los inserts si ya existen las claves
// fin creaciÃ³n bd

			return true;
		} catch (Exception e) {
			log(Level.SEVERE, "Error ", null);

			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Cierra la conexiÃ³n abierta de base de datos ({@link #abrirConexion(String)})
	 */
	public static void cerrarConexion() {
		try {
			conexion.close();
			System.out.println("ConexiÃ³n cerrada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lee los productos de la conexiÃ³n de base de datos abierta
	 * 
	 * @return Lista completa de productos, null si hay algÃºn error
	 */
	public static ArrayList<Cliente> selectClientes(Statement st) {
		try {
			ArrayList<Cliente> ret = new ArrayList<>();
			String sent = "select * from cliente;";
			System.out.println(sent);
			ResultSet rs = st.executeQuery(sent);
			while (rs.next()) { // Leer el resultset
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String correo = rs.getString("correo");
				String contrasena = (rs.getString("contrasena"));
// String contrasena = rs.getString("contrasena");
				int n_tarjeta = rs.getInt("n_tajerta");

				ret.add(new Cliente(dni, nombre, apellido, correo, contrasena, n_tarjeta));
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Inserta un cliente en la base de datos abierta
	 */
	public static boolean insertCliente(Cliente cliente, Statement st) {
		try {

			String sent = "insert into cliente values(" + "'" + secu(cliente.getDNI()) + "', " + "'"
					+ secu(cliente.getNombre()) + "', " + "'" + secu(cliente.getApellido()) + "', " + "'"
					+ secu(cliente.getCorreo()) + "', " + "'" + cliente.getContrasena().toString() + "', " + "'"
					+ cliente.getNumero_tarjeta() + "' " + ")";

			System.out.println(sent);
			int insertados = st.executeUpdate(sent);

			if (insertados != 1)
				return false;
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean insertarAsiento(Asiento a, Statement st) {

		try {
			String sent;
			sent = "insert into asiento values(" + "'" + (a.getCodigo()) + "', " + "'" + (a.getFila()) + "', " + "'"
					+ (a.getColumna()) + "', " + "'" + (a.isOcupado()) + "' " +

					")";

			System.out.println(sent);
			int insertados = st.executeUpdate(sent);

			if (insertados != 1)
				return false;

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Inserta una nuevo admin en la base de datos abierta
	 */
	public static boolean insertarAdmin(Admin admin, Statement st) {
		try {
			String sent;

			sent = "insert into admin values(" + "'" + secu(admin.getDNI()) + "', " + "'" + secu(admin.getNombre())
					+ "', " + "'" + secu(admin.getApellido()) + "', " + "'" + secu(admin.getCorreo()) + "', " + "'"
					+ admin.getContrasena().toString() + "' " + ")";

			System.out.println(sent);
			int insertados = st.executeUpdate(sent);

			if (insertados != 1)
				return false;
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Lee los administradores de la conexiÃ³n de base de datos abierta
	 * 
	 * @return Lista completa de admin, null si hay algÃºn error
	 */
	public static ArrayList<Admin> SelectAdmins(Statement st) {
		try {
			ArrayList<Admin> ret = new ArrayList<>();
			String sent = "select * from admin;";
			System.out.println(sent);
			ResultSet rs = st.executeQuery(sent);
			while (rs.next()) { // Leer el resultset
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String correo = rs.getString("correo");
				String contrasena = (rs.getString("contrasena"));

				ret.add(new Admin(dni, nombre, apellido, correo, contrasena));
			}

			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean insertSesion(Sesion s, Statement st) {

		try {
			String sent;
			sent = "insert into sesion values(" + "'" + (s.getCod_sesion()) + "', " + "'" + (s.getFecha()) + "', " + "'"
					+ (s.getHoraI()) + "', " + "'" + (s.getID_sala()) + "', " + "'" + (s.getID_pelicula()) + "' " +

					")";

			System.out.println(sent);
			int insertados = st.executeUpdate(sent);

			if (insertados != 1)
				return false;

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

/////////////////////////////////////////////////////////////////////
// MÃ©todos privados //
/////////////////////////////////////////////////////////////////////

// Devuelve el string "securizado" para volcarlo en SQL
// (ImplementaciÃ³n 1) Sustituye ' por '' y quita saltos de lÃ­nea
// (ImplementaciÃ³n 2) Mantiene solo los caracteres seguros en espaÃ±ol
// TODO OJO - FALTA algo importante por hacer en la implementaciÃ³n actual...
// Â¿no?
	private static String secu(String string) {
// ImplementaciÃ³n (1)
// return string.replaceAll( "'", "''" ).replaceAll( "\\n", "" );
// ImplementaciÃ³n (2)
		StringBuffer ret = new StringBuffer();
		for (char c : string.toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÃ±Ã‘Ã¡Ã©Ã­Ã³ÃºÃ¼Ã�Ã‰Ã�Ã“ÃšÃš.,:;-_(){}[]-+*=<>'\"Â¿?Â¡!&%$@#/\\0123456789 "
					.indexOf(c) >= 0)
				ret.append(c);
		}
		return ret.toString();
	}

//
//	/** Borra una compra en la base de datos abierta
//	* @param compra	Compra a borrar
//	* @return	true si el borrado es correcto, false en caso contrario
//	*/
//	public static boolean borrarCompra( Compra compra ) {
//	try (Statement statement = conexion.createStatement()) {
//	String sent = "delete from compra where id=" + compra.getId() + ";";
//	System.out.println( sent );
//	int borrados = statement.executeUpdate( sent );
//	return (borrados==1);
//	} catch (Exception e) {
//	return false;
//	}
//	}
//	
//	
//}

	public static String buscarCorreoCliente(Cliente cliente, Statement st) {
// Sin terminar
		String sent = "";
		try {
			sent = "select correo from cliente;";
			ResultSet rs = st.executeQuery(sent);
			cliente.setCorreo(rs.getString("correo"));
			rs.close();

		} catch (SQLException e) {

		}

		return null;

	}
/////////////////////////////////////////////////////////////////////
//                      Logging                                    //
/////////////////////////////////////////////////////////////////////

	private static Logger logger = null;

// Método local para loggear
	private static void log(Level level, String msg, Throwable excepcion) {
		if (!LOGGING)
			return;
		if (logger == null) { // Logger por defecto local:
			logger = Logger.getLogger(BDprueba2.class.getName()); // Nombre del logger - el de la clase
			logger.setLevel(Level.ALL); // Loguea todos los niveles
		}
		if (excepcion == null)
			logger.log(level, msg);
		else
			logger.log(level, msg, excepcion);
	}
}