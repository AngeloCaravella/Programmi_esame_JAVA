package it.unisannio.studenti.caravella.angelo.classes;
import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;

public class Corso {

	/**
	 * @param c_f
	 * @param cod_co
	 * @param nom_co
	 * @param co_la
	 * @param de
	 */
	public Corso(String c_f, String cod_co, String nom_co, String co_la, String de) {
		this.c_f = c_f;
		this.cod_co = cod_co;
		this.nom_co = nom_co;
		this.co_la = co_la;
		this.de = de;
		this.d=null;
	}
	public static Corso read(Scanner sc) throws ParseException {
		if(!sc.hasNextLine())return null;
		String c_f= sc.nextLine();
		
		if(!sc.hasNextLine())return null;
		String cod_co= sc.nextLine();
		
		if(!sc.hasNextLine())return null;
		String no= sc.nextLine();
		
		if(!sc.hasNextLine())return null;
		String co_la= sc.nextLine();

		if(!sc.hasNextLine())return null;
		String de= sc.nextLine();
		
	
		return new Corso(c_f, cod_co,no, co_la ,de);
	}
	
	
	@Override
	public String toString() {
		return "Corso [c_f=" + c_f + ", cod_co=" + cod_co + ", nom_co=" + nom_co + ", co_la=" + co_la + ", de=" + de
				+ "]";
	}

	
	/**
	 * @return the c_f
	 */
	public String getC_f() {
		return c_f;
	}
	/**
	 * @return the cod_co
	 */
	public String getCod_co() {
		return cod_co;
	}
	/**
	 * @return the nom_co
	 */
	public String getNom_co() {
		return nom_co;
	}
	/**
	 * @return the co_la
	 */
	public String getCo_la() {
		return co_la;
	}
	/**
	 * @return the de
	 */
	public String getDe() {
		return de;
	}
	/**
	 * @return the d
	 */
	public Docente getD() {
		return d;
	}
	/**
	 * @param d the d to set
	 */
	public void setD(Docente d) {
		this.d = d;
	}


	private String c_f;
	private String cod_co;
	private String nom_co;
	private String co_la;
	private String de;
	private Docente d;
}
