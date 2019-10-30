package ProyectoProg3.src.Elementos;

// Clase que permite crear a los distintos trabajadores / Admin del cine
// correo electronico ( con el que acceden) 
// contraseÃ±a
// nombre
// apellidos 
// Fecha de creaciÃ³n - (fecha de contrataciÃ³n ) 


/**
 * Clase con informaciÃ³n de un trabajador 
 * @author Unai, Mireya y Haizea
 * HEREDA DE USUARIO
 */
public class Admin extends Usuario {
	
	
	

	public Admin(String nombre, String apellido, String correo, char[] contraseña) {
		super(nombre, apellido, correo, contraseña);
		
	}

	@Override
	public String toString() {
		return "Admin [Nombre=" + getNombre() + ", Apellido=" + getApellido() + ", Correo=" + getCorreo()
				+ ", Contraseña=" + getContraseña() +  "]";
	}
	
	
<<<<<<< HEAD
	
	
	
	
 
	
	

	
=======
>>>>>>> branch 'master' of https://github.com/HaizeaR/ProyectoProg3.git

}
