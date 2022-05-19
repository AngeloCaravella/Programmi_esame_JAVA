package it.unisannio.studenti.caravella.angelo.classes;

import java.text.*;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;
import it.unisannio.studenti.caravella.angelo.utils.CorsoNotFoundException;
import it.unisannio.studenti.caravella.angelo.utils.DocenteNotFoundException;
import it.unisannio.studenti.caravella.angelo.utils.DocenteTester;
import it.unisannio.studenti.caravella.angelo.utils.Tester;

public class Segreteria {

	public Segreteria(Scanner sc1, Scanner sc2) throws ParseException {
		Docente doc = Docente.read(sc1);
		this.docenti = new HashMap<String, Docente>();
		while (doc != null) {
			this.docenti.put(doc.getC_f(), doc);
			doc = Docente.read(sc1);

		}
		Corso co = Corso.read(sc2);
		this.corsi = new HashMap<String, Corso>();
		while (co != null) {
			this.corsi.put(co.getCod_co(), co);
			CollegamentoDocenteCorsi(co);
			co = Corso.read(sc2);

		}

	}

	public Segreteria(HashMap<String, Docente> docentifiltrati, HashMap<String, Corso> corsifiltrati) {
		this.docenti = docentifiltrati;
		this.corsi = corsifiltrati;
	}

	public void CollegamentoDocenteCorsi(Corso co) {
		Docente doc = this.docenti.get(co.getC_f());
		try {
			if (doc == null)
				throw new DocenteNotFoundException(
						"Il docente con il codice fiscale: " + co.getC_f() + " non è stato trovato ");
		} catch (DocenteNotFoundException e) {
			System.err.println("Dato che il docente non è stato trovato va creato:");

		}
		doc.AddCorsi(co);
		co.setD(doc);

	}

	public Segreteria ElencoCorsiErogati(String no, String co) {
		DocenteTester ff = new DocenteTester(no, co);
		return this.FiltraPerSpecifiche(ff);
	}

	private Segreteria FiltraPerSpecifiche(Tester ff) {
		HashMap<String, Docente> docentifiltrati = new HashMap<String, Docente>();
		HashMap<String, Corso> corsifiltrati = new HashMap<String, Corso>();

		Set<String> chiavi = this.docenti.keySet();
		for (String s : chiavi) {
			if (ff.Verify(this.docenti.get(s)))

				docentifiltrati.put(s, this.docenti.get(s));
		}
		return new Segreteria(docentifiltrati, corsifiltrati);
	}

	public void ElencoCorsiErogati(String id_d) {
		Docente doc = this.docenti.get(id_d);
		if (doc == null)
			throw new DocenteNotFoundException("Il docente con il codice fiscale: " + id_d + " non è stato trovato ");

		printCorsi(doc.getCorsi());
	}

	public void InformazioniDocente(String id_co) {
		Corso co = this.corsi.get(id_co);
		if (co == null)
			throw new CorsoNotFoundException("Il corso con l'id: " + id_co + " non esiste");
		System.out.println(co.getD().toString());
	}

	private void printCorsi(LinkedList<Corso> co) {

		for (Corso c : co) {

			System.out.println(c.toString());
		}
	}

	public void PrintDocenti() throws ParseException {
		Set<String> chiavi = this.docenti.keySet();
		Scanner sc = new Scanner(System.in);
		Date data = null;
		if (this.docenti.size() > 1)

		{
			System.out.println("Ci sono degli omonimi, per favore si inserisca anche la data: ");
			String d = sc.nextLine();

			try {
				data = Constants.ddMMyyyy.parse(d);
			} catch (ParseException e) {
				d = sc.nextLine();
				data = Constants.ddMMyyyy.parse(d);
			}

		}

		for (String s : chiavi) {
			if (this.docenti.get(s).getData_n().equals(data))
				System.out.println(this.docenti.get(s));
		}
	}

	private HashMap<String, Docente> docenti;
	private HashMap<String, Corso> corsi;

}
