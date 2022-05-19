package it.unisannio.studenti.caravella.angelo.classes;

import java.util.*;

public class Tavolo {

	/**
	 * @param id
	 * @param ordini
	 */
	public Tavolo(String id, int numero_c) {
		this.id = id;
		this.numero_c = numero_c;
		this.ordini = new LinkedList<Ordine>();
	}

	public void AddOrdine(Ordine o) {
		this.ordini.add(o);
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the numero_c
	 */
	public int getNumero_c() {
		return numero_c;
	}

	/**
	 * @return the ordini
	 */
	public LinkedList<Ordine> getOrdini() {
		return ordini;
	}

	

	public double CalcolaCosto(LinkedList<Ordine> ordini) {
		double costo = 0;
		for (Ordine o : ordini) {
			costo = costo + o.getPrezzo();
		}
		return costo;
	}

	private String id;
	private int numero_c;
	private LinkedList<Ordine> ordini;

}
