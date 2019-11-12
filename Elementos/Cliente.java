package Elementos;



/** Clase con información de un cliente 
 * @author Unai, Mireya y Haizea
 * HEREDA DE USUARIO
 */

public class Cliente extends Usuario{
	

	private long numero_tarjeta; 
	// Incluir los pases que compra un cliente



//	public Cliente() {
//		super(nombre, apellido, correo, contrasena);


	public Cliente(String nombre, String apellido, String correo, char[] contrasena, long numero_tarjeta) {
		super(nombre, apellido, correo, contrasena);

		this.numero_tarjeta = numero_tarjeta;
	}



	// GETTERS AND SETTERS
	
	/**
	 * @return numero de tarjeta
	 */
	public long getNumero_tarjeta() {
		return numero_tarjeta;
	}

	/** Permite introducir número de tarjeta 
	 * @param numero_tarjeta
	 */
	public void setNumero_tarjeta(long numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}
	
	@Override
	public String toString() {
		return "Cliente [Nombre=" + getNombre() + ", Apellido=" + getApellido()
				+ ", Correo=" + getCorreo() + ", Contrasena =" + getContrasena() + ",Tarjeta=" + getNumero_tarjeta() + "]";
	}
	
	

	
	
	// Dos usuarios son iguales si sus correos son iguales
	public boolean equals( Object o ) {
		Usuario u2 = null;
		if (o instanceof Usuario) u2 = (Usuario) o;
		else return false;  // Si no es de la clase, son diferentes
		return (getCorreo().equals(u2.getCorreo()));
			
	}
	


//	public static void main(String[] args) {
//	
//	Cliente c1 = new Cliente ("Unai", "Mendi", "u@g.com", , 45645);
//	System.out.println(c1.toString());
//	//c1.toString();
//	
//	



	
	

		
	}


