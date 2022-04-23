package it.unisannio.studenti.caravella.angelo.classes;

import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;

public class Esercitazione {

	/**
	 * @param codice_id
	 * @param denominazione
	 * @param data_i
	 * @param data_f
	 * @param nome_campo_m
	 * @param attrezzature
	 **/
	public Esercitazione(String codice_id, String denominazione, Date data_i, Date data_f, String nome_campo_m,
			LinkedList<String> attrezzature) {
		this.codice_id = codice_id;
		this.denominazione = denominazione;
		this.data_i = data_i;
		this.data_f = data_f;
		this.nome_campo_m = nome_campo_m;
		this.attrezzature = attrezzature;
		this.i = null;
	}

	public static Esercitazione read(Scanner sc) {
		if (!sc.hasNextLine())
			return null;
		String c = sc.nextLine();
		if (!sc.hasNextLine())
			return null;
		String de = sc.nextLine();
		if (!sc.hasNextLine())
			return null;
		String dai = sc.nextLine();
		Date data_i = null;
		try {
			data_i = Constants.ddMMyyyy.parse(dai);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (!sc.hasNextLine())
			return null;
		String daf = sc.nextLine();

		Date data_f = null;
		try {
			data_f = Constants.ddMMyyyy.parse(daf);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (!sc.hasNextLine())
			return null;
		String nome_c = sc.nextLine();

		String at = null;
		LinkedList<String> attre = new LinkedList<String>();
		do {
			if (!sc.hasNextLine())
				return null;
			at = sc.nextLine();
			if (!at.equals("#"))
				attre.add(at);
		} while (!at.equals("#"));

		return new Esercitazione(c, de, data_i, data_f, nome_c, attre);
	}
	
	
	
	@Override
	public String toString() {
		return "Esercitazione [codice_id=" + codice_id + ", denominazione=" + denominazione + ", data_i=" + data_i
				+ ", data_f=" + data_f + ", nome_campo_m=" + nome_campo_m + ", attrezzature=" + attrezzature + ", i="
				+ i + "]";
	}

	/**
	 * @return the codice_id
	 */
	public String getCodice_id() {
		return codice_id;
	}

	/**
	 * @return the denominazione
	 */
	public String getDenominazione() {
		return denominazione;
	}

	/**
	 * @return the data_i
	 */
	public Date getData_i() {
		return data_i;
	}

	/**
	 * @return the data_f
	 */
	public Date getData_f() {
		return data_f;
	}

	/**
	 * @return the nome_campo_m
	 */
	public String getNome_campo_m() {
		return nome_campo_m;
	}

	/**
	 * @return the attrezzature
	 */
	public LinkedList<String> getAttrezzature() {
		return attrezzature;
	}

	/**
	 * @return the i
	 */
	public Iscritto getI() {
		return i;
	}

	


	/**
	 * @param i the i to set
	 */
	public void setI(Iscritto i) {
		this.i = i;
	}




	private String codice_id;
	private String denominazione;
	private Date data_i;
	private Date data_f;
	private String nome_campo_m;
	private LinkedList<String> attrezzature;
	private Iscritto i;
}
