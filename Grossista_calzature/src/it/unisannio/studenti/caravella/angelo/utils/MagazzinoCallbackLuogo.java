package it.unisannio.studenti.caravella.angelo.utils;

import it.unisannio.studenti.caravella.angelo.classes.Magazzino;

public class MagazzinoCallbackLuogo implements Tester {

	
	
	/**
	 * @param codice
	 */
	public MagazzinoCallbackLuogo(String luogo) {
		this.luogo = luogo;
	}

	@Override
	public boolean Verify(Object o) {
		Magazzino m= null;
		if( o instanceof Magazzino) {
			
			m= (Magazzino)o;
			
			if( m.getCittà().equals(luogo))
				return true;
			
		}
		
		
		return false;
	}

	private String luogo;
}
