package it.unisannio.studenti.caravella.angelo.testers;

import java.io.*;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.classes.Scuola;

public class TesterFiltri {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc1 = new Scanner(new File("Esercitazioni.txt"));
		Scanner sc2 = new Scanner(new File("Iscritti.txt"));

		Scuola scuola = new Scuola(sc1, sc2);
		
		
		System.out.println( "Recupero informazioni di un' esercitazione fornendo l'id: ");
		scuola.CercaEsId("C1");
		
		System.out.println(" ");
		
		System.out.println( "Recupero informazioni di un iscritto fornendo la matricola: ");
		scuola.CercaIscritto( "M1");

		
		System.out.println( " ");
		
		System.out.println( "Recupero esercitazioni dell'iscritto: ");
		scuola.CercaEsdellIscritto("M2").printEs();
		 
		// Ricercare gli iscritti che hanno partecipato al numero
		//più alto di esercitazioni
		
		scuola.FiltraIscrittoConMaggioriEsercitazioni().printIs();
		//Ricercare e visualizzare gli iscritti che hanno usato 
		// una data attrezzatura in un dato campo
		
		scuola.CercaAttrezzatura("Spada").CercaCampo("Campo delle margherite").printIs();
	}
}
