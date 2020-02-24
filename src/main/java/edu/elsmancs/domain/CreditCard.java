package edu.elsmancs.domain;

public class CreditCard {

	private final String owner;
	private final String number;
	private double credit = 3000.0;
	private final String Symbol = "EZI";

	public CreditCard(final String owner, final String number) {
		this.owner = owner;
		this.number = number;
	}

	String number() {
		return this.number;
	}

	double credit() {
		return this.credit;
	}

	public String toString() {
		return "owner: " + this.owner + "\n" + "number: " + number() + "\n" + "credit: " + credit() + this.Symbol;
	}
}
