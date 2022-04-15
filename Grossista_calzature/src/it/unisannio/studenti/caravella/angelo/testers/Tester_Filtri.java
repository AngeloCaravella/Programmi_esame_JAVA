package it.unisannio.studenti.caravella.angelo.testers;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.classes.Archivio;
import it.unisannio.studenti.caravella.angelo.classes.Magazzino;
import it.unisannio.studenti.caravella.angelo.classes.Prodotto;

import java.io.*;

public class Tester_Filtri {

	public static void main( String [] args) throws FileNotFoundException {
		
		Scanner sc1=new Scanner (new File("Products.txt"));
		Scanner sc2=new Scanner (new File("stores.txt"));
		Scanner sc3=new Scanner (new File("stocks.txt"));
		
		
		Archivio archivio= new Archivio( sc1, sc2, sc3);
		
		HashMap <String , Magazzino> magazzino= archivio.FiltraProdottiMagazzino("ENG1212121");
		
		//archivio.StampaArchivio(magazzino);
		
		HashMap <String , Prodotto> prodotto= archivio.ArticoliDellaMarca("Geox");
		//archivio.StampaProdotto(prodotto);
		
		HashMap <String , Magazzino> magazzino2= archivio.FiltraMagazzinoDelLuogo("Benevento");
		//archivio.StampaMagazzino(magazzino2);
		
		//archivio.StampaProdottoLocalizzato(magazzino2);
		
		String magazzinocodice= archivio.FiltraProdottoQuantità(30);
		
		
		HashMap <String , Magazzino> magazzino3= archivio.FiltraProdottiMagazzino(magazzinocodice);
		String idmag= archivio.TrovaProdotto( magazzino3, "sandali", "blu", "Geox" );
		
		archivio.PrintMagazzino(idmag);
	}
}
