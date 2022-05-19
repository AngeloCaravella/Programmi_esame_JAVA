package it.unisannio.studenti.caravella.angelo.testers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.Scanner;

import it.unisannio.studenti.caravella.angelo.classes.Esercitazione;
import it.unisannio.studenti.caravella.angelo.classes.Scuola;

public class RegistrazioneNuoveEsercitazioni {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Scanner sc1 = new Scanner(new File("Esercitazioni.txt"));
		Scanner sc2 = new Scanner(new File("Iscritti.txt"));

		Scuola scuola = new Scuola(sc1, sc2);
		Esercitazione es= Esercitazione.read();
		PrintStream ps1= new PrintStream( new File("Esercitazioni.txt" ));
		while(es!=null) {
			es.Print(ps1);
			es= Esercitazione.read();
		}
	}

}
