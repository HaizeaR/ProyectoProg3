package Elementos;



// nombre 
// apellidos
// correo electronico 
// contraseña 
// datos bancarios 
// 


/** Clase con información de un cliente 
 * @author Unai, Mireya y Haizea
 * HEREDA DE USUARIO
 */

public class Cliente extends Usuario{
	

	private long numero_tarjeta; 



	public Cliente(String nombre, String apellido, String correo, char[] contraseña, long numero_tarjeta) {
		super(nombre, apellido, correo, contraseña);
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
				+ ", Correo=" + getCorreo() + ", Contraseña =" + getContraseña() + ",Tarjeta=" + getNumero_tarjeta() + "]";
	}
	
	
//	public static void main(String[] args) {
//		
//		Cliente c1 = new Cliente ("Unai", "Mendi", "u@g.com", "123", 45645);
//		System.out.println(c1.toString());
//		//c1.toString();
//		
//		
//	}
	
	
	
	
	




	
	

		
	}

