package it.unisannio.studenti.caravella.angelo.classes;

import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;

public class Iscritto {

	/**
	 * @param matricola
	 * @param nome
	 * @param cognome
	 * @param esercitazioni
	 */
	public Iscritto(String matricola, String nome, String cognome, LinkedList<String> esercitazioni) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.esercitazioni = esercitazioni;
		this.eserc= new LinkedList<Esercitazione>();
	}

	public static Iscritto read(Scanner sc) {
		if (!sc.hasNextLine())
			return null;
		String mat = sc.nextLine();
		if (!sc.hasNextLine())
			return null;
		String nome = sc.nextLine();

		if (!sc.hasNextLine())
			return null;
		String cognome = sc.nextLine();

		String es = null;
		LinkedList<String> esr = new LinkedList<String>();
		do {
			if (!sc.hasNextLine())
				return null;
			es = sc.nextLine();
			if (!es.equals("#"))
				esr.add(es);
		} while (!es.equals("#"));
		return new Iscritto(mat, nome, cognome, esr);

	}
	
	@Override
	public String toString() {
		return "Iscritto [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", esercitazioni="
				+ esercitazioni + "]";
	}

	/**
	 * @return the matricola
	 */
	public String getMatricola() {
		return matricola;
	}

	/**
	 * @return the esercitazioni
	 */
	public LinkedList<String> getEsercitazioni() {
		return esercitazioni;
	}

	public void addEs(Esercitazione es) {
		
		this.eserc.add(es);
	}
	
	
	private String matricola;
	private String nome;
	private String cognome;
	private LinkedList<String> esercitazioni;
	private LinkedList<Esercitazione> eserc;
	
}
