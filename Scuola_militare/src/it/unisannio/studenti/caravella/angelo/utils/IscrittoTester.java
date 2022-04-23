package it.unisannio.studenti.caravella.angelo.utils;

import it.unisannio.studenti.caravella.angelo.classes.Iscritto;

public class IscrittoTester implements Tester {

	public IscrittoTester(String matricola) {
		this.matricola = matricola;
	}

	@Override
	public boolean Verify(Object o) {
		Iscritto is = null;
		if (o instanceof Iscritto) {
			is = (Iscritto) o;
			if (is.getMatricola().equals(matricola))
				return true;

		}
		return false;
	}

	private String matricola;
}
