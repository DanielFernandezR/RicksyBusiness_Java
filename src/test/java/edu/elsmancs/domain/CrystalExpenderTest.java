package edu.elsmancs.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CrystalExpenderTest {

	CrystalExpender prueba;

	@Test
	public void stockTest() {
		CrystalExpender prueba = new CrystalExpender(5, 40);
		assertTrue(prueba.toString().contains("stock: 5"));
	}

	@Test
	public void dispatchTest() {
		CrystalExpender prueba = new CrystalExpender(5, 40);
		CreditCard invitado = new CreditCard("Dani Fernandez", "4876490012345678");
		double delta = 0.001;
		prueba.dispatch(invitado);
		assertEquals(2960, invitado.credit(), delta);
	}
}
