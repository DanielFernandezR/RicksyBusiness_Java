package edu.elsmancs.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CreditCardTest {

	CreditCard prueba = null;

	@Test
	public void testConstructor() {
		CreditCard prueba = new CreditCard("Dani Fernandez", "4876490012345678");
		assertTrue(prueba.toString().contains("Dani"));
		assertTrue(prueba.toString().contains("4876"));
	}
}
