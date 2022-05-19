package it.unisannio.studenti.caravella.angelo.classes;
import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;
public class Reddito {

	
	/**
	 * @param codice_fiscale
	 * @param anno
	 * @param reddito
	 */
	public Reddito(String codice_fiscale, Date anno, double reddito) {
		this.codice_fiscale = codice_fiscale;
		this.anno = anno;
		this.reddito = reddito;
		this.ct=null;
	}
	
	public static Reddito read(Scanner sc ) {
		if(!sc.hasNextLine())return null;
		String cf= sc.nextLine();
		
		if(!sc.hasNextLine())return null;
		String d= sc.nextLine();
		
		Date anno=null;
		try {
			anno = Constants.yyyy.parse(d);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		if(!sc.hasNextLine())return null;
		String r= sc.nextLine();
		
		double reddito =Double.parseDouble(r);
		return new Reddito(cf , anno, reddito );
	}
	
	
	
	@Override
	public String toString() {
		return "Reddito [codice_fiscale=" + codice_fiscale + ", anno=" + anno + ", reddito=" + reddito + "]";
	}

	/**
	 * @param ct the ct to set
	 */
	public void setCt(Cittadino ct) {
		this.ct = ct;
	}

	/**
	 * @return the codice_fiscale
	 */
	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	/**
	 * @return the anno
	 */
	public Date getAnno() {
		return anno;
	}

	/**
	 * @return the reddito
	 */
	public double getReddito() {
		return reddito;
	}

	/**
	 * @return the ct
	 */
	public Cittadino getCt() {
		return ct;
	}



	/**
	 * @param reddito the reddito to set
	 */
	public void setReddito(double reddito) {
		this.reddito = reddito;
	}



	private String codice_fiscale;
	private Date anno;
	private double reddito;
	private Cittadino ct;
}
