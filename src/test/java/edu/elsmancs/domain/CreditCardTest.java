package edu.elsmancs.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CreditCardTest {

	CreditCard prueba = null;

	@Test
	public void testConstructor() {
		CreditCard prueba = new CreditCard("Dani Fernandez", "4876490012345678");
		double delta = 0.001;
		assertEquals(3000, prueba.credit(), delta);
		assertEquals("4876490012345678", prueba.number());
	}

	@Test
	public void payTest() {
		CreditCard prueba = new CreditCard("Dani Fernandez", "4876490012345678");
		double delta = 0.001;
		prueba.pay(200);
		assertEquals(2800, prueba.credit(), delta);
	}

	@Test
	public void payTestSinCreditosSuficientes() {
		CreditCard prueba = new CreditCard("Dani Fernandez", "4876490012345678");
		double delta = 0.001;
		prueba.pay(3001);
		assertEquals(3000, prueba.credit(), delta);
	}
}
