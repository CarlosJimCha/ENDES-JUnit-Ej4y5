package ENDES.Ejercicio5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreditoTest {
	
	Credito credito;
	Cuenta cuenta;

	@BeforeEach
	void setUp() throws Exception {
		cuenta=new Cuenta("00001","Don Pepito");
		cuenta.ingresar(100);
		Date hoy=new Date();
		long tiempo=Long.parseLong("31536000"); //1 año en segundos
		Date fecha = new Date(hoy.getTime()+ tiempo); 
		credito = new Credito("00001","Don Pepito", fecha, 1000);
		credito.setCuenta(cuenta);
	}

	@Test
	public void testIngresar(){
		try {
			double saldoAnteriorCuenta = cuenta.getSaldo();
			double saldoAnteriorTarjeta = credito.getSaldo();
			double creditoAnterior = credito.getCreditoDisponible();
			credito.ingresar(40);
			assertTrue(cuenta.getSaldo() == saldoAnteriorCuenta + 40);
			assertTrue(credito.getSaldo() == saldoAnteriorTarjeta);
			assertTrue(credito.getCreditoDisponible() == creditoAnterior);
		}
		catch (Exception e1) {
			fail("Error al ingresar dinero");
		}
	}

	@Test
	public void testRetirar() {
		try {
			double saldoAnteriorCuenta=cuenta.getSaldo();
			double saldoAnteriorTarjeta=credito.getSaldo();
			double creditoAnterior=credito.getCreditoDisponible();
			credito.retirar(30);
			assertTrue(cuenta.getSaldo()==saldoAnteriorCuenta);
			assertTrue(credito.getSaldo()==saldoAnteriorTarjeta-3);
			assertTrue(credito.getCreditoDisponible()==creditoAnterior-33);
		}
		catch (Exception e2){
			fail("Error al retirar dinero");
		}
	}

	@Test
	public void testLiquidar() {
		try {
			double saldoAnteriorCuenta=cuenta.getSaldo();
			credito.pagoEnEstablecimiento("La Cervecita", 12);
			credito.pagoEnEstablecimiento("Mercadono", 46);
			credito.liquidar(2, 2022);
			assertTrue(saldoAnteriorCuenta==cuenta.getSaldo()-58);
		}
		catch (Exception e3) {
			fail("Error al liquidar");
		}
	}

	
}
