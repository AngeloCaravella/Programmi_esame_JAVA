package it.unisannio.studenti.caravella.angelo.classes;

import java.util.*;
import it.unisannio.studenti.caravella.angelo.utils.*;

public class Scuola {

	/**
	 * @param esercitazioni
	 * @param iscritti
	 */
	public Scuola(HashMap<String, Esercitazione> esercitazioni, HashMap<String, Iscritto> iscritti) {
		this.esercitazioni = esercitazioni;
		this.iscritti = iscritti;
	}

	public Scuola(Scanner sc1, Scanner sc2) {

		this.esercitazioni = new HashMap<String, Esercitazione>();
		Esercitazione eserc = Esercitazione.read(sc1);
		while (eserc != null) {
			this.esercitazioni.put(eserc.getCodice_id(), eserc);
			eserc = Esercitazione.read(sc1);
		}
		this.iscritti = new HashMap<String, Iscritto>();
		Iscritto iscritto = Iscritto.read(sc2);
		while (iscritto != null) {

			this.iscritti.put(iscritto.getMatricola(), iscritto);
			SearchEs(iscritto);
			iscritto = Iscritto.read(sc2);
		}

	}

	private void SearchEs(Iscritto is) {

		Esercitazione e = null;
		LinkedList<String> esercitazioni = is.getEsercitazioni();
		for (String s : esercitazioni) {

			try {
				e = SearchEs(s);
			} catch (EsercitazioniNotFoundException es) {
				System.err.println("Catturata un' eccezione di tipo EsercitazioniNotFoundException ");
			}
			e.addIscritto(is);

			is.addEs(e);
		}

	}

	private Esercitazione SearchEs(String s) {
		Esercitazione e = null;
		e = this.esercitazioni.get(s);
		if (e == null)
			throw new EsercitazioniNotFoundException("L'esercitazione non è stata trovata");
		return e;
	}

	public void CercaEsId(String id) {
		Esercitazione es = null;
		es = this.esercitazioni.get(id);

		if (es == null)
			throw new EsercitazioniNotFoundException("L'esercitazione non è stata trovata");
		System.out.println(es);
	}

	public void CercaIscritto(String matricola) {

		Iscritto is = null;
		is = this.iscritti.get(matricola);

		if (is == null)
			throw new IscrittoNotFoundException("L'iscritto non è stato trovato");
		System.out.println(is);

	}

	public Scuola CercaEsdellIscritto(String matricola) {

		IscrittoTester iscritto = new IscrittoTester(matricola);

		return this.FiltraIscritti(iscritto);
	}

	private Scuola FiltraIscritti(Tester ts) {

		Set<String> chiavi = this.iscritti.keySet();
		HashMap<String, Esercitazione> esercitazionifiltrate = new HashMap<String, Esercitazione>();
		HashMap<String, Iscritto> iscrittifiltrati = new HashMap<String, Iscritto>();

		for (String s : chiavi) {
			Iscritto i = this.iscritti.get(s);
			if (ts.Verify(i)) {
				iscrittifiltrati.put(s, i);
				LinkedList<Esercitazione> esercitazioni = i.getEserc();
				for (Esercitazione ee : esercitazioni) {
					esercitazionifiltrate.put(ee.getCodice_id(), ee);
				}
			}

		}
		return new Scuola(esercitazionifiltrate, iscrittifiltrati);
	}

	public Scuola FiltraIscrittoConMaggioriEsercitazioni() {

		Set<String> chiavi = this.iscritti.keySet();
		HashMap<String, Iscritto> iscrittifiltrati = new HashMap<String, Iscritto>();
		HashMap<String, Esercitazione> esercitazionifiltrate = new HashMap<String, Esercitazione>();

		int i = 0;
		int t = 0;
		Iscritto iscritto = null;
		for (String s : chiavi) {
			iscritto = this.iscritti.get(s);
			i = iscritto.getEserc().size();
			if (i > t)
				t = i;
		}

		for (String s : chiavi) {
			iscritto = this.iscritti.get(s);
			i = iscritto.getEserc().size();

			if (i == t) {
				iscrittifiltrati.put(iscritto.getMatricola(), iscritto);
				LinkedList<Esercitazione> esercitazioni = iscritto.getEserc();
				for (Esercitazione ee : esercitazioni) {
					esercitazionifiltrate.put(ee.getCodice_id(), ee);

				}

			}

		}
		return new Scuola(esercitazionifiltrate, iscrittifiltrati);
	}

	public Scuola CercaAttrezzatura(String attrezzatura) {
		EsercitazioneTesterA esA = new EsercitazioneTesterA(attrezzatura.strip());

		return this.FiltraEsercitazioni(esA);
	}

	public Scuola CercaCampo(String campo) {
		EsercitazioneTesterC esC = new EsercitazioneTesterC(campo.strip());

		return this.FiltraEsercitazioni(esC);
	}

	private Scuola FiltraEsercitazioni(Tester ts) {

		Set<String> chiavi = this.esercitazioni.keySet();
		HashMap<String, Iscritto> iscrittifiltrati = new HashMap<String, Iscritto>();
		HashMap<String, Esercitazione> esercitazionifiltrate = new HashMap<String, Esercitazione>();
		for (String s : chiavi) {
			if (ts.Verify(this.esercitazioni.get(s))) {
				esercitazionifiltrate.put(s, this.esercitazioni.get(s));
				LinkedList<Iscritto> iscrittin = this.esercitazioni.get(s).getIscritti();
				for (Iscritto i : iscrittin) {

					iscrittifiltrati.put(i.getMatricola(), i);
				}
			}

		}

		return new Scuola(esercitazionifiltrate, iscrittifiltrati);
	}

////////////////////////////////////////////////////////////////////	

	public void printIs() {

		this.iscritti.entrySet().forEach(entry -> {

			System.out.println(entry.toString());
		});

	}

	public void printEs() {

		this.esercitazioni.entrySet().forEach(entry -> {

			System.out.println(entry.toString());
		});

	}

	HashMap<String, Esercitazione> esercitazioni;
	HashMap<String, Iscritto> iscritti;

}
