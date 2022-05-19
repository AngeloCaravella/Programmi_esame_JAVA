package it.unisannio.studenti.caravella.angelo.classes;

import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;

public class Vino extends Ordine {

	public Vino(String nome, String tipo, double prezzo, Date annata) {
		super(nome, tipo, prezzo);
		this.annata = annata;

	}

	public static Vino read(Scanner sc) throws ParseException {
		if (!sc.hasNextLine())
			return null;
		String nome = sc.nextLine().strip();

		if (!sc.hasNextLine())
			return null;
		String tipo = sc.nextLine();

		if (!sc.hasNextLine())
			return null;
		String p = sc.nextLine();

		double prezzo = Double.parseDouble(p);

		if (!sc.hasNextLine())
			return null;
		String a = sc.nextLine();

		Date annata = null;
		try {
			annata = Constants.yyyy.parse(a);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			a = sc.nextLine();
			annata = Constants.yyyy.parse(a);
		}

		return new Vino(nome, tipo, prezzo, annata);
	}

	/**
	 * @return the annata
	 */
	public Date getAnnata() {
		return annata;
	}

	private Date annata;

}
