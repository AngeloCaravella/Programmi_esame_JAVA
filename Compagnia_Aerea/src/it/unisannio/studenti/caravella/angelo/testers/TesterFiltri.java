package it.unisannio.studenti.caravella.angelo.testers;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.classes.Cliente;
import it.unisannio.studenti.caravella.angelo.classes.Compagnia_Viaggi;
import it.unisannio.studenti.caravella.angelo.classes.Volo;

public class TesterFiltri {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Scanner sc1 = new Scanner(new File("customers.data"));
		Scanner sc2 = new Scanner(new File("flights.data"));
		Scanner sc3 = new Scanner(System.in);
		Compagnia_Viaggi viaggi = new Compagnia_Viaggi(sc1, sc2);

		// - Inserimento di un nuovo cliente
		
		Cliente cli = Cliente.read();
		do {
			if (cli != null)
				viaggi.addClient(cli);
			cli = Cliente.read();
		} while (cli != null); 
		// - Inserimento di una nuovo volo

		Volo voli = Volo.read();
		do {
			if (voli != null)
				viaggi.addFlight(voli);
			voli = Volo.read();
		} while (voli != null);
		
		
		System.out.println("Si desidera inserire una nuova prenotazione?: ");
		String v = null;
		do {
			v = sc3.nextLine();
		} while (!v.equals("true") && !v.equals("false"));
		boolean verità = Boolean.parseBoolean(v);
		String id_c = null, id_v = null;

		if (verità) {
			System.out.println("Inserire l'id del cliente di cui si vuole effettuare la prenotazione: ");
			id_c = sc3.nextLine().strip();

			System.out.println("Inserire l'id del volo di cui si vuole effettuare la prenotazione: ");
			id_v = sc3.nextLine().strip();
		}
	

		viaggi.NuovaPrenotazione(id_c, id_v);

		// - Cancellazione di una prenotazione esistente
		viaggi.RemoveFlight( "V1");
	
		// - Visualizzazione della lista dei clienti prenotati ad un volo
		viaggi.SearchFlight("V2").PrintClients();

		// - Visualizzazione di tutte le prenotazioni di un dato cliente
		viaggi.SearchClient("CR1");
		// - Ricerca di tutti i voli in partenza dopo una certa data e con città di
		// partenza e di destinazione date
		viaggi.SearchFlightByDate("11-01-2001").SearchFlightByStartCity("New York").SearchFlightByEndCity("Boston").PrintFlights();
		PrintStream ps1 = new PrintStream(new File("customers.data"));

		PrintStream ps2 = new PrintStream(new File("flights.data"));
		viaggi.PrintFilteredMaps(ps1, ps2);
	}

}
