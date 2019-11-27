package Elementos;


/**Clase PADRE donde se encuentran los datos principales de los usuario del cine
 * @author Unai, Mireya y Haizea
 * CLIENTE Y ADMIN heredan de esta
 *
 */
public class Usuario {

	// ATRIBUTOS
	private String DNI;
	private String nombre; 
	private String apellido; 
	private String correo;
	private char[] contrasena;

	// CONSTRUCTOR

	public Usuario(String DNI, String nombre, String apellido, String correo, char[] contrasena) {
	
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
	}



	// GETTERS AND SETTERS

	public String getDNI() {
		return DNI;
	}



	public void setDNI(String dNI) {
		DNI = dNI;
	}



	/** 
	 * @return nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}


	/** Permite definir el nombre de un usuario
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return apellido de usuario
	 */
	public String getApellido() {
		return apellido;
	}


	/** Definir el apellido del usuario
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	/** 
	 * @return correo del usuario
	 */
	public String getCorreo() {
		return correo;
	}


	/** Permite definir correo a un usuario
	 * @param correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}


	/** Deveulve la contraseña en un formato (....)
	 * @return constraseña
	 */
	public char[] getContrasena() {
		return contrasena;
	}
	
	/** Permite definir la contraseña
	 * @param contraseña
	 */
	public void setContrasena(char[] contrasena) {
		this.contrasena = contrasena;
	}
	
	


}