package edu.elsmancs.domain;

public class CrystalExpender implements GuestDispatcher {

	private int stock = 0;
	private double itemCost = 50;

	public CrystalExpender(int stock, double itemCost) {
		this.stock = stock;
		this.itemCost = itemCost;
	}

	public int stock() {
		return this.stock;
	}

	@Override
	public String toString() {
		return "stock: " + stock() + "\n" + "cost: " + this.itemCost;
	}

	@Override
	public void dispatch(CreditCard invitado) {
		if (stock() > 0 && invitado.pay(itemCost)) {
			this.stock -= 1;
		}
	}
}
