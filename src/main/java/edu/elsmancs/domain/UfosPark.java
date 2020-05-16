package edu.elsmancs.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UfosPark es el vendedor de ufos el cual un invitado podrá comprar solo 1 ufo.
 * @author dani
 *
 */
public class UfosPark implements GuestDispatcher {

	private final double fee = 500;
	private Map<String, String> flota = new HashMap<String, String>();

	public UfosPark() {
	}

	/**
	 * Añade un ovni a la flota de ovnis (a la lista flota)
	 * @param ovni Es el nombre del UFO que quieres meter en la lista.
	 */
	public void add(String ovni) {
		flota.put(ovni, null);
	}

	/**
	 * Elimina de la lista de ufos el UFO que compre el invitado siempre que tenga dinero el la tarjeta.
	 * @param invitado La tarjeta de credito del invitado que quiere pagar.
	 */
	@Override
	public void dispatch(CreditCard invitado) {

		for (String ufo : flota.keySet()) {
			if (flota.containsValue(invitado.number()) == false) {
				if ((flota.get(ufo) == null) && (invitado.pay(fee))) {
					flota.put(ufo, invitado.number());
					break;
				}
			}
		}
	}

	/**
	 * Devuelve el nombre del ufo asociado a la tarjeta de credito pasada como parametro.
	 * @param number El numero de la tarjeta de credito
	 * @return El nombre del UFO.
	 */
	public String getUfoOf(String number) {
		String nameUfo = null;
		for (String ufo : flota.keySet()) {
			if (flota.get(ufo) == number) {
				nameUfo = ufo;
			}
		}
		return nameUfo;
	}

	@Override
	public String toString() {
		List<String> ListofKeys = new ArrayList<String>(flota.keySet());
		return ListofKeys.toString();
	}
}
