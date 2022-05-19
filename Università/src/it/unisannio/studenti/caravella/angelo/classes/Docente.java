package it.unisannio.studenti.caravella.angelo.classes;

import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;

public class Docente {

	/**
	 * @param c_f
	 * @param nom
	 * @param cog
	 * @param data_n
	 * @param fascia
	 * @param raggruppamento
	 */
	public Docente(String c_f, String nom, String cog, Date data_n, String fascia, String raggruppamento) {
		this.c_f = c_f;
		this.nom = nom;
		this.cog = cog;
		this.data_n = data_n;
		this.fascia = fascia;
		this.raggruppamento = raggruppamento;
		this.corsi=new LinkedList<Corso>();
	}
	public static Docente read(Scanner sc) throws ParseException {
		if(!sc.hasNextLine())return null;
		String c_f= sc.nextLine();
		
		if(!sc.hasNextLine())return null;
		String no= sc.nextLine();
		
		if(!sc.hasNextLine())return null;
		String co= sc.nextLine();
		
		if(!sc.hasNextLine())return null;
		String d= sc.nextLine();
		
		Date data=null;
		try {
			data = Constants.ddMMyyyy.parse(d);
		} catch (ParseException e) {
			
			System.err.println("Reinserisci la data: ");
			d= sc.nextLine();
			data = Constants.ddMMyyyy.parse(d);
		}
		
		if(!sc.hasNextLine())return null;
		String fascia= sc.nextLine();
		
		
		if(!sc.hasNextLine())return null;
		String r= sc.nextLine();
		
		
		return new Docente(c_f, no, co, data, fascia , r);
	}
	@Override
	public String toString() {
		return "Docente [c_f=" + c_f + ", nom=" + nom + ", cog=" + cog + ", data_n=" + data_n + ", fascia=" + fascia
				+ ", raggruppamento=" + raggruppamento + "]";
	}
	
	
	/**
	 * @return the c_f
	 */
	public String getC_f() {
		return c_f;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the cog
	 */
	public String getCog() {
		return cog;
	}
	/**
	 * @return the data_n
	 */
	public Date getData_n() {
		return data_n;
	}
	/**
	 * @return the fascia
	 */
	public String getFascia() {
		return fascia;
	}
	/**
	 * @return the raggruppamento
	 */
	public String getRaggruppamento() {
		return raggruppamento;
	}
	/**
	 * @return the corsi
	 */
	public LinkedList<Corso> getCorsi() {
		return corsi;
	}
	public void AddCorsi( Corso c) {
		this.corsi.add(c);
	}
	
	private String c_f;
	private String nom;
	private String cog;
	private Date data_n;
	private String fascia;
	private String raggruppamento;
	private LinkedList<Corso> corsi;
}
