package Elementos;

import java.util.Date;

/** Clase donde se registra la fecha y horario de peli
 * Añadir peliculas y salas
 * 
 * @author Unai, Mireya y Haizea
 *
 */
public class Sesion {
	
	private Date fecha; 
	private String HoraI;
	private int ID_sala; 
	private int ID_pelicula; 
	// Array list asiento 
	// Arraylist usuario 
	
	// fechas ( dia , mes , hora ) 
	// Array de peli 
	// array de sala 
	

	public Sesion() {
		// TODO Auto-generated constructor stub
	}

	/////CONSTRUCTOR/////
	public Sesion(Date fecha, String HoraI, int iD_sala, int iD_pelicula) {
		super();
		this.fecha = fecha;
		this.HoraI = HoraI;
		this.ID_sala = iD_sala;
		this.ID_pelicula = iD_pelicula;
	}

	
	////GETTERS AND SETTERS//////
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHoraI() {
		return HoraI;
	}

	public void setHoraI(String horaI) {
		HoraI = horaI;
	}

	public int getID_sala() {
		return ID_sala;
	}

	public void setID_sala(int iD_sala) {
		ID_sala = iD_sala;
	}

	public int getID_pelicula() {
		return ID_pelicula;
	}

	public void setID_pelicula(int iD_pelicula) {
		ID_pelicula = iD_pelicula;
	}

	@Override
	public String toString() {
		return "Sesion [fecha=" + fecha + ", HoraI=" + HoraI + ", ID_sala=" + ID_sala + ", ID_pelicula=" + ID_pelicula
				+ "]";
	}
	

}