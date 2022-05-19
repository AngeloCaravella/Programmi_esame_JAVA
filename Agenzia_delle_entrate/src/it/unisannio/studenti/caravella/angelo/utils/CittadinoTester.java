package it.unisannio.studenti.caravella.angelo.utils;
import java.util.*;
import it.unisannio.studenti.caravella.angelo.classes.Cittadino;
import it.unisannio.studenti.caravella.angelo.classes.Reddito;

public class CittadinoTester implements Tester {

	public CittadinoTester(String nome, String cognome, Date data) {
		this.nome=nome;
		this.cognome=cognome;	
		this.data=data;
	}
	@Override
	public boolean Verify(Object o) {
		Cittadino cit= null;
		
		if( o instanceof Cittadino ) {
			cit= (Cittadino) o;
			if( cit.getNome().equals(nome) && cit.getCognome().equals(cognome)) 
				 return true;			
		}
		
		return false;
	}
	private String nome;
	private String cognome;
	private Date data;
	
}
