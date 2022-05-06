package it.unisannio.studenti.caravella.angelo.utils;

import it.unisannio.studenti.caravella.angelo.classes.Volo;

public class FlightsTesterByEndCity implements Tester {

	public FlightsTesterByEndCity(String cit_a) {
		this.cit_a = cit_a;
	}

	@Override
	public boolean Verify(Object o) {
		Volo v = null;
		if (o instanceof Volo) {
			v = (Volo) o;
			if (v.getCitta_a().equals(cit_a))
				return true;

		}
		return false;
	}

	String cit_a;

}
