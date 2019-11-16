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
	
	private int numero_sala; // Hace referencia al número de la sala 
	private int capacidad_sala; // hace referencia al número de asiesntos de cada salsa
	// meter asientos 

	public Sala(int numero_sala, int capacidad_sala) {
		this.numero_sala = numero_sala;
		this.capacidad_sala = capacidad_sala;
	}

}