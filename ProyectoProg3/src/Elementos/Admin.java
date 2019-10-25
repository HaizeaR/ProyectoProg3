package Elementos;

// Clase que permite crear a los distintos trabajadores / Admin del cine
// correo electronico ( con el que acceden) 
// contraseña
// nombre
// apellidos 
// Fecha de creación - (fecha de contratación ) 


public class Admin extends Usuario {
	
	
	

	public Admin(String nombre, String apellido, String correo, char[] contraseña) {
		super(nombre, apellido, correo, contraseña);
		
	}

	@Override
	public String toString() {
		return "Admin [Nombre=" + getNombre() + ", Apellido=" + getApellido() + ", Correo=" + getCorreo()
				+ ", Contraseña=" + getContraseña() +  "]";
	}
	
	
	
	
	
	
 
	
	

	

}
