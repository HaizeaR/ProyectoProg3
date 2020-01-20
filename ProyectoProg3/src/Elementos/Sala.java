package Elementos;

// 
// Clase que permite la creación de una sala 
// tamaño ( numero de asientos) 
// numero de sala 
//

/** Clase con atributos de una sala
 * @author Unai, Mireya y Haizea
 *
 */
public class Sala {
	// ID 
	private int numero_sala; // Hace referencia al número de la sala  
	private int capacidad_sala; // hace referencia al número de asiesntos de cada salsa
	private int ID_cine; 
	private int cod_sesion; 
	// meter asientos 

	public Sala(int numero_sala, int capacidad_sala, int ID_cine, int cod_sesion) {
		this.numero_sala = numero_sala;
		this.capacidad_sala = capacidad_sala;
		this.ID_cine = ID_cine;
		this.cod_sesion = cod_sesion; 
	}

	public int getCod_sesion() {
		return cod_sesion;
	}

	public void setCod_sesion(int cod_sesion) {
		this.cod_sesion = cod_sesion;
	}

	public int getNumero_sala() {
		return numero_sala;
	}

	public void setNumero_sala(int numero_sala) {
		this.numero_sala = numero_sala;
	}

	public int getCapacidad_sala() {
		return capacidad_sala;
	}

	public void setCapacidad_sala(int capacidad_sala) {
		this.capacidad_sala = capacidad_sala;
	}

	public int getID_cine() {
		return ID_cine;
	}

	public void setID_cine(int iD_cine) {
		ID_cine = iD_cine;
	}

	@Override
	public String toString() {
		return "Sala [numero_sala=" + numero_sala + ", capacidad_sala=" + capacidad_sala + ", ID_cine=" + ID_cine
				+ ", cod_sesion=" + cod_sesion + "]";
	}
	
	
	

}