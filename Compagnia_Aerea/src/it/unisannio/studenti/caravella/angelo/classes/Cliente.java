package it.unisannio.studenti.caravella.angelo.classes;

import java.io.PrintStream;
import java.util.*;

public class Cliente {

	/**
	 * @param codice_fiscale
	 * @param nome
	 * @param cognome
	 */
	public Cliente(String codice_fiscale, String nome, String cognome) {
		this.codice_fiscale = codice_fiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.voli = new LinkedList<Volo>();
	}

	public static Cliente read(Scanner sc) {

		if (!sc.hasNextLine())
			return null;
		String cod = sc.nextLine();

		if (!sc.hasNextLine())
			return null;
		String nom = sc.nextLine();

		if (!sc.hasNextLine())
			return null;
		String cogn = sc.nextLine();

		return new Cliente(cod, nom, cogn);
	}

	public static Cliente read() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Inserisci il codice fiscale: ");
		String cod = sc.nextLine();
		if (cod.equals(""))
			return null;

		System.out.println("Inserisci il nome: ");
		String nom = sc.nextLine();
		if (nom.equals(""))
			return null;

		System.out.println("Inserisci il cognome: ");
		String cogn = sc.nextLine();
		if (cogn.equals(""))
			return null;
		return new Cliente(cod, nom, cogn);
	}

	@Override
	public String toString() {
		return "Cliente [codice_fiscale=" + codice_fiscale + ", nome=" + nome + ", cognome=" + cognome + ", voli="
				+ voli + "]";
	}

	/**
	 * @return the codice_fiscale
	 */
	public String getCodice_fiscale() {
		return codice_fiscale;
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

	/**
	 * @return the voli
	 */
	public LinkedList<Volo> getVoli() {
		return voli;
	}

	public void addVoli(Volo v) {
		this.voli.add(v);
	}
	
	public  void print(PrintStream ps2) {
		ps2.println(this.codice_fiscale);
		ps2.println(this.nome);
		ps2.println(this.cognome);
		}
		

	private String codice_fiscale;
	private String nome;
	private String cognome;
	private LinkedList<Volo> voli;

}
