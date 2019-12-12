package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import Elementos.Cliente;

public class BDprueba2 {
	private static Connection conexion;
	
	/** Abre conexión con la base de datos
	 * @param nombreBD	Nombre del fichero de base de datos
	 * @return	true si la conexión ha sido correcta, false en caso contrario
	 * CINE2 
	 * 
	 */
	public static boolean abrirConexion( String nombreBD ) {
		try {
			System.out.println( "Conexión abierta" );
			Class.forName("org.sqlite.JDBC");  // Carga la clase de BD para sqlite
			conexion = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			
			// No lo pide el ejercicio, pero si se quiere crear la base de datos si no existe desde el propio programa habría que hacer esto:
			// creación bd
			
			
			Statement statement = conexion.createStatement();
			String sent = "CREATE TABLE IF NOT EXISTS cliente (dni String PRIMARY KEY, nombre String, apellido string, correo String, contrasena varchar(20), n_tarjeta int(16));";
			System.out.println( sent );
			statement.executeUpdate( sent );
			
			// REVISAR

			sent = "CREATE TABLE IF NOT EXISTS admin (dni varchar(9) PRIMARY KEY, nombre varchar(100), apellido varchar(100), correo varchar(100), contrasena varchar(20));";
			System.out.println( sent );
			statement.executeUpdate( sent );
			
			sent = "CREATE TABLE IF NOT EXISTS asiento (codigo INTEGER PRIMARY KEY, fila int(2), columna int(2), ocupado boolean);";
			System.out.println( sent );
			statement.executeUpdate( sent );
			
			sent = "CREATE TABLE IF NOT EXISTS pelicula (cod_peli INTEGER PRIMARY KEY, titulo_peli varchar(100), descrip_peli varchar(100), duracion_peli int (3));";
			System.out.println( sent );
			statement.executeUpdate( sent );
			
			sent = "CREATE TABLE IF NOT EXISTS sala (numero_sala INTEGER PRIMARY KEY, capacidad sala int(3), ID_cine int(3));";
			System.out.println( sent );
			statement.executeUpdate( sent );
			
			
			
			
			
			
//			sent = "CREATE TABLE IF NOT EXISTS compra (id INTEGER PRIMARY KEY AUTOINCREMENT, idProducto int, fecha bigint, cantidad int);";
//			System.out.println( sent );
//			statement.executeUpdate( sent );
			try {


				sent = "insert into cliente values ('12345678A', 'm', 'q', 'm.q@gmail.com', 12345678, 456789);";
				System.out.println( sent );
				statement.executeUpdate( sent );
				
				sent = "insert into cliente values ('16088533X', 'u', 'm', 'u.m@gmail.com', 12345678, 654321);";
				System.out.println( sent );
				statement.executeUpdate( sent );
				
//				sent = "insert into producto (id, nombre, precio) values (2,'Crucifijo rezos pre-examen',42);";
//				System.out.println( sent );
//				statement.executeUpdate( sent );
				
				
//				sent = "insert into producto (id, nombre, precio) values (3,'Asesor programación Java (hora)',25);";
//				System.out.println( sent );
//				statement.executeUpdate( sent );
				
			} catch(Exception e) {}  // Es normal que haya error en los inserts si ya existen las claves
			// fin creación bd
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/** Cierra la conexión abierta de base de datos ({@link #abrirConexion(String)})
	 */
	public static void cerrarConexion() {
		try {
			conexion.close();
			System.out.println( "Conexión cerrada" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Lee los productos de la conexión de base de datos abierta
	 * @return	Lista completa de productos, null si hay algún error
	 */
	public static ArrayList<Cliente> getClientes() {
		try (Statement statement = conexion.createStatement()) {
			ArrayList<Cliente> ret = new ArrayList<>();
			String sent = "select * from cliente;";
			System.out.println( sent );
			ResultSet rs = statement.executeQuery( sent );
			while( rs.next() ) { // Leer el resultset
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido"); 
				String correo = rs.getString("correo"); 
				char[] contrasena = (rs.getString("contrasena")).toCharArray();
				//String contrasena = rs.getString("contrasena");
				int n_tarjeta = rs.getInt("n_tajerta");
				

				
				ret.add( new Cliente ( dni, nombre, apellido, correo, contrasena, n_tarjeta ) );
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/** Inserta una compra en la base de datos abierta
	 * Actualiza el id de la compra insertada
	 * @param compra	Compra a insertar
	 * @return	true si la inserción es correcta, false en caso contrario
	 */
	public static boolean insertarCliente( Cliente cliente ) {
		try (Statement statement = conexion.createStatement()) {
			String sent ; // = "insert into cliente (dni, nombre, apellido, correo, contrasena, n_tarjeta) values (" + cliente.getDNI() + "," + cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getCorreo()+ "," + cliente.getContrasena().toString()+ "," + cliente.getNumero_tarjeta() + " );";
			
			 // Error en inserción
			
//			// 11 - Búsqueda de la fila insertada
//			sent = "select id from compra where idProducto=" + compra.getProducto().getId() + " and fecha=" + compra.getFecha() + ";";
//			System.out.println( sent );
//			ResultSet rs = statement.executeQuery( sent );
//			if (rs.next()) { // Leer el resultset y poner el id
//				int id = rs.getInt( "id" );
//				compra.setId( id );
//			}
			
			sent = "insert into cliente values(" +
					"'" + secu(cliente.getDNI()) + "', " +
					"'" + secu(cliente.getNombre()) + "', " +
					"'" + secu(cliente.getApellido()) + "', " +
					"'" + secu(cliente.getCorreo()) + "', " +
					"'" + cliente.getContrasena().toString() + "', " +
					"'" + cliente.getNumero_tarjeta() + "' " +
					")";
			
			System.out.println( sent );
			int insertados = statement.executeUpdate( sent );
		
			
			if (insertados!=1) return false; 
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	


	/////////////////////////////////////////////////////////////////////
	//                      Métodos privados                           //
	/////////////////////////////////////////////////////////////////////

	// Devuelve el string "securizado" para volcarlo en SQL
	// (Implementación 1) Sustituye ' por '' y quita saltos de línea
	// (Implementación 2) Mantiene solo los caracteres seguros en español
	// TODO OJO - FALTA algo importante por hacer en la implementación actual... ¿no?
	private static String secu( String string ) {
		// Implementación (1)
		// return string.replaceAll( "'",  "''" ).replaceAll( "\\n", "" );
		// Implementación (2)
		StringBuffer ret = new StringBuffer();
		for (char c : string.toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZñÑáéíóúüÁÉÍÓÚÚ.,:;-_(){}[]-+*=<>'\"¿?¡!&%$@#/\\0123456789 ".indexOf(c)>=0) ret.append(c);
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
			
					
		}catch(SQLException e ) {
			
			
		}
		
		
		
		return null;
		
	}
	
	
	
	
	
	
	
}
