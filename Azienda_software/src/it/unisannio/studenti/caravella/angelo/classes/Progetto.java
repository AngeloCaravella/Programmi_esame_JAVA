package it.unisannio.studenti.caravella.angelo.classes;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;

public class Progetto {

	public Progetto(String id, String matricola_c, String descrizione, Date inizio, Date fine, double importo) {
		this.id = id;
		this.matricola_c = matricola_c;
		this.descrizione = descrizione;
		this.inizio = inizio;
		this.fine = fine;
		this.importo = importo;
		c = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMatricola_c() {
		return matricola_c;
	}

	public void setMatricola_c(String matricola_c) {
		this.matricola_c = matricola_c;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getInizio() {
		return inizio;
	}

	public Date getFine() {
		return fine;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	@Override
	public String toString() {
		return "Progetto [id=" + id + ", matricola_c=" + matricola_c + ", descrizione=" + descrizione + ", inizio="
				+ inizio + ", fine=" + fine + ", importo=" + importo + "]";
	}

	public Capo getC() {
		return c;
	}

	public void setC(Capo c) {
		this.c = c;
	}

	public static Progetto read() {
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci l'id del progetto ");
		String id = input.nextLine();
		if (id.equals(""))
			return null;

		System.out.println("Inserisci la matricola ");
		String m = input.nextLine();
		if (m.equals(""))
			return null;

		System.out.println("Inserisci la descrizione ");
		String de = input.nextLine();
		if (de.equals(""))
			return null;

		System.out.println("Inserisci la data di inizio: ");
		String di = input.nextLine();
		if (di.equals(""))
			return null;
		Date datai = null;
		try {
			datai = Constants.ddMMyyyy.parse(di);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("Inserisci la data di fine: ");
		String df = input.nextLine();
		if (df.equals(""))
			return null;
		Date dataf = null;
		try {
			dataf = Constants.ddMMyyyy.parse(df);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		System.out.println("Inserisci l'importo ");
		String imp = input.nextLine();
		double impo = Double.parseDouble(imp);

		return new Progetto(id, m, de, datai, dataf, impo);
	}

	public static Progetto read(Scanner input) {

		if (!input.hasNextLine())
			return null;
		String id = input.nextLine();

		if (!input.hasNextLine())
			return null;
		String m = input.nextLine();

		if (!input.hasNextLine())
			return null;
		String de = input.nextLine();

		if (!input.hasNextLine())
			return null;
		String di = input.nextLine();

		Date datai = null;
		try {
			datai = Constants.ddMMyyyy.parse(di);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (!input.hasNextLine())
			return null;
		String df = input.nextLine();

		Date dataf = null;
		try {
			dataf = Constants.ddMMyyyy.parse(df);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		if (!input.hasNextLine())
			return null;
		String imp = input.nextLine();
		double impo = Double.parseDouble(imp);

		return new Progetto(id, m, de, datai, dataf, impo);
	}

	public void print(PrintStream ps) {

		ps.println(this.id);
		ps.println(this.matricola_c);
		ps.println(this.descrizione);
		ps.println(this.inizio);
		ps.println(this.fine);
		ps.println(this.importo);

	}

	public void print() {

		System.out.println(this.id);
		System.out.println(this.matricola_c);
		System.out.println(this.descrizione);
		System.out.println(this.inizio);
		System.out.println(this.fine);
		System.out.println(this.importo);
	}

	private String id;
	private String matricola_c;
	private String descrizione;
	private Date inizio;
	private Date fine;
	private double importo;
	private Capo c;
}
