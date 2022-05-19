package it.unisannio.studenti.caravella.angelo.testers;

import java.io.*;
import java.text.ParseException;
import java.util.*;
import it.unisannio.studenti.caravella.angelo.classes.Ristorante_Storico_ordinazioni;
import it.unisannio.studenti.caravella.angelo.utils.Constants;

public class Filtri_tester {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Scanner sc1 = new Scanner(new File("menu.dati"));
		Ristorante_Storico_ordinazioni rist = new Ristorante_Storico_ordinazioni(sc1);
		/*
		 * R1: Creazione di un nuovo tavolo di commensali. Il programma deve consentire
		 * la creazione di un nuovo gruppo di commensali, specificando il tavolo (un
		 * identificativo alfanumerico) a cui sono seduti ed il numero di commensali.
		 * 
		 */

		rist.CreazioneGruppoCommensali("I123", 12);
		/*
		 * R2: Ordina piatto. Tale funzione consente di aggiungere un piatto alle
		 * ordinazioni di un dato tavolo. Il programma verifica che il piatto che si
		 * intende aggiungere sia presente nel menu.
		 */

		rist.OrdinaPiattoPerTavolo("I123", "spaghetti allo scoglio");

		/*
		 * R3: Ordina vino. Tale funzione consente di aggiungere una bottiglia di vino
		 * alle ordinazioni di un dato tavolo. Il programma verifica che il piatto che
		 * si intende aggiungere sia presente nel menu.
		 * 
		 */
		rist.OrdinaVinoPerTavolo("I123", "Aglianico");
		/*
		 * R4: Calcola conto tavolo, che a partire dall’identificativo del tavolo stampa
		 * la ricevuta, con la data, l’elenco delle ordinazioni, la quantità, il
		 * relativo costo ed il totale.
		 * 
		 */
		PrintStream ps = new PrintStream(new File("ricevuta.txt"));
		rist.StampaRicevuta("I123", ps);

		/*
		 * R5: Gestione dello storico. Tutte le ricevute emesse devono essere
		 * memorizzate in un file. Il programma deve essere in grado di recuperare e
		 * visualizzare tutte le ricevute emesse in una certa data.
		 */
		Date data_da_ricercare = Constants.ddMMyyyy.parse("9-05-2022");
		Scanner sc = new Scanner(new File("ricevuta.txt"));
		System.out.println(" ");
		System.out.println( "Di seguito la ricevuta: ");
		rist.VisualizzaRicevutaDellaData(data_da_ricercare, sc);

	}

}
