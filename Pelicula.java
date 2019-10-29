
// clase que tiene todas las caracteristicas de una pelicula concreta 
// titulo 
// descripcion 
// duración 
// video del trailer 
// cartelera 
// director ? 


public class Pelicula {

	private String titulo_peli; 
	private String descrip_peli; 
	private int duracion_peli; 
	private String director_peli; 
	//...

	
	/** Constructor
	 * @param titulo_peli
	 * @param descrip_peli
	 * @param duracion_peli
	 * @param director_peli
	 */
	public Pelicula(String titulo_peli, String descrip_peli, int duracion_peli, String director_peli) {
		super();
		this.titulo_peli = titulo_peli;
		this.descrip_peli = descrip_peli;
		this.duracion_peli = duracion_peli;
		this.director_peli = director_peli;
	}
	
	
	// GETTERS AND SETTERS
	
	public String getTitulo_peli() {
		return titulo_peli;
	}

	public void setTitulo_peli(String titulo_peli) {
		this.titulo_peli = titulo_peli;
	}

	public String getDescrip_peli() {
		return descrip_peli;
	}

	public void setDescrip_peli(String descrip_peli) {
		this.descrip_peli = descrip_peli;
	}

	public int getDuracion_peli() {
		return duracion_peli;
	}

	public void setDuracion_peli(int duracion_peli) {
		this.duracion_peli = duracion_peli;
	}

	public String getDirector_peli() {
		return director_peli;
	}

	public void setDirector_peli(String director_peli) {
		this.director_peli = director_peli;
	}


	@Override
	public String toString() {
		return "Pelicula [Titulo=" + titulo_peli + ", Descripción=" + descrip_peli + ", Duración="
				+ duracion_peli + ", Director=" + director_peli + "]";
	}

	
	public static void main(String[] args) {
		Pelicula p1 = new Pelicula("R", "---------", 180, "A");
		System.out.println(p1);
	}
	
	
	
}
