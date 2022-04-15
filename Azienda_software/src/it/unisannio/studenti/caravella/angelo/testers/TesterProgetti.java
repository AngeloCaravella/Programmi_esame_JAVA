package it.unisannio.studenti.caravella.angelo.testers;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import it.unisannio.studenti.caravella.angelo.classes.Progetto;

public class TesterProgetti {
	
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		
		Scanner sc2= new Scanner (new File("Progetti.dati"));
		Progetto p= Progetto.read(sc2);
		while(p!= null) {
			 p= Progetto.read(sc2);
		
		}
		
		
		
	}
}
