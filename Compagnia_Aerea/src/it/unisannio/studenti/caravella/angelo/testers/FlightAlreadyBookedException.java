package it.unisannio.studenti.caravella.angelo.testers;

public class FlightAlreadyBookedException extends RuntimeException {
	public FlightAlreadyBookedException(String message) {
		super(message);
	}
}
