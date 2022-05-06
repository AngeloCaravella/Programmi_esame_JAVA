package it.unisannio.studenti.caravella.angelo.utils;

import it.unisannio.studenti.caravella.angelo.classes.Volo;

public class FlightsTesterByStartCity implements Tester {

	public FlightsTesterByStartCity(String cit_p) {
		this.cit_p = cit_p;
	}

	@Override
	public boolean Verify(Object o) {
		Volo v = null;
		if (o instanceof Volo) {
			v = (Volo) o;
			if (v.getCitta_p().equals(cit_p))
				return true;

		}
		return false;
	}

	String cit_p;

}
