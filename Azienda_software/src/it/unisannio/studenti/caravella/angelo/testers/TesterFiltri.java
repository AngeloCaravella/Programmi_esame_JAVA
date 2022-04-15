package it.unisannio.studenti.caravella.angelo.testers;

import java.util.*;

import it.unisannio.studenti.caravella.angelo.classes.Azienda;
import it.unisannio.studenti.caravella.angelo.classes.Capo;
import it.unisannio.studenti.caravella.angelo.classes.Progetto;

import java.io.*;
import java.text.ParseException;

public class TesterFiltri {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner(new File("Capi.dati"));
		Scanner sc2 = new Scanner(new File("Progetti.dati"));
		Azienda an = new Azienda(sc1, sc2);
		
		// PRIMA RICHIESTA
		System.out.println( "PRIMA RICHIESTA");
		Progetto progetto= an.searchProgettiById("PRG-44");
		System.out.println(progetto.getC());
		
		// SECONDA RICHIESTA
		System.out.println( "SECONDA RICHIESTA");
		HashMap<String, Capo> capiprogettof= an.CercaProgettiDelCapoN("Gennaro");
		
		capiprogettof= an.CercaProgettiDelCapoC(capiprogettof,"Esposito");
		
		an.PrintProg(capiprogettof);

		//TERZA RICHIESTA
		System.out.println( "TERZA RICHIESTA");
		Azienda azienda= an.FiltraProgettiDellImportoMax(11212);
		azienda= azienda.FiltraProgettiDellImportoMin(10056000);
		azienda.print();
		
		
		// ELENCO CAPI PROGETTO ORDINATI PER COGNOME E PER NOME
		an.CapiOrdinamento();
		an.StampaCapiOrdinati();
		

	}

}
