package it.unisannio.studenti.caravella.angelo.classes;

import java.io.PrintStream;
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
		this.eserc = new LinkedList<Esercitazione>();
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
			if (es.equals("#"))
				break;
			esr.add(es);
		} while (!es.equals("#"));
		return new Iscritto(mat, nome, cognome, esr);

	}

	public static Iscritto read() throws ParseException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Inserisci la matricola ");
		String mat = sc.nextLine();
		if (mat.equals(""))
			return null;

		System.out.println("Inserisci il nome: ");
		String nome = sc.nextLine();
		if (nome.equals(""))
			return null;

		System.out.println("Inserisci il cognome: ");
		String cognome = sc.nextLine();
		if (cognome.equals(""))
			return null;

		String at = null;
		LinkedList<String> esr = new LinkedList<String>();
		do {

			System.out.println("Inserisci l'esercitazione: ");
			at = sc.nextLine();

			esr.add(at);
		} while (!at.equals(""));

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

	/**
	 * @return the eserc
	 */
	public LinkedList<Esercitazione> getEserc() {
		return eserc;
	}

	public void addEs(Esercitazione es) {

		this.eserc.add(es);
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	public void Print(PrintStream ps) {
		ps.println(this.getMatricola());
		ps.println(this.getNome());
		ps.println(this.getCognome());

		for (String s : this.esercitazioni) {
			ps.println(s);
		}
		ps.println("#");

	}

	private String matricola;
	private String nome;
	private String cognome;
	private LinkedList<String> esercitazioni;
	private LinkedList<Esercitazione> eserc;

}
