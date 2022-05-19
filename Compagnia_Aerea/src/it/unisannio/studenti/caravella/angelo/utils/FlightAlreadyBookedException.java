package it.unisannio.studenti.caravella.angelo.utils;

public class FlightAlreadyBookedException extends RuntimeException {
	public FlightAlreadyBookedException(String message) {
		super(message);
	}
}
