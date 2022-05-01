package it.unisannio.studenti.caravella.angelo.utils;

import it.unisannio.studenti.caravella.angelo.classes.Volo;

public class FlightTester implements Tester {

	public FlightTester(String id) {

		this.id = id;
	}

	@Override
	public boolean Verify(Object o) {
		Volo v = null;
		if (o instanceof Volo) {
			v = (Volo) o;
			if (v.getIdentificativo().equals(id))
				return true;

		}
		return false;
	}

	private String id;
}
