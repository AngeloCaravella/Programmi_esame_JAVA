package it.unisannio.studenti.caravella.angelo.classes;

import java.util.*;

public class Comune {

	
	
	
	/**
	 * @param nome_comune
	 * @param numero_maschi
	 * @param numero_femmine
	 */
	public Comune(String nome_comune, int numero_maschi, int numero_femmine) {
		this.nome_comune = nome_comune;
		this.numero_maschi = numero_maschi;
		this.numero_femmine = numero_femmine;
		this.provincia=null;
	}
	
	
	@Override
	public String toString() {
		return "Comune [nome_comune=" + nome_comune + ", numero_maschi=" + numero_maschi + ", numero_femmine="
				+ numero_femmine + "]";
	}


	/**
	 * @return the nome_comune
	 */
	public String getNome_comune() {
		return nome_comune;
	}
	/**
	 * @return the numero_maschi
	 */
	public int getNumero_maschi() {
		return numero_maschi;
	}
	/**
	 * @return the numero_femmine
	 */
	public int getNumero_femmine() {
		return numero_femmine;
	}


	private String nome_comune;
	private int numero_maschi;
	private int numero_femmine;
	private Provincia provincia;
}
