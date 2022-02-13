package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class OperadorAritmeticoTest {

	@Test
	void testSuma() {
		boolean prueba = false;
		OperadorAritmetico o = new OperadorAritmetico();
		int n = o.suma(8,4);
		if (n == 8+4)
			prueba = true;
		assertTrue(prueba, "Error en el método 'suma'");
	}

	@Test
	void testDivision() {
		try {
		boolean prueba = false;
		OperadorAritmetico o = new OperadorAritmetico();
		int n = o.division(8, 4);
		if (n == 8/4)
			prueba = true;
		}
		catch (Exception e){
			fail("Error en la división");
		}
	}

}
