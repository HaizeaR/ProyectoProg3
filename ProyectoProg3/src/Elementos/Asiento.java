package Elementos;

public class Asiento {
	
	// Pensar si queremos código individual de asiento o 
	// si queremos que la coordenada sea el código 
	
	private int codigo; 
	private int fila; 
	private int columna;
	
	
	/** Constructor  de la clase Asiento
	 * @param codigo
	 * @param fila
	 * @param columna
	 */
	public Asiento(int codigo, int fila, int columna) {
		this.codigo = codigo;
		this.fila = fila;
		this.columna = columna;
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

	@Override
	public String toString() {
		return "Asiento [Codigo=" + codigo + ", Coordenada= (" + fila + "-" + columna +")]";
	} 
	
	

}
