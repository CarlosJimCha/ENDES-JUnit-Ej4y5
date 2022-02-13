package ENDES.Ejercicio5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TarjetaTest {

	Tarjeta tarjeta;
	Cuenta cuenta;
	
	@Test
	void test() throws Exception {
		cuenta = new Cuenta("00001","Don Pepito");
		cuenta.ingresar(100);
		boolean t = tarjeta != null;
		assertFalse(t,"Error al crear la tarjeta");
	}

}
