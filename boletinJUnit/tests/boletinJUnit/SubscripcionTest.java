package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubscripcionTest {

	@Test
	void testSubscripcion() {
		boolean prueba = false;
		Subscripcion s = new Subscripcion(66, 12);
		if (s != null)
			prueba = true;
		assertTrue(prueba, "Error, los valores introducidos son err�neos");
		
	}

	@Test
	void testPrecioPorMes() {
		boolean prueba = true;
		Subscripcion s = new Subscripcion(40, 4);
		double p = s.precioPorMes();
		if (p * 4 < 40)
			prueba = false;
		assertTrue(prueba,"Error, la subscripci�n mensual nos hace perder dinero");
	}

	@Test
	void testCancel() {
		boolean prueba = true;
		Subscripcion s = new Subscripcion(40, 4);
		s.cancel();
		if (s.precioPorMes() > 0)
			prueba = false;
		assertTrue(prueba, "Error, la subscripci�n no ha sido cancelada con �xito");
	}

}
