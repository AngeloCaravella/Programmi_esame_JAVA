package it.unisannio.studenti.caravella.angelo.testers;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.classes.Contabilità;

public class Filtri_Tester {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc1= new Scanner (new File("province.dati"));
		Scanner sc2=new Scanner (new File("regioni.dati"));
		
		Contabilità cont=new Contabilità(sc1, sc2);
		//- data una provincia, calcolare il numero di persone residenti nella stessa, sia totale, sia distinto tra maschi e femmine
		
		cont.ContNum("Fracca").PrintInfoProvincia();
		
		System.out.println(" ");
		
		System.out.println("Il comune più alto di presidenti per la provincia scelta è: ");
		//- data una provincia, indicarne il comune con il numero più alto di residenti
		cont.FindBigger("Fracca");
		
		//- per ciascuna regione, calcolare il numero di persone residenti nella regione
		//, sia totale sia distinti tra maschi e femmine, 
		//ed indicare la regione con più popolazione
	
		System.out.println(" ");
		cont.FindBiggerCountry("Berzundi");
	}

}
