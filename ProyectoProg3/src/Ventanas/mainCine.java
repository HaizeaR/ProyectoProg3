package Ventanas;

import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;



// clase principal que ejecuta el programa 
// el cine se tiene que abrir con la cartelera incial o una ventana de inicio 
// orden : 
// 1 cartera general 
// 2 peli individual 
// asientos 
// log in 
// resgistro 



public class mainCine {


	public static Logger log ; 

	public static void main(String[] args) throws SecurityException, IOException {
		Cartelera vent = new Cartelera();
		vent.setVisible(true);

		log = Logger.getLogger("log-cine");
		log.log(Level.INFO, "Inicio de programa" + (new Date()));
		Handler h = new FileHandler("log-cine.xml", true); 
		h.setLevel(Level.INFO);
		log.addHandler(h);
		log.log(Level.FINE, "Fin del programa"); 




	}


}

	
	
	
	
	

