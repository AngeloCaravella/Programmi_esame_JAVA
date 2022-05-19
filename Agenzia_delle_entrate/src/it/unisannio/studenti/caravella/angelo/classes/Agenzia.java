package it.unisannio.studenti.caravella.angelo.classes;
import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.CittadinoNotFoundException;
import it.unisannio.studenti.caravella.angelo.utils.CittadinoTester;
import it.unisannio.studenti.caravella.angelo.utils.Constants;
public class Agenzia {

	/**
	 * @param cittadini
	 * @param redditi
	 */
	public Agenzia(HashMap<String, Cittadino> cittadini, HashSet<Reddito> redditi) {
		this.cittadini = cittadini;
		this.redditi = redditi;
	}
	public Agenzia(Scanner sc1, Scanner sc2) {
		Cittadino ct=Cittadino.read(sc1);
		this.cittadini=new HashMap<String, Cittadino>();
		while(ct!= null) {
		this.cittadini.put(ct.getCodice_fiscale(), ct);	
		ct=Cittadino.read(sc1);
		}
		this.redditi=new HashSet<Reddito>();
		Reddito rd= Reddito.read(sc2);
		while(rd!= null) {
			this.redditi.add(rd);
			CollegamentoRedditoCittadino( rd.getCodice_fiscale(), rd);
			rd= Reddito.read(sc2);
		}
	}
	public Agenzia SearchReddito(String nome, String cognome, String data) throws ParseException {
		Date d=Constants.yyyy.parse(data);
		CittadinoTester cit= new CittadinoTester(nome, cognome, d) ;
		
		return this.FiltraCittadino(cit);
	}

	
	private Agenzia FiltraCittadino(CittadinoTester cit) {
		Set<String> chiavi= this.cittadini.keySet();
		HashMap<String , Cittadino > cittadiniFiltrati=  new HashMap<String , Cittadino >();
		for (String s : chiavi) {
			if( cit.Verify(this.cittadini.get(s))) 
			
					cittadiniFiltrati.put(s, this.cittadini.get(s));
		}
		return new Agenzia(cittadiniFiltrati, this.redditi);
	}
	private void CollegamentoRedditoCittadino(String codice_fiscale,Reddito r) {
		Cittadino ct = this.cittadini.get(codice_fiscale.strip());
		try {
		if( ct== null)
			throw new CittadinoNotFoundException( "Il cittadino con il codice fiscale: "+ codice_fiscale+ " non esiste");
		}catch(CittadinoNotFoundException c ) {
			c.getMessage();
		}
		ct.addReddito(r);
		r.setCt(ct);
		
	}

	public void PrintAll() {
		
		this.cittadini.entrySet().forEach(entry->{
			System.out.println(entry.getKey()+ entry.getValue()); 
		});
		this.redditi.forEach(e->{
			System.out.println( e);
		});
		
	}
	

	private HashMap<String, Cittadino> cittadini;
	private HashSet< Reddito> redditi;
}