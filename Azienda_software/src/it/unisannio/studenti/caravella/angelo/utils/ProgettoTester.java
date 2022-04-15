package it.unisannio.studenti.caravella.angelo.utils;

import it.unisannio.studenti.caravella.angelo.classes.Progetto;

public class ProgettoTester implements Tester {

	public ProgettoTester(String matricola) {
		this.matricola = matricola;
	}

	@Override
	public boolean Verify(Object o) {

		Progetto p = null;

		if (o instanceof Progetto) {

			p = (Progetto) o;
			if (p.getMatricola_c().equals(matricola))
				return true;
		}

		return false;
	}

	private String matricola;

}
