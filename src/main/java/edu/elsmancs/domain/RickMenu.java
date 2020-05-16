package edu.elsmancs.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * RickMenu es un pack de bienvenida de comida para la fiesta
 * @author dani
 *
 */
public class RickMenu implements GuestDispatcher {

	private int stock = 100;
	private final double costMenu = 10;

	public RickMenu() {
	}

	/**
	 * Resta 1 al stock del pack de bienvenida de la fiesta si lo puede pagar el invitado
	 * @param invitado La tarjeta de credito del invitado que quiere pagar.
	 */
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
