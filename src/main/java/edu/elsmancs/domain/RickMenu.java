package edu.elsmancs.domain;

import java.util.ArrayList;
import java.util.List;

public class RickMenu implements GuestDispatcher {

	private int stock = 100;
	private final double costMenu = 10;

	public RickMenu() {
	}

	@Override
	public void dispatch(CreditCard invitado) {
		if (invitado.pay(costMenu) && stock() > 0) {
			this.stock -= 1;
		}
	}

	public int stock() {
		return this.stock;
	}

	@Override
	public String toString() {
		List<GuestDispatcher> ListofGuests = new ArrayList<GuestDispatcher>();
		return ListofGuests.toString();
	}
}
