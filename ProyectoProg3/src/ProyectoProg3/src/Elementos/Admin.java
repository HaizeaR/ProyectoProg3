package ProyectoProg3.src.Elementos;

// Clase que permite crear a los distintos trabajadores / Admin del cine
// correo electronico ( con el que acceden) 
// contraseña
// nombre
// apellidos 
// Fecha de creación - (fecha de contratación ) 


/**
 * Clase con información de un trabajador 
 * @author Unai, Mireya y Haizea
 * HEREDA DE USUARIO
 */
public class Admin extends Usuario {
	
	
	

	public Admin(String nombre, String apellido, String correo, char[] contrasena) {
		super(nombre, apellido, correo, contrasena);
		
	}

	@Override
	public String toString() {
		return "Admin [Nombre=" + getNombre() + ", Apellido=" + getApellido() + ", Correo=" + getCorreo()
				+ ", Contrase�a=" + getContrasena() +  "]";
	}
	


}
