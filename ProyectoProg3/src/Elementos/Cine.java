package Elementos;



/** Clase con características de un cine
 * @author Unai, Mireya y Haizea
 *
 */
public class Cine {

	// ELEMENTOS 
	// mismos atributos que en la BD 

	private int ID_cine;
	private String nombre_cine; 
	private String direccion_cine;

	// CONSTRUCTOR 

	public Cine(int cod_cine, String nombre_cine, String direccion_cine) {
		this.ID_cine = cod_cine;
		this.nombre_cine = nombre_cine;
		this.direccion_cine = direccion_cine;
	}


	// GETTERS AND SETTERS 


	public int getCod_cine() {
		return ID_cine;
	}


	public void setCod_cine(int ID_cine) {
		this.ID_cine = ID_cine;
	}


	public String getNombre_cine() {
		return nombre_cine;
	}


	public void setNombre_cine(String nombre_cine) {
		this.nombre_cine = nombre_cine;
	}


	public String getDireccion_cine() {
		return direccion_cine;
	}


	public void setDireccion_cine(String direccion_cine) {
		this.direccion_cine = direccion_cine;
	}


	// TO STRING 

	@Override
	public String toString() {
		return "Cine [cod_cine=" + ID_cine + ", nombre_cine=" + nombre_cine + ", direccion_cine=" + direccion_cine
				+ "]";
	}



}
