package it.unisannio.studenti.caravella.angelo.classes;
import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;

public class Cittadino {

	
	
	/**
	 * @param nome
	 * @param cognome
	 * @param data_di_nascita
	 * @param codice_fiscale
	 */
	public Cittadino(String nome, String cognome, Date data_di_nascita, String codice_fiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.data_di_nascita = data_di_nascita;
		this.codice_fiscale = codice_fiscale;
		this.redditi=new LinkedList<Reddito>();
	}
	public static Cittadino read(Scanner sc ) {
		if(!sc.hasNextLine())return null;
		String no= sc.nextLine();
		
		if(!sc.hasNextLine())return null;
		String co= sc.nextLine();
		
		if(!sc.hasNextLine())return null;
		String s= sc.nextLine();
		
		Date data_n=null;
		try {
			data_n = Constants.ddMMyyyy.parse(s);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		if(!sc.hasNextLine())return null;
		String co_fi= sc.nextLine().strip();
		
		
		return new Cittadino(no, co, data_n , co_fi);
	}
	
	
	
	@Override
	public String toString() {
		return "Cittadino [nome=" + nome + ", cognome=" + cognome + ", data_di_nascita=" + data_di_nascita
				+ ", codice_fiscale=" + codice_fiscale + "]";
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
	 * @return the data_di_nascita
	 */
	public Date getData_di_nascita() {
		return data_di_nascita;
	}
	/**
	 * @return the codice_fiscale
	 */
	public String getCodice_fiscale() {
		return codice_fiscale;
	}
	/**
	 * @return the redditi
	 */
	public LinkedList<Reddito> getRedditi() {
		return redditi;
	}

	public void addReddito(Reddito r) {
		this.redditi.add(r);
		
	}

	private String nome;
	private String cognome;
	private Date data_di_nascita;
	private String codice_fiscale;
	private LinkedList<Reddito> redditi;
	
}
