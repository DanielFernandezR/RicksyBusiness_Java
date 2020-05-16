package edu.elsmancs.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Receptivo se encarga de guardar en una lista todos los packs de bienvenida
 * y poder pedirlos todos a la vez al llegar un invitado.
 * @author dani
 *
 */
public class Receptivo {

	private List<GuestDispatcher> observers = new ArrayList<GuestDispatcher>();

	public Receptivo() {
	};

	/**
	 * Guarda en una lista todos los packs de bienvenida de la fiesta.
	 * @param interfaz Es la abstraccion de los packs de bienvenida.
	 */
	public void registra(GuestDispatcher interfaz) {
		observers.add(interfaz);
	}

	/**
	 * Resta 1 al stock del pack de bienvenida de la fiesta si lo puede pagar el invitado
	 * @param invitado La tarjeta de credito del invitado que quiere pagar.
	 */
	public void dispatch(CreditCard invitado) {
		for (GuestDispatcher accionFiesta : observers) {
			accionFiesta.dispatch(invitado);
		}
	}
}
