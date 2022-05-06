package it.unisannio.studenti.caravella.angelo.classes;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.testers.FlightAlreadyBookedException;
import it.unisannio.studenti.caravella.angelo.utils.ClientNotFoundException;
import it.unisannio.studenti.caravella.angelo.utils.Constants;
import it.unisannio.studenti.caravella.angelo.utils.FlightNotFoundException;
import it.unisannio.studenti.caravella.angelo.utils.FlightTester;
import it.unisannio.studenti.caravella.angelo.utils.FlightsTesterByDate;
import it.unisannio.studenti.caravella.angelo.utils.FlightsTesterByEndCity;
import it.unisannio.studenti.caravella.angelo.utils.FlightsTesterByStartCity;
import it.unisannio.studenti.caravella.angelo.utils.Tester;

public class Compagnia_Viaggi {

	/**
	 * 
	 * @param clienti
	 * @param voli
	 */
	public Compagnia_Viaggi(HashMap<String, Cliente> clienti, HashMap<String, Volo> voli) {
		this.clienti = clienti;
		this.voli = voli;
	}

	public Compagnia_Viaggi(Scanner sc1, Scanner sc2) {
		this.clienti = new HashMap<String, Cliente>();

		Cliente cli = Cliente.read(sc1);
		while (cli != null) {
			this.clienti.put(cli.getCodice_fiscale(), cli);
			cli = Cliente.read(sc1);
		}

		this.voli = new HashMap<String, Volo>();

		Volo voli = Volo.read(sc2);
		while (voli != null) {
			this.voli.put(voli.getIdentificativo(), voli);
			GetFlights(voli.getIdentificativo());
			voli = Volo.read(sc2);

		}

	}

	private void GetFlights(String id) {
		Volo v = this.voli.get(id);
		LinkedList<String> codici = v.getCodice_fisc_clienti();
		try {
			SearchClients(codici, v);
		} catch (ClientNotFoundException c) {
			System.err.println(" Il cliente non è stato trovato" + c.getStackTrace());
			Cliente cli = Cliente.read();
			if (cli != null)
				this.clienti.put(cli.getCodice_fiscale(), cli);
			cli.addVoli(v);
			v.addCliente(cli);
		}

	}

	private void SearchClients(LinkedList<String> codici, Volo voli) {
		for (String s : codici) {

			if (this.clienti.get(s) == null)
				throw new ClientNotFoundException("Cliente non trovato");
			else {

				Cliente c = this.clienti.get(s);
				c.addVoli(voli);
				voli.addCliente(c);
			}

		}

	}
////////////////////////////////////////////////////

	public void addClient(Cliente cli) {

		this.clienti.put(cli.getCodice_fiscale(), cli);
	}

	public void addFlight(Volo voli) {
		this.voli.put(voli.getIdentificativo(), voli);
		voli.setNumero_massimo_posti(voli.getNumero_massimo_posti());
		System.out.println("Il numero massimo di posti è: " + voli.getNumero_massimo_posti());
	}

	public void RemoveFlight(String id) {
		this.voli.remove(id);
	}
////////////////////////////////////////////////////

	public void NuovaPrenotazione(String id_c, String id_v) {
		Cliente cl = this.clienti.get(id_c);
		if (cl == null)
			throw new ClientNotFoundException("Cliente non trovato");

		Volo vl = this.voli.get(id_v);
		if (vl == null)
			throw new FlightNotFoundException("Volo non trovato");

		try {
			this.SearchFlight(cl.getVoli(), vl, id_v, id_c, cl);
		} catch (FlightNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	private void SearchFlight(LinkedList<Volo> cl, Volo vl, String id_v, String id_c, Cliente cc) {

		for (Volo v : cl) {

			if (v.getIdentificativo().equals(id_v))
				throw new FlightNotFoundException(
						"Esiste già una prenotazione per il cliente con il codice fiscale: " + id_c);

		}
		vl.addCliente(cc);
		cc.addVoli(vl);

		System.out.println("I posti disponibili prima della prenotazione sono: " + vl.getNumero_massimo_posti());
		vl.setNumero_massimo_posti(vl.getNumero_massimo_posti());

		System.out.println("I posti disponibili dopo la prenotazione sono: " + vl.getNumero_massimo_posti());

	}

////////////////////////////////////////////////////

	public Compagnia_Viaggi SearchFlight(String id_volo) {

		FlightTester ff = new FlightTester(id_volo);

		return this.FlightFilter(ff);
	}

	public Compagnia_Viaggi SearchFlightByDate(String d) throws ParseException {
		Date data= Constants.ddMMyyyy.parse(d);
		FlightsTesterByDate ff= new FlightsTesterByDate(data);
		
		return this.FlightFilter(ff);
	}
	public Compagnia_Viaggi SearchFlightByStartCity(String cit_p) {
		FlightsTesterByStartCity ff = new FlightsTesterByStartCity(cit_p);
		return this.FlightFilter(ff);
		}
	public Compagnia_Viaggi SearchFlightByEndCity(String cit_a) {
		FlightsTesterByEndCity ff = new FlightsTesterByEndCity(cit_a);
		return this.FlightFilter(ff);
		}
	public void SearchClient(String codice_fiscale) {

		Cliente cl = this.clienti.get(codice_fiscale);
		LinkedList<Volo> voli = cl.getVoli();
		for (Volo v : voli) {
			System.out.println(v.getIdentificativo());
		}
	}

	private Compagnia_Viaggi FlightFilter(Tester ff) {

		Set<String> chiavi = this.voli.keySet();
		HashMap<String, Volo> volifiltrati = new HashMap<String, Volo>();
		HashMap<String, Cliente> clientifiltrati = new HashMap<String, Cliente>();

		for (String s : chiavi) {

			if (ff.Verify(this.voli.get(s)))
				volifiltrati.put(s, this.voli.get(s));

		}
		clientifiltrati.putAll(this.clienti);
		return new Compagnia_Viaggi(clientifiltrati, volifiltrati);
	}

////////////////////////////////////////////////////

	public void PrintFlights() {

		this.voli.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + entry.getValue());
			System.out.println(" ");
		});
	}

	public void PrintClients() {

		this.clienti.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + entry.getValue());
			System.out.println(" ");
		});
	}

	public void PrintFilteredMaps(PrintStream ps1, PrintStream ps2) {

		Set<String> chiavi1 = this.clienti.keySet();

		for (String c : chiavi1) {

			Cliente cl = this.clienti.get(c);
			cl.print(ps1);
		}

		Set<String> chiavi2 = this.voli.keySet();

		for (String v : chiavi2) {
			Volo vl = this.voli.get(v);
			vl.print(ps2);
		}

	}

	private HashMap<String, Cliente> clienti;
	private HashMap<String, Volo> voli;

	
	

}
