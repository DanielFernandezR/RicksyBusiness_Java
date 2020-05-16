package edu.elsmancs.domain;

/**
 * CrystalExpender es un repartidor de bebidas para la fiesta con un pack inicial a un precio determinado.
 * @author dani
 *
 */

public class CrystalExpender implements GuestDispatcher {

	private int stock = 0;
	private double itemCost = 50;

	/**
	 * Construye e inicializa una máquina encargada de contar el stock de bebidas y su precio.
	 * @param stock El número de packs de bebidas que quedan.
	 * @param itemCost El precio del pack de bebidas.
	 */
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

	/**
	 * Se encarga de bajar en 1 el stock si un invitado pide un pack y puede pagarlo.
	 * @param invitado Corresponde a la persona que quiere pagar por un pack.
	 */
	@Override
	public void dispatch(CreditCard invitado) {
		if (stock() > 0 && invitado.pay(itemCost)) {
			this.stock -= 1;
		}
	}
}
