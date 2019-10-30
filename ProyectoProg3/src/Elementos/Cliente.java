package ProyectoProg3.src.Elementos;

<<<<<<< HEAD

=======
// Clase que guarda la información de un cliente 
>>>>>>> branch 'master' of https://github.com/HaizeaR/ProyectoProg3.git

// nombre 
// apellidos
// correo electronico 
<<<<<<< HEAD
// contraseÃ±a 
=======
// contraseña ? 
>>>>>>> branch 'master' of https://github.com/HaizeaR/ProyectoProg3.git
// datos bancarios 
// 


/** Clase con informaciÃ³n de un cliente 
 * @author Unai, Mireya y Haizea
 * HEREDA DE USUARIO
 */

public class Cliente extends Usuario{
	

	private long numero_tarjeta; 



<<<<<<< HEAD
	public Cliente(String nombre, String apellido, String correo, char[] contraseÃ±a, long numero_tarjeta) {
		super(nombre, apellido, correo, contraseÃ±a);
=======

	public Cliente(String nombre, String apellido, String correo, char[] contraseña, long numero_tarjeta) {
		super(nombre, apellido, correo, contraseña);
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

	/** Permite introducir nÃºmero de tarjeta 
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

