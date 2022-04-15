package it.unisannio.studenti.caravella.angelo.classes;

import java.text.ParseException;

import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.CapoNotFoundExecption;
import it.unisannio.studenti.caravella.angelo.utils.ProgettoNotFoundException;

public class Azienda {

	public Azienda(Scanner sc1, Scanner sc2) throws ParseException {

		Capo c = Capo.read(sc1);

		this.capiprogetto = new HashMap<String, Capo>();

		while (c != null) {
			this.capiprogetto.put(c.getMatricola(), c);
			c = Capo.read(sc1);

		}

		Progetto p = Progetto.read(sc2);
		this.progetto = new HashMap<String, Progetto>();

		while (p != null) {
			VerificaEsistenzaCapi(p);

			p = Progetto.read(sc2);

		}

	}

	private Azienda(HashMap<String, Capo> capiprogettof, HashMap<String, Progetto> progettif) {
		this.capiprogetto = capiprogettof;
		this.progetto = progettif;
	}

	public void VerificaEsistenzaCapi(Progetto p) {
		try {
			Capo capo = searchCapoByMatricola(p.getMatricola_c());

			p.setC(capo);
			capo.addProgettoDiretto(p);
			this.progetto.put(p.getId(), p);
		} catch (CapoNotFoundExecption ex) {
			System.err.println("Catched an exception of type CapoNotFoundExecption");
			System.err.println(ex.getMessage());
			System.err.println("It will not be considered");
		}
	}

	public Capo searchCapoByMatricola(String matricola_c) {
		Capo capo = this.capiprogetto.get(matricola_c);
		if (capo != null)
			return capo;
		throw new CapoNotFoundExecption("Non esiste il capo con la matricola " + matricola_c);
	}

	public Progetto searchProgettiById(String id) {
		Progetto progetto = this.progetto.get(id);
		if (progetto != null)
			return progetto;
		throw new ProgettoNotFoundException("Non esiste il progetto con l'id: " + id);
	}

	public Azienda FiltraProgettiDellImportoMax(int importo) {
		HashMap<String, Capo> capiprogettof = new HashMap<String, Capo>();

		HashMap<String, Progetto> progettif = new HashMap<String, Progetto>();

		Set<String> chiavi = this.progetto.keySet();
		for (String s : chiavi) {

			Progetto prog = this.progetto.get(s);
			if (prog.getImporto() > importo) {
				progettif.put(s, prog);
				capiprogettof.put(prog.getMatricola_c(), prog.getC());
			}
		}
		return new Azienda(capiprogettof, progettif);
	}

	public Azienda FiltraProgettiDellImportoMin(int importo) {

		HashMap<String, Capo> capiprogettof = new HashMap<String, Capo>();

		HashMap<String, Progetto> progettif = new HashMap<String, Progetto>();

		Set<String> chiavi = this.progetto.keySet();
		for (String s : chiavi) {

			Progetto prog = this.progetto.get(s);
			if (prog.getImporto() < importo) {
				progettif.put(s, prog);
				capiprogettof.put(prog.getMatricola_c(), prog.getC());
			}
		}
		return new Azienda(capiprogettof, progettif);
	}

	public HashMap<String, Capo> CercaProgettiDelCapoN(String nome) {

		HashMap<String, Capo> capiprogettof = new HashMap<String, Capo>();

		Set<String> chiavi = this.capiprogetto.keySet();

		for (String s : chiavi) {

			if (this.capiprogetto.get(s).getNome().equals(nome))
				capiprogettof.put(s, this.capiprogetto.get(s));

		}

		return capiprogettof;

	}

	public HashMap<String, Capo> CercaProgettiDelCapoC(HashMap<String, Capo> capiprogettof, String cognome) {

		Set<String> chiavi = this.capiprogetto.keySet();

		for (String s : chiavi) {

			if (this.capiprogetto.get(s).getCognome().equals(cognome))
				capiprogettof.put(s, this.capiprogetto.get(s));

		}

		return capiprogettof;
	}

	public void PrintProg(HashMap<String, Capo> capiprogettof) {

		capiprogettof.entrySet().forEach(entry -> {

			System.out.println(entry.getValue().getProgettiDiretti());
			System.out.println("");
		});
	}

	public void print() {

		this.capiprogetto.entrySet().forEach(entry -> {

			System.out.println(entry.getKey() + " " + entry.getValue());

		});

		this.progetto.entrySet().forEach(entry -> {

			System.out.println(entry.getKey() + " " + entry.getValue());
		});
	}

	public void CapiOrdinamento() {

		this.capiordinati = new TreeSet<Capo>();

		Set<String> chiavi = this.capiprogetto.keySet();

		for (String s : chiavi) {

			Capo c = this.capiprogetto.get(s);
			this.capiordinati.add(c);

		}

	}

	public void StampaCapiOrdinati() {

		for (Capo s : this.capiordinati) {
			System.out.println(s.toString());
		}
	}

	private HashMap<String, Capo> capiprogetto;

	private HashMap<String, Progetto> progetto;

	private Set<Capo> capiordinati;

}
