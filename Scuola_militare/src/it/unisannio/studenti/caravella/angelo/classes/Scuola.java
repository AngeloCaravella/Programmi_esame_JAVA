package it.unisannio.studenti.caravella.angelo.classes;

import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.EsercitazioniNotFoundException;
import it.unisannio.studenti.caravella.angelo.utils.IscrittoNotFoundException;
import it.unisannio.studenti.caravella.angelo.utils.IscrittoTester;

public class Scuola {

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
			SearchEs(iscritto.getEsercitazioni(), iscritto);
			this.iscritti.put(iscritto.getMatricola(), iscritto);

			iscritto = Iscritto.read(sc2);
		}

	}


	
	/**
	 * @param esercitazioni
	 * @param iscritti
	 */
	public Scuola(Map<String, Esercitazione> esercitazioni, Map<String, Iscritto> iscritti) {
		this.esercitazioni = esercitazioni;
		this.iscritti = iscritti;
	}

	
	public void CercaEsId(String id) {
		Esercitazione es = null;
		es= this.esercitazioni.get(id);
		
		if (es == null)
			throw new EsercitazioniNotFoundException("L'esercitazione non è stata trovata");
		System.out.println( es);
	}

	
	public void CercaIscritto(String matricola) {
		
		Iscritto is=null;
		is= this.iscritti.get(matricola);
		
		if( is== null)
			throw new IscrittoNotFoundException("L'iscritto non è stato trovato");
		System.out.println(is);
		
	}

	private void SearchEs(LinkedList<String> eser, Iscritto is) {

		Esercitazione es = null;
	
		for (String s : eser) {

			es = this.esercitazioni.get(s);

		}

		if (es == null)
			throw new EsercitazioniNotFoundException("L'esercitazione non è stata trovata");

		
		es.setI(is);

		is.addEs(es);

	}
	public Scuola CercaEsdellIscritto(String matricola) {
		
		IscrittoTester iscritto= new IscrittoTester(matricola);
		
		return this.CercaEs(iscritto, matricola);
	}
	
	private Scuola  CercaEs(IscrittoTester iscritto, String matricola) {
	
		
		Set<String> chiavi= this.iscritti.keySet(); 
		HashMap<String , Iscritto> iscrittifiltrati= new HashMap<String , Iscritto>();
		for( String s: chiavi)
		{
			if( iscritto.Verify(this.iscritti.get(s))) 
				iscrittifiltrati.put(matricola, this.iscritti.get(s));
			
		}
	
		
		return new Scuola( this.esercitazioni, iscrittifiltrati);
	}
	
	public void printEs() {
		
		this.iscritti.entrySet().forEach(entry->{
			
			System.out.println( entry.getValue().getEsercitazioni());
			
		});
		
		
	}

	public void print() {

		this.esercitazioni.entrySet().forEach(entry -> {

			System.out.println(entry.getKey() + entry.getValue());
		});
		this.iscritti.entrySet().forEach(entry -> {

			System.out.println(entry.getKey() + entry.getValue());
		});

	}

	Map<String, Esercitazione> esercitazioni;
	Map<String, Iscritto> iscritti;
	
}
