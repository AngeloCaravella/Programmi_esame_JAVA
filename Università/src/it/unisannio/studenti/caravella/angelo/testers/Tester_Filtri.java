package it.unisannio.studenti.caravella.angelo.testers;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.classes.Segreteria;

import java.io.*;
import java.text.ParseException;

public class Tester_Filtri {
	
	public static void main( String [] args) throws FileNotFoundException, ParseException {
		
		Scanner sc1= new Scanner( new File( "docenti.dati"));
		Scanner sc2= new Scanner( new File( "corsi.dati"));
	
		Segreteria se= new Segreteria(sc1, sc2);
		
		//se.ElencoCorsiErogati("C1");
		//se.ElencoCorsiErogati("Giuseppe","Belluni").PrintDocenti();
		se.InformazioniDocente("DIN21");
	}
}
