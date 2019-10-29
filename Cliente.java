
// Clase que guarda la información de un cliente 

// nombre 
// apellidos
// correo electronico 
// contraseña ? 
// datos bancarios 
// 


public class Cliente {
	
	private String nombre_cliente; 
	private String apellido_cliente; 
	private String correo_cliente; 
	
	private long numero_tarjeta; 
	//...
	

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(String nombre_cliente, String apellido_cliente, String correo_cliente, long numero_tarjeta) {
		super();
		this.nombre_cliente = nombre_cliente;
		this.apellido_cliente = apellido_cliente;
		this.correo_cliente = correo_cliente;
		this.numero_tarjeta = numero_tarjeta;
	}

	
	// GETTERS AND SETTERS 

	public String getNombre_cliente() {
		return nombre_cliente;
	}


	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}


	public String getApellido_cliente() {
		return apellido_cliente;
	}


	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}


	public String getCorreo_cliente() {
		return correo_cliente;
	}


	public void setCorreo_cliente(String correo_cliente) {
		this.correo_cliente = correo_cliente;
	}


	public long getNumero_tarjeta() {
		return numero_tarjeta;
	}


	public void setNumero_tarjeta(long numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}


	@Override
	public String toString() {
		return "Cliente [Nombre=" + nombre_cliente + ", Apellido=" + apellido_cliente
				+ ", Correo electrónico =" + correo_cliente + ", Numero Tarjeta=" + numero_tarjeta + "]";
	}
	
	
	public static void main(String[] args) {
		Cliente c1 = new Cliente("H","R", "haizeaR@gmail.com", 4566767); 
		System.out.println(c1);
			
		}
		
	}

