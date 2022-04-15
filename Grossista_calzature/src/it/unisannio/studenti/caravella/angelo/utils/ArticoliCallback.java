package it.unisannio.studenti.caravella.angelo.utils;

import it.unisannio.studenti.caravella.angelo.classes.Prodotto;

public class ArticoliCallback implements Tester {

	public ArticoliCallback(String marca) {
		this.marca=marca;
	}

	@Override
	public boolean Verify(Object o) {
		Prodotto p= null;
		if( o instanceof Prodotto)
		{
			p= (Prodotto)o;
			if( p.getMarca().equals(marca))
				return true;
			
		}
		return false;
	}
	
	private String marca;

	
}
