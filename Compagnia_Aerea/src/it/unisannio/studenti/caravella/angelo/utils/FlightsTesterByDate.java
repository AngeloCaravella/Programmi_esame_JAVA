package it.unisannio.studenti.caravella.angelo.utils;

import it.unisannio.studenti.caravella.angelo.classes.Volo;
import java.util.*;
public class FlightsTesterByDate implements Tester {

	/**
	 * @param data
	 * @param cit_p
	 * @param cit_a
	 */
	public FlightsTesterByDate(Date data) {
		this.data = data;
	}
	@Override
	public boolean Verify(Object o) {
		Volo v = null;
		if (o instanceof Volo) {
			v = (Volo) o;
			if (v.getData_p().after(data))
				return true;

		}
		return false;
	}
	Date data;
}
