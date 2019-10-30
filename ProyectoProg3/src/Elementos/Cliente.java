package ProyectoProg3.src.Elementos;

// Clase que guarda la informaci�n de un cliente 

// nombre 
// apellidos
// correo electronico 
// contrase�a ? 
// datos bancarios 
// 


public class Cliente extends Usuario{
	

	private long numero_tarjeta; 




	public Cliente(String nombre, String apellido, String correo, char[] contrase�a, long numero_tarjeta) {
		super(nombre, apellido, correo, contrase�a);
		this.numero_tarjeta = numero_tarjeta;
	}



	// GETTERS AND SETTERS
	
	public long getNumero_tarjeta() {
		return numero_tarjeta;
	}

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

