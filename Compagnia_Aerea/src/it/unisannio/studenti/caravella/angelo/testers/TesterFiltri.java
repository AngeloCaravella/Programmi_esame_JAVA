package it.unisannio.studenti.caravella.angelo.testers;
import java.io.*;
import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.classes.Cliente;
import it.unisannio.studenti.caravella.angelo.classes.Compagnia_Viaggi;
import it.unisannio.studenti.caravella.angelo.classes.Volo;


public class TesterFiltri {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Scanner sc1=new Scanner (new File("customers.data"));
		Scanner sc2=new Scanner (new File("flights.data"));
		Compagnia_Viaggi viaggi= new Compagnia_Viaggi(sc1, sc2);
		
		//- Inserimento di un nuovo cliente
		
		Cliente cli= Cliente.read();
		if(cli!= null)
		viaggi.addClient(cli); 
		
		//- Inserimento di una nuova prenotazione
		
		Volo voli= Volo.read();
		if( voli!=null)
		viaggi.addFlight(voli);
		
		
		//- Cancellazione di una prenotazione esistente
		viaggi.RemoveFlight( "V1");
		 
		//- Visualizzazione della lista dei clienti prenotati ad un volo
		viaggi.SearchFlight("V2").PrintClients();
		
		//- Visualizzazione di tutte le prenotazioni di un dato cliente
		viaggi.SearchClient("CR1");
		//- Ricerca di tutti i voli in partenza dopo una certa data e con città di partenza e di destinazione date
		//viaggi.SearchFlight("11-01-2001", "New York", "Boston").PrintFlights();;
		
		PrintStream ps1= new PrintStream( new File("customers.data"));

		PrintStream ps2= new PrintStream( new File("flights.data"));
		viaggi.PrintFilteredMaps(ps1, ps2);
	}

}
