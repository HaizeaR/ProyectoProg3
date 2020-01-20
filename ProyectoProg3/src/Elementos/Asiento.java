package Elementos;


public class Asiento {

	// Pensar si queremos código individual de asiento o
	// si queremos que la coordenada sea el código

	private int codigo;
	private int fila;
	private int columna;
	private int id_sala; // Foreing key en BD 
	
	// Bloques de 10*10
	
	private boolean ocupado = false ; 
	// idea para que si ocupado = true se pone a rojo en la ventana SalaYAsiento2
	
	

	
	
	private String nombre; // cambia en función de si está seleccionado o no

	// asiento_v --> seleccionado
	// asiento_g --> libre -- por defecto este
	// asiento_r --> ocupado

	/**
	 * Constructor de la clase Asiento
	 * 
	 * @param codigo
	 * @param fila
	 * @param columna
	 */
	public Asiento(int codigo, int fila, int columna, boolean ocupado, int id_sala) {
		this.codigo = codigo;
		this.fila = fila;
		this.columna = columna;
		this.ocupado = ocupado; 
		this.id_sala = id_sala; 

	}

	// GETTERS AND SETTERS

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public int getId_sala() {
		return id_sala;
	}

	public void setId_sala(int id_sala) {
		this.id_sala = id_sala;
	}

	
	@Override
	public String toString() {
		return "Asiento [Codigo=" + codigo + ", Coordenada= (" + fila + "-" + columna + "), Ocupado: "+ ocupado + " ID_sala= " + id_sala + "]";
	}



}