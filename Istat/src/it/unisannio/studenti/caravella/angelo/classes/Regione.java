package it.unisannio.studenti.caravella.angelo.classes;
import java.util.*;

public class Regione {

	/**
	 * @param nome
	 * @param locazione
	 * @param nomi_province
	 */
	public Regione(String nome, String locazione, LinkedList<String> nomi_province) {
		this.nome = nome;
		this.locazione = locazione;
		this.nomi_province = nomi_province;
	}
	
	public static Regione read(Scanner sc) {
		
		if(!sc.hasNextLine())return null;
		String n=sc.nextLine();
		
		if(!sc.hasNextLine())return null;
		String l=sc.nextLine();
		
		if(!sc.hasNextLine())return null;
		String label=sc.nextLine();
		
		LinkedList<String> nomi_province=new LinkedList<String>();
		
		if(!sc.hasNextLine())return null;
		label=sc.nextLine();
		nomi_province.add(label);
		while( label !="#" ) {
			
			label=sc.nextLine();
			if(label.equals("#"))break;
			nomi_province.add(label);
		}
		
		return new Regione(n, l, nomi_province);
	}
	
	
	
	@Override
	public String toString() {
		return "Regione [nome=" + nome + ", locazione=" + locazione + ", nomi_province=" + nomi_province + "]";
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the locazione
	 */
	public String getLocazione() {
		return locazione;
	}

	/**
	 * @return the nomi_province
	 */
	public LinkedList<String> getNomi_province() {
		return nomi_province;
	}



	private String nome;
	private String locazione;
	private LinkedList<String> nomi_province;
	
}
