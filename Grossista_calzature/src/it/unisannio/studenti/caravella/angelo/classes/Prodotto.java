package it.unisannio.studenti.caravella.angelo.classes;

import java.util.Scanner;

public class Prodotto {




	/**
	 * @param codice_prodotto
	 * @param descrizione
	 * @param marca
	 * @param colore
	 * @param prezzo
	 */
	public Prodotto(String codice_prodotto, String descrizione, String marca, String colore, double prezzo) {
		this.codice_prodotto = codice_prodotto;
		this.descrizione = descrizione;
		this.marca = marca;
		this.colore = colore;
		this.prezzo = prezzo;
		this.magazzino=null;
	}

	public static Prodotto read(Scanner sc) {

		if(!sc.hasNextLine())return null;
		String codice_prodotto=sc.nextLine();
		if(!sc.hasNextLine())return null;
		String descrizione=sc.nextLine();
		if(!sc.hasNextLine())return null;
		String marca=sc.nextLine();
		if(!sc.hasNextLine())return null;
		String colore=sc.nextLine();
		if(!sc.hasNextLine())return null;
		String d=sc.nextLine();
		double prezzo= Double.parseDouble(d);
		return new Prodotto(codice_prodotto, descrizione, marca, colore, prezzo);
	}
	
	@Override
	public String toString() {
		return "Prodotto [codice_prodotto=" + codice_prodotto + ", descrizione=" + descrizione + ", marca=" + marca
				+ ", colore=" + colore + ", prezzo=" + prezzo + ", magazzino=" + magazzino + "]";
	}

	/**
	 * @return the codice_prodotto
	 */
	public String getCodice_prodotto() {
		return codice_prodotto;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @return the colore
	 */
	public String getColore() {
		return colore;
	}

	/**
	 * @return the prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	 * @return the magazzino
	 */
	public Magazzino getMagazzino() {
		return magazzino;
	}

	/**
	 * @param codice_prodotto the codice_prodotto to set
	 */
	public void setCodice_prodotto(String codice_prodotto) {
		this.codice_prodotto = codice_prodotto;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @param colore the colore to set
	 */
	public void setColore(String colore) {
		this.colore = colore;
	}

	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @param magazzino the magazzino to set
	 */
	public void setMagazzino(Magazzino magazzino) {
		this.magazzino = magazzino;
	}

	private String codice_prodotto;
	private String descrizione;
	private String marca;
	private String colore;
	private	double prezzo;
	private Magazzino magazzino;
}
