package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Elementos.Admin;
import Elementos.Asiento;
import Elementos.Cliente;
import Elementos.Sesion;

public class BDprueba2 {
	private static Connection conexion;
	private static Statement st;

	private static Logger log;

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
	 * Abre conexiÃ³n con la base de datos
	 * 
	 * @param nombreBD Nombre del fichero de base de datos
	 * @return true si la conexiÃ³n ha sido correcta, false en caso contrario CINE2
	 * 
	 */
	public static boolean abrirConexion(String nombreBD) {

		try {

			System.out.println("ConexiÃ³n abierta");
			Class.forName("org.sqlite.JDBC"); // Carga la clase de BD para sqlite
			conexion = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);

			// No lo pide el ejercicio, pero si se quiere crear la base de datos si no
			// existe desde el propio programa habrÃ­a que hacer esto:
			// creaciÃ³n bd

			Statement statement = conexion.createStatement();
			String sent = "CREATE TABLE IF NOT EXISTS cliente (dni String PRIMARY KEY, nombre String, apellido string, correo String, contrasena varchar(20), n_tarjeta int(16));";
			System.out.println(sent);
			statement.executeUpdate(sent);

			// REVISAR

			sent = "CREATE TABLE IF NOT EXISTS admin (dni varchar(9) PRIMARY KEY, nombre varchar(100), apellido varchar(100), correo varchar(100), contrasena varchar(20));";
			System.out.println(sent);
			statement.executeUpdate(sent);

			sent = "CREATE TABLE IF NOT EXISTS asiento (codigo INTEGER PRIMARY KEY, fila int(5), columna int(5), ocupado boolean);";
			System.out.println(sent);
			statement.executeUpdate(sent);

			sent = "CREATE TABLE IF NOT EXISTS pelicula (cod_peli INTEGER PRIMARY KEY, titulo_peli varchar(100), descrip_peli varchar(100), duracion_peli int (3));";
			System.out.println(sent);
			statement.executeUpdate(sent);

			sent = "CREATE TABLE IF NOT EXISTS sala (numero_sala INTEGER PRIMARY KEY, capacidad sala int(3), ID_cine int(3));";
			System.out.println(sent);
			statement.executeUpdate(sent);

			sent = "CREATE TABLE IF NOT EXISTS sesion (cod_sesion INTEGER PRIMARY KEY, fecha DATE, horaI String, ID_sala int(5), ID_peli int(5));";
			System.out.println(sent);
			statement.executeUpdate(sent);
			
			
			sent = "CREATE TABLE IF NOT EXISTS cine (ID_cine INTEGER PRIMARY KEY, nombre_cine varchar(50), direccion_cine varchar(150));";
			System.out.println(sent);
			statement.executeUpdate(sent);
			
			
			
			
//			sent = "CREATE TABLE IF NOT EXISTS cine ( "
			
			
			
			

//			sent = "CREATE TABLE IF NOT EXISTS compra (id INTEGER PRIMARY KEY AUTOINCREMENT, idProducto int, fecha bigint, cantidad int);";
//			System.out.println( sent );
//			statement.executeUpdate( sent );

			try {
				// INSERTAR VALORES POR DEFECTO EN CLIENTE

				sent = "insert into pelicula values (111, 'Frozen2', 'Elsa quiere descubrir quiÃ©n es en realidad y por quÃ© posee un poder tan asombroso', '143' );";
				System.out.println(sent);
				statement.executeUpdate(sent);

				String sent1 = "insert into pelicula values (222, 'VengadoresEndgame', 'Los Vengadores restantes deben encontrar una manera de recuperar a sus aliados para un enfrentamiento Ã©pico con Thanos', '203' );";
				System.out.println(sent1);
				statement.executeUpdate(sent1);

				String sent2 = "insert into cliente values ('12345678A', 'm', 'q', 'm.q@gmail.com', 12345678, 456789);";
				System.out.println(sent2);
				statement.executeUpdate(sent2);

				String sent3 = "insert into cliente values ('16088533X', 'u', 'm', 'u.m@gmail.com', 12345678, 654321);";
				System.out.println(sent3);
				statement.executeUpdate(sent3);
				
				String sent4 = "insert into cine values (122, 'IMAX', 'Arriquíbar Plaza, 4, 48001 Bilbo');";
				System.out.println(sent4);
				statement.executeUpdate(sent4);
				
				
				String sent5 = "insert into sala values (1, 80, 122);";
				System.out.println(sent5);
				statement.executeUpdate(sent5);
				
				String sent6 = "insert into sala values (2, 100, 122);";
				System.out.println(sent6);
				statement.executeUpdate(sent6);
	
				String sent7 = "insert into sesion values (1, '2019-05-01', '16:30', 1, 111);";
				System.out.println(sent7);
				statement.executeUpdate(sent7);
				
				
				String sent8 = "insert into sesion values (2, '2019-05-01', '16:30', 2, 222);";
				System.out.println(sent8);
				statement.executeUpdate(sent8);
				
				String sent9 = "insert into sesion values (3, '2019-05-02', '16:30', 1, 111);";
				System.out.println(sent9);
				statement.executeUpdate(sent9);
				
				
//				sent = "insert into producto (id, nombre, precio) values (2,'Crucifijo rezos pre-examen',42);";
//				System.out.println( sent );
//				statement.executeUpdate( sent );

//				sent = "insert into producto (id, nombre, precio) values (3,'Asesor programaciÃ³n Java (hora)',25);";
//				System.out.println( sent );
//				statement.executeUpdate( sent );

				// INSERTAR POR DEFECTO EN PELICULA

			} catch (Exception e) {
			} // Es normal que haya error en los inserts si ya existen las claves
			// fin creaciÃ³n bd

			return true;
		} catch (Exception e) {
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
	public static ArrayList<Cliente> getClientes() {
		try (Statement statement = conexion.createStatement()) {
			ArrayList<Cliente> ret = new ArrayList<>();
			String sent = "select * from cliente;";
			System.out.println(sent);
			ResultSet rs = statement.executeQuery(sent);
			while (rs.next()) { // Leer el resultset
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String correo = rs.getString("correo");
				char[] contrasena = (rs.getString("contrasena")).toCharArray();
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

	
	/** Reinicia en blanco las tablas de la base de datos. 
	 * UTILIZAR ESTE MËTODO CON PRECAUCIÓN. Borra todos los datos que hubiera ya en las tablas
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se borra correctamente, null si hay cualquier error
	 */
	// NO FUNCIONA
	public static boolean reiniciarBD( Connection con ) {
		
		int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro?, pulsar este boton supone reiniciar la BD y perder sus datos", "¿Desea guardar los cambios?", JOptionPane.YES_NO_OPTION);
		if(respuesta == 0) {
		
		
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			
			//st.setQueryTimeout(30);  // poner timeout 30 msg
			st.executeUpdate("drop table if exists cine");
			st.executeUpdate("drop table if exists admin");
			st.executeUpdate("drop table if exists sala");
			st.executeUpdate("drop table if exists sesion");
			st.executeUpdate("drop table if exists pelicula");
			st.executeUpdate("drop table if exists cliente");
			st.executeUpdate("drop table if exists asiento");
			//log( Level.INFO, "Reiniciada base de datos", null );
			return abrirConexion("Cine2.db");
		} catch (SQLException e) {
			//log( Level.SEVERE, "Error en reinicio de base de datos", e );
			return false;
		}
	}
		return false;
	}

	
	

	
	/**
	 * Inserta un cliente en la base de datos abierta
	 */
	public static boolean insertarCliente(Cliente cliente) {
		try (Statement statement = conexion.createStatement()) {
			String sent; // = "insert into cliente (dni, nombre, apellido, correo, contrasena, n_tarjeta)
							// values (" + cliente.getDNI() + "," + cliente.getNombre() + "," +
							// cliente.getApellido() + "," + cliente.getCorreo()+ "," +
							// cliente.getContrasena().toString()+ "," + cliente.getNumero_tarjeta() + "
							// );";

			sent = "insert into cliente values(" + "'" + secu(cliente.getDNI()) + "', " + "'"
					+ secu(cliente.getNombre()) + "', " + "'" + secu(cliente.getApellido()) + "', " + "'"
					+ secu(cliente.getCorreo()) + "', " + "'" + cliente.getContrasena().toString() + "', " + "'"
					+ cliente.getNumero_tarjeta() + "' " + ")";

			System.out.println(sent);
			int insertados = statement.executeUpdate(sent);

			if (insertados != 1)
				return false;
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean insertarAsiento(Asiento a) {

		try (Statement statement = conexion.createStatement()) {
			String sent;
			sent = "insert into asiento values(" + "'" + (a.getCodigo()) + "', " + "'" + (a.getFila()) + "', " + "'"
					+ (a.getColumna()) + "', " + "'" + (a.isOcupado()) + "' " +

					")";

			System.out.println(sent);
			int insertados = statement.executeUpdate(sent);

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
	public static boolean insertarAdmin(Admin admin) {
		try (Statement statement = conexion.createStatement()) {
			String sent;

			sent = "insert into admin values(" + "'" + secu(admin.getDNI()) + "', " + "'" + secu(admin.getNombre())
					+ "', " + "'" + secu(admin.getApellido()) + "', " + "'" + secu(admin.getCorreo()) + "', " + "'"
					+ admin.getContrasena().toString() + "' " + ")";

			System.out.println(sent);
			int insertados = statement.executeUpdate(sent);

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
	public static ArrayList<Admin> getAdmins() {
		try (Statement statement = conexion.createStatement()) {
			ArrayList<Admin> ret = new ArrayList<>();
			String sent = "select * from admin;";
			System.out.println(sent);
			ResultSet rs = statement.executeQuery(sent);
			while (rs.next()) { // Leer el resultset
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String correo = rs.getString("correo");
				char[] contrasena = (rs.getString("contrasena")).toCharArray();

				ret.add(new Admin(dni, nombre, apellido, correo, contrasena));
			}

			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean insertarSesion(Sesion s) {

		try (Statement statement = conexion.createStatement()) {
			String sent;
			sent = "insert into sesion values(" + "'" + (s.getCod_sesion()) + "', " + "'" + (s.getFecha()) + "', " + "'"
					+ (s.getHoraI()) + "', " + "'" + (s.getID_sala()) + "', " + "'" + (s.getID_pelicula()) + "' " +

					")";

			System.out.println(sent);
			int insertados = statement.executeUpdate(sent);

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
//	 * @param compra	Compra a borrar
//	 * @return	true si el borrado es correcto, false en caso contrario
//	 */
//	public static boolean borrarCompra( Compra compra ) {
//		try (Statement statement = conexion.createStatement()) {
//			String sent = "delete from compra where id=" + compra.getId() + ";";
//			System.out.println( sent );
//			int borrados = statement.executeUpdate( sent );
//			return (borrados==1);
//		} catch (Exception e) {
//			return false;
//		}
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

}
