package VentanasTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Ventanas.Registro;

public class RegistroTest {

	@Test
	public void compruebaCorreo() {
		assertTrue(Registro.comprobarCorreo("universidad@deusto.com"));
		assertFalse(Registro.comprobarCorreo("universidad.com"));
	}

}
