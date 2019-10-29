package VentanasTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Ventanas.Registro;

public class RegistroTest {

	@Test
	public void compruebaCorreo() {
		assertTrue(Registro.comprobarCorreo("universidad@deusto.com", false));
		assertTrue(Registro.comprobarCorreo("usuario123@ejemplo.es", false));
		assertFalse(Registro.comprobarCorreo("universidad.com", false));
		assertFalse(Registro.comprobarCorreo("ejemplo@error", false));
	}

}
