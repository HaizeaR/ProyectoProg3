package ProyectoProg3.src.Elementos;


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
<<<<<<< HEAD
	private char[] contraseña;

	// CONSTRUCTOR

	public Usuario(String nombre, String apellido, String correo, char[] contraseña) {

=======
	private char[] contrase�a;
	
	
	public Usuario(String nombre, String apellido, String correo, char[] contrase�a) {
	
>>>>>>> branch 'master' of https://github.com/HaizeaR/ProyectoProg3.git
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrase�a = contrase�a;
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


<<<<<<< HEAD
	/** Deveulve la contraseña en un formato (....)
	 * @return constraseña
	 */
	public char[] getContraseña() {
		return contraseña;
=======
	public char[] getContrase�a() {
		return contrase�a;
>>>>>>> branch 'master' of https://github.com/HaizeaR/ProyectoProg3.git
	}


<<<<<<< HEAD
	/** Permite definir la contraseña
	 * @param contraseña
	 */
	public void setContraseña(char[] contraseña) {
		this.contraseña = contraseña;
=======
	public void setContrase�a(char[] contrase�a) {
		this.contrase�a = contrase�a;
>>>>>>> branch 'master' of https://github.com/HaizeaR/ProyectoProg3.git
	} 


}
