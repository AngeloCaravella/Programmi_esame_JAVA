package it.unisannio.studenti.caravella.angelo.classes;

import java.util.Scanner;

public class Stoccaggio {

	

	/**
	 * @param codice_magazzino
	 * @param codice_prodotto
	 * @param quantità
	 */
	public Stoccaggio(String codice_magazzino, String codice_prodotto, int quantità) {
		this.codice_magazzino = codice_magazzino;
		this.codice_prodotto = codice_prodotto;
		this.quantità = quantità;
	}

	public static Stoccaggio read(Scanner sc) {

		if(!sc.hasNextLine())return null;
		String id_magazzino=sc.nextLine();
		if(!sc.hasNextLine())return null;
		String codice_prodotto=sc.nextLine();
		if(!sc.hasNextLine())return null;
		String q=sc.nextLine();
		int quantità = Integer.parseInt(q);
		return new Stoccaggio(id_magazzino, codice_prodotto, quantità);
	}
	
	
	
	
	/**
	 * @return the codice_magazzino
	 */
	public String getCodice_magazzino() {
		return codice_magazzino;
	}

	/**
	 * @return the codice_prodotto
	 */
	public String getCodice_prodotto() {
		return codice_prodotto;
	}

	/**
	 * @return the quantità
	 */
	public int getQuantità() {
		return quantità;
	}

	/**
	 * @param codice_magazzino the codice_magazzino to set
	 */
	public void setCodice_magazzino(String codice_magazzino) {
		this.codice_magazzino = codice_magazzino;
	}

	/**
	 * @param codice_prodotto the codice_prodotto to set
	 */
	public void setCodice_prodotto(String codice_prodotto) {
		this.codice_prodotto = codice_prodotto;
	}

	/**
	 * @param quantità the quantità to set
	 */
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}




	private String codice_magazzino;
	private String codice_prodotto;
	private int quantità;
}
