package edu.elsmancs.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UfosPark implements GuestDispatcher {

	private final double fee = 500;
	private Map<String, String> flota = new HashMap<String, String>();

	public UfosPark() {
	}

	public void add(String ovni) {
		flota.put(ovni, null);
	}

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
