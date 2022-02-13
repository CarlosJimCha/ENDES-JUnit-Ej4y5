package ENDES.Ejercicio5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaTest {

	@Test
	void testIngresarDouble() {
		Cuenta cuenta = new Cuenta ("00001","Don Pepito");
		try {
			cuenta.ingresar(100);
			assertTrue(cuenta.getSaldo()==100);
		}
		catch (Exception e1) {
			fail("Error al ingresar saldo");
		}
	}


	@Test
	void testRetirarDouble() {
		Cuenta cuenta = new Cuenta ("00001","Don Pepito");
		try 		{
		cuenta.ingresar(100);
		cuenta.retirar(55);
		}
		catch (Exception e2) {	
			fail("Error al ingresar y retirar el saldo");
		}
		assertTrue(cuenta.getSaldo()==45);
	}

}
