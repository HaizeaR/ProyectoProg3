package Elementos;

public class Compra {
	
	
	//int ID_compra; 
	int cod_asiento; 
	int cod_sesion;
	String DNI; 
	
	public Compra( int cod_asiento, int cod_sesion, String dNI) {
	
		//ID_compra = iD_compra;
		this.cod_asiento = cod_asiento;
		this.cod_sesion = cod_sesion;
		DNI = dNI;
	}



	public int getCod_asiento() {
		return cod_asiento;
	}

	public void setCod_asiento(int cod_asiento) {
		this.cod_asiento = cod_asiento;
	}

	public int getCod_sesion() {
		return cod_sesion;
	}

	public void setCod_sesion(int cod_sesion) {
		this.cod_sesion = cod_sesion;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	
	@Override
	public String toString() {
		return "Compra [cod_asiento=" + cod_asiento + ", cod_sesion=" + cod_sesion
				+ ", DNI=" + DNI + "]";
	}


}
