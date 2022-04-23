package it.unisannio.studenti.caravella.angelo.testers;
import java.io.*;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.classes.Scuola;
public class TesterFiltri {

	public static void main( String []args) throws FileNotFoundException {
		
		Scanner sc1=new Scanner( new File("Esercitazioni.txt"));
		Scanner sc2= new Scanner ( new File( "Iscritti.txt"));
		
		Scuola scuola= new Scuola(sc1, sc2);
		//scuola.print();
		
		//scuola.CercaEsId("C1");
		//scuola.CercaIscritto( "M1");
		
		scuola.CercaEsdellIscritto("M2").printEs();
		
	}
}
