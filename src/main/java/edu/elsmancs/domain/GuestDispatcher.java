package edu.elsmancs.domain;

/**
 * Interfaz para abstraer los packs y poder pedir todos los packs de la fiesta a la vez.
 * @author dani
 *
 */
public interface GuestDispatcher {

	/**
	 * Restará en 1 el stock de lo que pide el invitado si lo puede pagar.
	 * @param invitado Es la persona que quiere comprar un pack.
	 */
	public void dispatch(CreditCard invitado);
}
