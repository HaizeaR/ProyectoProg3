


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Clase que contiene los métodos básicos y de conexión de nuestra BD
// Metodo conectar y cerrar 
// Añadir elementos a tablas
// Tabla USUARIO - Admin y Cliente
// Tabla Pelicula
// Tabla Asiento

public class BD3 {
	
	private static Connection conexion;
	
	
	
	
	
	private static void cargarBD(String nombFich)   {
		
		System.out.println( "Conexión abierta" );
		
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:"+ nombFich );
			//Statement stmt = conn.createStatement();
			
		}catch( ClassNotFoundException | SQLException e ) {
			System.out.println("Error");
			e.printStackTrace();
		}

	}
	
	private static void cerrarBD(Connection conexion) {

		try {
			//if (stmt!=null) stmt.close();
			if (conexion!=null) conexion.close();
			System.out.println("Cierre de base de datos");
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}

}