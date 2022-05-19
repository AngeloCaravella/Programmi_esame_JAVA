package it.unisannio.studenti.caravella.angelo.classes;

import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;

public class Piatto extends Ordine {

	public Piatto(String nome, String tipo, double prezzo) {
		super(nome, tipo, prezzo);

	}

	public static Piatto read(Scanner sc) throws ParseException {
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

		return new Piatto(nome, tipo, prezzo);
	}
}
