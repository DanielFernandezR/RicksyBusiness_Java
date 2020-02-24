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

	public String number() {
		return this.number;
	}

	public double credit() {
		return this.credit;
	}

	public String toString() {
		return "owner: " + this.owner + "\n" + "number: " + number() + "\n" + "credit: " + credit() + this.Symbol;
	}

	public boolean pay(double initialCredits) {
		if (credit() - initialCredits >= 0) {
			this.credit -= initialCredits;
			return true;
		} else {
			return false;
		}
	}
}
