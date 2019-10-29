package Elementos;


/**Clase PADRE donde se encuentran los datos principales de los usuario del cine
 * @author Unai, Mireya y Haizea
 * CLIENTE Y ADMIN heredan de esta
 *
 */
public class Usuario {

	// ATRIBUTOS

	private String nombre; 
	private String apellido; 
	private String correo;
	private char[] contraseña;

	// CONSTRUCTOR

	public Usuario(String nombre, String apellido, String correo, char[] contraseña) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contraseña = contraseña;
	}



	// GETTERS AND SETTERS

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
	public char[] getContraseña() {
		return contraseña;
	}


	/** Permite definir la contraseña
	 * @param contraseña
	 */
	public void setContraseña(char[] contraseña) {
		this.contraseña = contraseña;
	} 


}
