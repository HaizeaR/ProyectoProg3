package Elementos;

import java.util.ArrayList;


// REALMENTE NO USAMOS ESTA CLASE, HACEMOS LAS TABLAS DE OTRA FORMA 



public class TablaHorario extends Tabla {
	
	/** Crea una tabla de horario de datos vacía (sin cabeceras ni datos)
	 */
	public TablaHorario() {
		super();
	}
	
	/** Crea una tabla de análisis desde una tabla normal
	 * @param tabla	Tabla de origen
	 */
	public TablaHorario( Tabla tabla ) {
		cabeceras = tabla.cabeceras;
		tipos = tabla.tipos;
		dataO = tabla.dataO;
	}
	
	/** Crea una tabla de horario de datos vacía con cabeceras y tipos
	 * @param cabeceras	Nombres de las cabeceras de datos
	 */
	public TablaHorario( ArrayList<String> cabeceras, ArrayList<Class<?>> tipos ) {
		super( cabeceras, tipos );
	}
	
	public TablaHorario creaTablaHorario(String columnaAgrup, String... colsCalculadas) {
		// 1. Crear estructura de tabla
		int colAgrup = cabeceras.indexOf( columnaAgrup );
		if (colAgrup==-1) return null;
		if (colsCalculadas.length==0) { // Si no se indican las columnas a añadir, se incluyen todas las numéricas (excepto la de agrupación)
			ArrayList<String> lC = new ArrayList<>();
			for (int i=0; i<tipos.size(); i++) {
				Class<?> c = tipos.get(i);
				String n = cabeceras.get(i);
				if (!n.equals(columnaAgrup) && (c.equals(Integer.class) || c.equals(Double.class))) {  // Si no es la columna de agrupación y es numérica se añade
					lC.add( n );
				}
			}
			colsCalculadas = new String[ lC.size() ];
			for (int i=0; i<lC.size(); i++) {
				colsCalculadas[i] = lC.get(i);
			}
		}
		TablaHorario tablaHorario = new TablaHorario();
		tablaHorario.addColumna( columnaAgrup, tipos.get(colAgrup), null );
		for (String col : colsCalculadas) {
			tablaHorario.addColumna( col, Double.class, null );
		}
		
		return tablaHorario;
		
	}

}
