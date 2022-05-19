package it.unisannio.studenti.caravella.angelo.classes;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;
import it.unisannio.studenti.caravella.angelo.utils.ItemNotFoundException;
import it.unisannio.studenti.caravella.angelo.utils.TavoloNotFoundException;

public class Ristorante_Storico_ordinazioni {

	public Ristorante_Storico_ordinazioni(Scanner sc1) throws ParseException {
		String label = sc1.nextLine();
		this.ordini = new HashMap<String, Ordine>();
		do {
			if (label.equals("Piatto")) {
				Ordine ord = Piatto.read(sc1);
				this.ordini.put(ord.getNome(), ord);
				label = sc1.nextLine();
				if (label.equals(""))
					break;

			} else if (label.equals("Vino")) {
				Ordine ord = Vino.read(sc1);
				this.ordini.put(ord.getNome(), ord);
				label = sc1.nextLine();
				if (label.equals(""))
					break;
			}

		} while (label != null);
	}

	public void CreazioneGruppoCommensali(String id_t, int i) {
		this.tavoli = new HashMap<String, Tavolo>();
		Tavolo t = new Tavolo(id_t, i);
		this.tavoli.put(t.getId(), t);
	}

	public void OrdinaPiattoPerTavolo(String id_t, String nome_piatto) {
		Tavolo t = this.tavoli.get(id_t);
		if (t == null)
			throw new TavoloNotFoundException("Il tavolo con questo id: " + id_t + "non esiste ");
		Ordine o =  this.ordini.get(nome_piatto.strip());

		if (o == null)
			throw new ItemNotFoundException("Il piatto con questo nome: " + nome_piatto + "non esiste ");

		o.addTavoli(t);
		t.AddOrdine(o);

	}

	public void OrdinaVinoPerTavolo(String id_t, String nome_vino) {
		Tavolo t = this.tavoli.get(id_t);
		if (t == null)
			throw new TavoloNotFoundException("Il tavolo con questo id: " + id_t + "non esiste ");
		Ordine o = this.ordini.get(nome_vino);

		if (o == null)
			throw new ItemNotFoundException("Il piatto con questo nome: " + nome_vino + "non esiste ");

		o.addTavoli(t);
		t.AddOrdine(o);

	}

	public void StampaRicevuta(String id_t, PrintStream ps) {
		Tavolo t = this.tavoli.get(id_t);
		if (t == null)
			throw new TavoloNotFoundException("Il tavolo con questo id: " + id_t + "non esiste ");

		
		LinkedList<Ordine> ord = t.getOrdini();

		//LA DATA E' QUELLA ODIERNA
		Date data = new Date();
		ps.println(Constants.ddMMyyyy.format(data));
		
		Vino v = null;
		for (Ordine o : ord) {

			ps.println(o.getNome());
			ps.println(o.getPrezzo());
			ps.println(o.getTipo());
			if (o instanceof Vino) {
				v = (Vino) o;
				ps.println(Constants.yyyy.format(v.getAnnata()));
			}
		}
		double costo =t.CalcolaCosto(ord);
		System.out.println("Il costo totale per il tavolo con l'id: "+ id_t+ " è: "+ costo );
		ps.println(costo);
		ps.println("#");
	}

	public void VisualizzaRicevutaDellaData(Date data,Scanner sc)  {
	
		this.ricevute = new HashSet<Ricevuta>();
		
		Ricevuta ricevuta = Ricevuta.read(sc);
		if (ricevuta.getData().equals(data))
			this.ricevute.add(ricevuta);

		this.PrintRicevute();
	}

	public void PrintAll() {
		this.ordini.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + entry.getValue());
		});

		this.tavoli.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + entry.getValue());
		});

	}

	public void PrintRicevute() {

		for (Ricevuta r : this.ricevute) {
			System.out.println(Constants.ddMMyyyy.format(r.getData()));
			LinkedList<String> rr = r.getInformazioni();
			for (String s : rr) {
				System.out.println(s);
			}
		}
	}

	private HashMap<String, Tavolo> tavoli;
	private HashMap<String, Ordine> ordini;
	private HashSet<Ricevuta> ricevute;

}
