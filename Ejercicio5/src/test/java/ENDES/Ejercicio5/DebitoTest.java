package ENDES.Ejercicio5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DebitoTest {

	Debito debito;
	Cuenta cuenta;
	
	@BeforeEach
	void setUp() throws Exception {
		cuenta=new Cuenta("00001","Don Pepito");
		cuenta.ingresar(100);
		Date hoy=new Date();
		long tiempo=Long.parseLong("31536000"); //1 año en segundos
		Date fecha=new Date(hoy.getTime()+ tiempo); 
		debito=new Debito("00001","Don Pepito", fecha);
		debito.setCuenta(cuenta);
	}
	
	@Test
	public void testRetirar100() {
		try	{
			debito.retirar(100);
			assertTrue(debito.getSaldo()==cuenta.getSaldo());
			assertTrue(debito.getSaldo()==0.0);
		}
		catch (Exception e1)	{
			fail("Error al retirar");
		}
	}

}
