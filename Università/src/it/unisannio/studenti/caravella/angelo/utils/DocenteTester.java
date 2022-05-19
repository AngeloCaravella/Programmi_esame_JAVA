package it.unisannio.studenti.caravella.angelo.utils;

import it.unisannio.studenti.caravella.angelo.classes.Docente;

public class DocenteTester implements Tester{

	public DocenteTester(String nome, String cognome) {
		this.nome=nome;
		this.cognome=cognome;
	}
	@Override
	public boolean Verify(Object o) {
		Docente doc= null;
		if( o instanceof Docente) {
			doc= (Docente)o;
			if(doc.getNom().equals(nome)&& doc.getCog().equals(cognome))
				return true;
		}
		return false;
	}

	private String nome;
	
	private String cognome;
}
