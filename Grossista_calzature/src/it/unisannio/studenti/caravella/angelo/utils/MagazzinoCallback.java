package it.unisannio.studenti.caravella.angelo.utils;

import it.unisannio.studenti.caravella.angelo.classes.Magazzino;

public class MagazzinoCallback implements Tester {

	
	
	/**
	 * @param codice
	 */
	public MagazzinoCallback(String codice) {
		this.codice = codice;
	}

	@Override
	public boolean Verify(Object o) {
		Magazzino m= null;
		if( o instanceof Magazzino) {
			
			m= (Magazzino)o;
			
			if( m.getId_magazzino().equals(codice))
				return true;
			
		}
		
		
		return false;
	}

	private String codice;
}
