package edu.elsmancs.domain;

import java.util.ArrayList;
import java.util.List;

public class Receptivo {

	private List<GuestDispatcher> observers = new ArrayList<GuestDispatcher>();

	public Receptivo() {
	};

	public void registra(GuestDispatcher interfaz) {
		observers.add(interfaz);
	}

	public void dispatch(CreditCard invitado) {
		for (GuestDispatcher accionFiesta : observers) {
			accionFiesta.dispatch(invitado);
		}
	}
}
