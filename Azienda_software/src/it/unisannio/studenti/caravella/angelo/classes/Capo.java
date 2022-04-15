package it.unisannio.studenti.caravella.angelo.classes;

import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;

public class Capo implements Comparable<Capo>{

	public Capo(String matricola, String nome, String cognome, Date data_di_nascita) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.data_di_nascita = data_di_nascita;
		this.progettiDiretti = new LinkedList<Progetto> ();
	}

	public Capo() {
		// TODO Auto-generated constructor stub
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getData_di_nascita() {
		return data_di_nascita;
	}

	public void setData_di_nascita(Date data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}
	
	public LinkedList<Progetto> getProgettiDiretti() {
		return this.progettiDiretti;
	}

	
	public void addProgettoDiretto(Progetto p) {
	
		this.progettiDiretti.add(p);
	}
	@Override
	public String toString() {
		return "Capo [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", data_di_nascita="
				+ data_di_nascita + "]";
	}

	public static Capo read() throws ParseException {
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci la matricola: ");
		String m = input.nextLine();
		if (m.equals(""))
			return null;

		System.out.println("Inserisci il nome: ");
		String n = input.nextLine();
		if (n.equals(""))
			return null;

		System.out.println("Inserisci il cognome: ");
		String c = input.nextLine();
		if (c.equals(""))
			return null;

		System.out.println("Inserisci la data: ");
		String d = input.nextLine();
		if (d.equals(""))
			return null;
		Date data = Constants.ddMMyyyy.parse(d);
		return new Capo(m, n, c, data);
	}

	public static Capo read(Scanner input) throws ParseException {

		if (!input.hasNextLine())
			return null;
		String m = input.nextLine();

		if (!input.hasNextLine())
			return null;
		String n = input.nextLine();

		if (!input.hasNextLine())
			return null;
		String c = input.nextLine();

		if (!input.hasNextLine())
			return null;
		String d = input.nextLine();
		if (d.equals(""))
			return null;
		Date data = Constants.ddMMyyyy.parse(d);

		return new Capo(m, n, c, data);
	}
	@Override
	public int compareTo(Capo o) {
		if( o.getCognome().compareTo(cognome)> 0 )
			return 1;
		else if(o.getCognome().compareTo(cognome)<  0  )
			return -1;
		else 
		return o.getNome().compareTo(nome);
		
	}

	

	private String matricola;
	private String nome;
	private String cognome;
	private Date data_di_nascita;
	
	private LinkedList<Progetto> progettiDiretti;

	
	
	
}
