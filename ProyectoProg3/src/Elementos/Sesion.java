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
	private int cod_peli; 
	private int cod_sesion;
	// Array list asiento 
	// Arraylist usuario 
	
	// fechas ( dia , mes , hora ) 
	// Array de peli 
	// array de sala 
	

	public int getCod_sesion() {
		return cod_sesion;
	}

	public void setCod_sesion(int cod_sesion) {
		this.cod_sesion = cod_sesion;
	}

	public Sesion() {
		// TODO Auto-generated constructor stub
	}

	/////CONSTRUCTOR/////
	public Sesion(int cod_sesion, Date fecha, String HoraI, int iD_sala, int Cod_peli) {
		super();
		this.cod_sesion = cod_sesion;
		this.fecha = fecha;
		this.HoraI = HoraI;
		this.ID_sala = iD_sala;
		this.cod_peli = Cod_peli;
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
		return cod_peli;
	}

	public void setID_pelicula(int Cod_peli) {
		cod_peli = Cod_peli;
	}

	@Override
	public String toString() {
		return "Sesion [fecha=" + fecha + ", HoraI=" + HoraI + ", ID_sala=" + ID_sala + ", cod_pelicula=" + cod_peli
				+ "]";
	}
	

}