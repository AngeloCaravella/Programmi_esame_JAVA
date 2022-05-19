package it.unisannio.studenti.caravella.angelo.testers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.Scanner;

import it.unisannio.studenti.caravella.angelo.classes.Iscritto;
import it.unisannio.studenti.caravella.angelo.classes.Scuola;

public class RegistrazioneNuoviIscritti {
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Scanner sc1 = new Scanner(new File("Esercitazioni.txt"));
		Scanner sc2 = new Scanner(new File("Iscritti.txt"));

		Scuola scuola = new Scuola(sc1, sc2);
		Iscritto is= Iscritto.read();
		PrintStream ps1= new PrintStream( new File("Iscritti.txt" ));
		while( is!=null) {
			is.Print(ps1);
			is= Iscritto.read();
		}
	}

}
