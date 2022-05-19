package it.unisannio.studenti.caravella.angelo.classes;

import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;

public class Ricevuta {

	/**
	 * @param data
	 * @param informazioni
	 */
	public Ricevuta(Date data, LinkedList<String> informazioni) {
		this.data = data;
		this.informazioni = informazioni;
	}
	public static Ricevuta read(Scanner sc) {
		if (!sc.hasNextLine())
			return null;
		String d = sc.nextLine();
		Date data = null;
		try {
			data = Constants.ddMMyyyy.parse(d);
		} catch (ParseException e) {
			System.err.println("Generata un'eccezione di tipo ParseException per la data: " + d);

		}

		LinkedList<String> info = new LinkedList<String>();
		String label = null;
		do {
			if (!sc.hasNextLine())
				return null;
			label = sc.nextLine();
			if (!label.equals("#"))
				info.add(label);

		} while (!label.equals("#"));

		return new Ricevuta(data, info);

	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @return the informazioni
	 */
	public LinkedList<String> getInformazioni() {
		return informazioni;
	}

	private Date data;
	private LinkedList<String> informazioni;
}
