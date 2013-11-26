package model;

public class Booking {
	private int booking_id;
	private Passenger[] passengers;
	private Flight[] flights;
	
	public Booking(int booking_id, Passenger[] passengers, Flight[] flights){
		this.booking_id = booking_id;
		this.passengers = passengers;
		this.flights = flights;
	}
}
