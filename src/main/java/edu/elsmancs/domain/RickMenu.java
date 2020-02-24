package edu.elsmancs.domain;

public class RickMenu implements GuestDispatcher {

	private int stock = 0;
	private double costMenu = 10;

	public RickMenu(int stock, double costMenu) {
		this.stock = stock;
		this.costMenu = costMenu;
	}

	@Override
	public void dispatch(CreditCard invitado) {
		if (invitado.pay(costMenu) && stock() > 0) {
			this.stock -= 1;
		}
	}

	private int stock() {
		return this.stock;
	}

	public String toString() {
		return ("\nPedidos de RickMenus:\n" + "===============" + "\n" + "stock: " + stock() + "\n");
	}

}
