package it.unisannio.studenti.caravella.angelo.classes;
import java.util.*;
public class Magazzino {


	/**
	 * @param id_magazzino
	 * @param indirizzo
	 * @param città
	 * @param telefono
	 * @param prodotti
	 */
	public Magazzino(String id_magazzino, String indirizzo, String città, String telefono) {
		this.id_magazzino = id_magazzino;
		this.indirizzo = indirizzo;
		this.città = città;
		this.telefono = telefono;
		this.prodotti = new LinkedList<Prodotto>();
	}

	public static Magazzino read(Scanner sc) {

		if(!sc.hasNextLine())return null;
		String id_magazzino=sc.nextLine();
		if(!sc.hasNextLine())return null;
		String indirizzo=sc.nextLine();
		if(!sc.hasNextLine())return null;
		String città=sc.nextLine();
		if(!sc.hasNextLine())return null;
		String telefono=sc.nextLine();
	
		return new Magazzino(id_magazzino, indirizzo, città , telefono);
	}
	
	
	@Override
	public String toString() {
		return "Magazzino [id_magazzino=" + id_magazzino + ", indirizzo=" + indirizzo + ", città=" + città
				+ ", telefono=" + telefono + "]";
	}

	/**
	 * @return the id_magazzino
	 */
	public String getId_magazzino() {
		return id_magazzino;
	}

	/**
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @return the città
	 */
	public String getCittà() {
		return città;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}


	public void PrintProdotti() {
		for( Prodotto p: prodotti) {
			
			System.out.println( p.toString());
		}
	}
	
	
	/**
	 * @return the prodotti
	 */
	public LinkedList<Prodotto> getProdotti() {
		return prodotti;
	}

	/**
	 * @param id_magazzino the id_magazzino to set
	 */
	public void setId_magazzino(String id_magazzino) {
		this.id_magazzino = id_magazzino;
	}

	/**
	 * @param indirizzo the indirizzo to set
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * @param città the città to set
	 */
	public void setCittà(String città) {
		this.città = città;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @param prodotti the prodotti to set
	 */
	public void setProdotti(LinkedList<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
	
	public void addProdotto(Prodotto p) {
		
		this.prodotti.add(p);
	}


	private String id_magazzino;
	private String indirizzo;
	private String città;
	private String telefono;
	private LinkedList<Prodotto> prodotti;
}
