package it.unisannio.studenti.caravella.angelo.utils;

import it.unisannio.studenti.caravella.angelo.classes.Esercitazione;
import java.util.*;

public class EsercitazioneTesterA implements Tester {

	public EsercitazioneTesterA(String attrezzatura) {
		this.attrezzatura = attrezzatura;

	}

	@Override
	public boolean Verify(Object o) {
		Esercitazione e = null;
		if (o instanceof Esercitazione) {
			e = (Esercitazione) o;
			LinkedList<String> attrezzature = e.getAttrezzature();
			for (String a : attrezzature) {
				if (a.strip().equals(attrezzatura))
					return true;
			}
		}
		return false;
	}

	private String attrezzatura;

}
