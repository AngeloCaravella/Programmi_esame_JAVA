package it.unisannio.studenti.caravella.angelo.classes;
import java.util.*;

public class Provincia {
	
	
	
	/**
	 * @param nome_provincia
	 * @param info_comune
	 */
	public Provincia(String nome_provincia, LinkedList<Comune> info_comune) {
		this.nome_provincia = nome_provincia;
		this.info_comune = info_comune;
	}
	
	public static Provincia read(Scanner sc) {
		
		if(!sc.hasNextLine())return null;
		String nome= sc.nextLine();
		
		if(!sc.hasNextLine())return null;
		String label= sc.nextLine();
		
		String nome_c = null; 
		int num_m=0;
		int num_f= 0;
		LinkedList<Comune> info_comune=new LinkedList<Comune> ();
		do {
		if(!sc.hasNextLine())return null;
		nome_c= sc.nextLine();
		if(nome_c.equals("#"))break;
		
		if(!sc.hasNextLine())return null;
		label= sc.nextLine();
		
		num_m = Integer.parseInt(label);
		

		if(!sc.hasNextLine())return null;
		label= sc.nextLine();
		
		num_f = Integer.parseInt(label);
		
		Comune nn= new Comune ( nome_c, num_m, num_f);
		
		info_comune.add(nn);
		}
		while(nome_c!=null);
		

		return new Provincia(nome, info_comune);
	}
	
	
	/**
	 * @return the numero_cit_prov
	 */
	public int getNumero_cit_prov() {
		return numero_cit_prov;
	}


	/**
	 * @param numero_cit_prov the numero_cit_prov to set
	 */
	public void setNumero_cit_prov(int numero_cit_prov) {
		this.numero_cit_prov = numero_cit_prov;
	}



	@Override
	public String toString() {
		return "Provincia [nome_provincia=" + nome_provincia + ", info_comune=" + info_comune + "]";
	}

	/**
	 * @return the nome_provincia
	 */
	public String getNome_provincia() {
		return nome_provincia;
	}

	/**
	 * @return the info_comune
	 */
	public LinkedList<Comune> getInfo_comune() {
		return info_comune;
	}
	

	/**
	 * @return the regione_di_provenienza
	 */
	public Regione getRegione_di_provenienza() {
		return regione_di_provenienza;
	}

	/**
	 * @param regione_di_provenienza the regione_di_provenienza to set
	 */
	public void setRegione_di_provenienza(Regione regione_di_provenienza) {
		this.regione_di_provenienza = regione_di_provenienza;
	}

	
	
	/**
	 * @return the numero_cit_m
	 */
	public int getNumero_cit_m() {
		return numero_cit_m;
	}

	/**
	 * @return the numero_cit_f
	 */
	public int getNumero_cit_f() {
		return numero_cit_f;
	}

	/**
	 * @param numero_cit_m the numero_cit_m to set
	 */
	public void setNumero_cit_m(int numero_cit_m) {
		this.numero_cit_m = numero_cit_m;
	}

	/**
	 * @param numero_cit_f the numero_cit_f to set
	 */
	public void setNumero_cit_f(int numero_cit_f) {
		this.numero_cit_f = numero_cit_f;
	}



	private String nome_provincia;
	private LinkedList<Comune> info_comune;
	private Regione regione_di_provenienza;
	private int numero_cit_prov;
	private int numero_cit_m;
	private int numero_cit_f;	
}
