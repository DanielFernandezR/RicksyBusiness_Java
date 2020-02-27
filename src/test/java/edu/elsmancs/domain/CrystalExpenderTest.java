package edu.elsmancs.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CrystalExpenderTest {

	CrystalExpender expender = null;

	@Test
	public void stockTest() {
		CrystalExpender expender = new CrystalExpender(5, 40);
		assertEquals(5, expender.stock());
	}

	@Test
	public void dispatchTest() {
		CrystalExpender expender = new CrystalExpender(5, 40);
		CreditCard invitado = new CreditCard("Dani Fernandez", "4876490012345678");
		double delta = 0.001;
		expender.dispatch(invitado);
		assertEquals(2960, invitado.credit(), delta);
		assertEquals(4, expender.stock());
	}

	@Test
	public void dispatchTestNoCreditos() {
		CrystalExpender expender = new CrystalExpender(5, 40);
		CreditCard invitado = new CreditCard("Dani Fernandez", "4876490012345678");
		double delta = 0.001;
		invitado.pay(2990);
		expender.dispatch(invitado);
		assertEquals(10, invitado.credit(), delta);
		assertEquals(5, expender.stock());
	}
}
