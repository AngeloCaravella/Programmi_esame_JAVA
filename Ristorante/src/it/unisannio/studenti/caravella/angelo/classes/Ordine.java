package it.unisannio.studenti.caravella.angelo.classes;

import java.util.LinkedList;

public abstract class Ordine {

	/**
	 * @param nome
	 * @param tipo
	 * @param prezzo
	 */
	public Ordine(String nome, String tipo, double prezzo) {
		this.nome = nome;
		this.tipo = tipo;
		this.prezzo = prezzo;
		this.tavoli = new LinkedList<Tavolo>();
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @return the prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}

	@Override
	public String toString() {
		return "Ordine [nome=" + nome + ", tipo=" + tipo + ", prezzo=" + prezzo + "]";
	}

	public void addTavoli(Tavolo t) {
		this.tavoli.add(t);
		
	}
	
	
	private String nome;
	private String tipo;
	private double prezzo;
	private LinkedList<Tavolo> tavoli;
}
