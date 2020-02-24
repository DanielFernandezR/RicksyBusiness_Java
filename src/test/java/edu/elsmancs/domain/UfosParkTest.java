package edu.elsmancs.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UfosParkTest {

	UfosPark prueba;

	@Test
	public void addTest() {
		UfosPark prueba = new UfosPark();
		String[] ufosID = { "primero", "segundo" };

		for (String ovni : ufosID) {
			prueba.add(ovni);
		}
		assertEquals(2, prueba.getFlota().size());
	}

	@Test
	public void dispatchTest() {
		UfosPark prueba = new UfosPark();
		CreditCard tarjeta = new CreditCard("Dani Fernandez", "4876490012345678");
		String[] ufosID = { "primero", "segundo" };

		for (String ovni : ufosID) {
			prueba.add(ovni);
			prueba.dispatch(tarjeta);
			assertEquals("primero", prueba.getUfoOf(tarjeta.number()));
		}
	}

}
