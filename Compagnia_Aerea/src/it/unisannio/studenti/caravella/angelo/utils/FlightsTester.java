package it.unisannio.studenti.caravella.angelo.utils;

import it.unisannio.studenti.caravella.angelo.classes.Volo;
import java.util.*;
public class FlightsTester implements Tester {

	/**
	 * @param data
	 * @param cit_p
	 * @param cit_a
	 */
	public FlightsTester(Date data, String cit_p, String cit_a) {
		this.data = data;
		this.cit_p = cit_p;
		this.cit_a = cit_a;
	}
	@Override
	public boolean Verify(Object o) {
		Volo v = null;
		if (o instanceof Volo) {
			v = (Volo) o;
			if (v.getData_p().after(data)&& v.getCitta_p().equals(cit_p) && v.getCitta_a().equals(cit_a))
				return true;

		}
		return false;
	}
	Date data;
	String cit_p;
	String cit_a;
}
