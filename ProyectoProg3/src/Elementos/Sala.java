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
	// meter asientos 

	public Sala(int numero_sala, int capacidad_sala, int ID_cine) {
		this.numero_sala = numero_sala;
		this.capacidad_sala = capacidad_sala;
		this.ID_cine = ID_cine;
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
	
	
	

}