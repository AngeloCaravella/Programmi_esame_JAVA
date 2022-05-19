package it.unisannio.studenti.caravella.angelo.utils;

import it.unisannio.studenti.caravella.angelo.classes.Esercitazione;

public class EsercitazioneTesterC implements Tester {

	public EsercitazioneTesterC(String nome_campo) {
		this.nome_campo = nome_campo;
	}

	@Override
	public boolean Verify(Object o) {
		Esercitazione e = null;
		if (o instanceof Esercitazione) {
			e = (Esercitazione) o;
			if (e.getNome_campo_m().strip().equals(nome_campo))
				return true;

		}
		return false;
	}

	private String nome_campo;
}
