package edu.elsmancs.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UfosParkTest {

	UfosPark ufos = null;
	String[] ovnis = { "unx", "dox", "trex" };

	/**
	 * Testea el metodo añadir ovni a la flota de ufos
	 */
	@Test
	public void addUfoTest() {
		UfosPark ufos = new UfosPark();
		for (String ovni : ovnis) {
			ufos.add(ovni);
		}
		System.out.println(ufos.toString());
	}

	/**
	 * Testea el metodo reservar ovni y cargar el pago en la tarjeta de crédito. El
	 * crédito de la tarjeta varía.
	 */
	@Test
	public void dispatchTest() {
		UfosPark ufos = new UfosPark();
		CreditCard tarjeta = new CreditCard("Dani Fernandez", "4876490012345678");
		double delta = 0.001;
		for (String ovni : ovnis) {
			ufos.add(ovni);
		}
		ufos.dispatch(tarjeta);
		assertEquals(2500, tarjeta.credit(), delta);
	}

	/**
	 * Testea que no se pueda reservar un ovni si no hay crédito suficiente en la
	 * tarjeta. El crédito de la tarjeta no varía.
	 */
	@Test
	public void dispatchNoCreditTest() {
		UfosPark ufos = new UfosPark();
		CreditCard tarjeta = new CreditCard("Dani Fernandez", "4876490012345678");
		double delta = 0.001;
		for (String ovni : ovnis) {
			ufos.add(ovni);
		}
		tarjeta.pay(2600);
		ufos.dispatch(tarjeta);
		assertEquals(400, tarjeta.credit(), delta);
	}

	/**
	 * Testea que no se pueda reservar un ovni si ya existe un ovni reservado para
	 * esa tarjeta. El crédito de la tarjeta no varía.
	 */
	@Test
	public void dispatchUfoAlreadyReservedTest() {
		UfosPark ufos = new UfosPark();
		CreditCard tarjeta = new CreditCard("Dani Fernandez", "4876490012345678");
		double delta = 0.001;
		for (String ovni : ovnis) {
			ufos.add(ovni);
		}
		ufos.dispatch(tarjeta);
		assertEquals(2500, tarjeta.credit(), delta);
		ufos.dispatch(tarjeta);
		assertEquals(2500, tarjeta.credit(), delta);
	}

	/**
	 * Testea que no se pueda reservar un ovni si no existe ninguno disponible (sin
	 * reservar). El crédito de la tarjeta no varía.
	 */
	@Test
	public void dispatchNoUfoAvaliableTest() {
		UfosPark ufos = new UfosPark();
		CreditCard tarjeta = new CreditCard("Dani Fernandez", "4876490012345678");
		double delta = 0.001;
		ufos.dispatch(tarjeta);
		assertEquals(3000, tarjeta.credit(), delta);
	}

	/**
	 * Devuelve el UFO reservado para la tarjeta.
	 */
	@Test
	public void getUfoOfTest() {
		UfosPark ufos = new UfosPark();
		CreditCard tarjeta = new CreditCard("Dani Fernandez", "4876490012345678");
		ufos.add("UfoPro");
		ufos.dispatch(tarjeta);
		assertEquals("UfoPro", ufos.getUfoOf(tarjeta.number()));
	}
}
