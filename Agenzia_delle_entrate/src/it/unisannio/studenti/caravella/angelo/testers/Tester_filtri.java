package it.unisannio.studenti.caravella.angelo.testers;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.classes.Agenzia;

import java.text.*;
import java.io.*;

public class Tester_filtri {
	public static void main( String []args) throws FileNotFoundException, ParseException {
		Scanner sc1= new Scanner(new File("anagrafica.txt"));
		Scanner sc2= new Scanner(new File("redditi.txt"));
		
		Agenzia ag=new Agenzia(sc1, sc2); 
		
		ag.SearchReddito("Pasquale", "Rossi", "2008").PrintAll();;
	}
}
