package ProyectoProg3.src.Elementos;

public class Usuario {
	
	private String nombre; 
	private String apellido; 
	private String correo;
	private char[] contrase�a;
	
	
	public Usuario(String nombre, String apellido, String correo, char[] contrase�a) {
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrase�a = contrase�a;
	}

	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public char[] getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(char[] contrase�a) {
		this.contrase�a = contrase�a;
	} 
	

	
	
	

}
