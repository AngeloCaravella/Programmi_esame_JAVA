package it.unisannio.studenti.caravella.angelo.testers;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import it.unisannio.studenti.caravella.angelo.classes.Capo;

public class TesterCapi {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		// TODO Auto-generated method stub
		Scanner sc1= new Scanner (new File("Capi.dati"));
		Capo c= Capo.read(sc1);
		while(c!= null) {
			c= Capo.read(sc1);
		
		}
	}

}
