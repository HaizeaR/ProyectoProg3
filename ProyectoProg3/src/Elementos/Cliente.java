package ProyectoProg3.src.Elementos;

<<<<<<< HEAD

=======
// Clase que guarda la informaci�n de un cliente 
>>>>>>> branch 'master' of https://github.com/HaizeaR/ProyectoProg3.git

// nombre 
// apellidos
// correo electronico 
<<<<<<< HEAD
// contraseña 
=======
// contrase�a ? 
>>>>>>> branch 'master' of https://github.com/HaizeaR/ProyectoProg3.git
// datos bancarios 
// 


/** Clase con información de un cliente 
 * @author Unai, Mireya y Haizea
 * HEREDA DE USUARIO
 */

public class Cliente extends Usuario{
	

	private long numero_tarjeta; 



<<<<<<< HEAD
	public Cliente(String nombre, String apellido, String correo, char[] contraseña, long numero_tarjeta) {
		super(nombre, apellido, correo, contraseña);
=======

	public Cliente(String nombre, String apellido, String correo, char[] contrase�a, long numero_tarjeta) {
		super(nombre, apellido, correo, contrase�a);
>>>>>>> branch 'master' of https://github.com/HaizeaR/ProyectoProg3.git
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
				+ ", Correo=" + getCorreo() + ", Contrase�a =" + getContrase�a() + ",Tarjeta=" + getNumero_tarjeta() + "]";
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

