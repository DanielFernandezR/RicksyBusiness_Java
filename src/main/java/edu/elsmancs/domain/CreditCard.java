package edu.elsmancs.domain;


/**
 * CreditCard representa la tarjeta de credito con la cual vamos a diferenciar a cada invitado de la fiesta
 * 
 * @author dani
 *
 */
public class CreditCard {

	private final String owner;
	private final String number;
	private double credit = 3000.0;
	private final String Symbol = "EZI";

	/**
	 * Construye e inicializa una tarjeta de credito con
	 * el propietario y el numero de tarjeta pasado.(owner, number)
	 * @param owner Nombre de la persona.
	 * @param number Numero de la tarjeta de credito.
	 */
	public CreditCard(final String owner, final String number) {
		this.owner = owner;
		this.number = number;
	}

	public String number() {
		return this.number;
	}

	public double credit() {
		return this.credit;
	}

	@Override
	public String toString() {
		return "owner: " + this.owner + "\n" + "number: " + number() + "\n" + "credit: " + credit() + this.Symbol;
	}

	/**
	 * Se encarga de saber si tiene dinero en la tarjeta para poder pagar el UFO.
	 * @param initialCredits Corresponde al dinero que deben pagar por un UFO
	 * @return Devuelve True si puede pagar el ufo o False si no tiene suficiente dinero.
	 */
	public boolean pay(double initialCredits) {
		if (credit() - initialCredits >= 0) {
			this.credit -= initialCredits;
			return true;
		} else {
			return false;
		}
	}
}
