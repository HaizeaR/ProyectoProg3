package BD;
	
	

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			String sent = "CREATE TABLE IF NOT EXISTS cliente (dni INTEGER PRIMARY KEY, nombre varchar(100), apellido varchar(100), correo varchar(100), contrasena varchar(20), n_tarjeta int(16));";
			System.out.println( sent );
			statement.executeUpdate( sent );
			
			
			
//			sent = "CREATE TABLE IF NOT EXISTS compra (id INTEGER PRIMARY KEY AUTOINCREMENT, idProducto int, fecha bigint, cantidad int);";
//			System.out.println( sent );
//			statement.executeUpdate( sent );
			try {
//				sent = "insert into producto (id, nombre, precio) values (1,'Jamón para profesor',345);";
//				System.out.println( sent );
//				statement.executeUpdate( sent );
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
				
				
				
				int precio = rs.getInt("precio");
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
			String sent = "insert into cliente (dni, nombre, apellido, correo, contrasena, n_tarjeta) values (" + cliente.getDNI() + "," + cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getCorreo()+ "," + cliente.getContrasena().toString()+ "," + cliente.getNumero_tarjeta() + " );";
			System.out.println( sent );
			int insertados = statement.executeUpdate( sent );
			if (insertados!=1) return false;  // Error en inserción
			
//			// 11 - Búsqueda de la fila insertada
//			sent = "select id from compra where idProducto=" + compra.getProducto().getId() + " and fecha=" + compra.getFecha() + ";";
//			System.out.println( sent );
//			ResultSet rs = statement.executeQuery( sent );
//			if (rs.next()) { // Leer el resultset y poner el id
//				int id = rs.getInt( "id" );
//				compra.setId( id );
//			}
			return true;
		} catch (Exception e) {
			return false;
		}
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

}
