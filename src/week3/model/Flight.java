package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Flight {
	private int flight_id;
	private Date departure_time;
	private Date arrival_time;
	
	private Location departure_location;
	private Location arrival_location;
	
	private Airplane airplane;

    private List<Booking> bookings;
	
	public Flight(int flight_id, Date departure_time, Date arrival_time,
					Location departure_location, Location arrival_location,
					Airplane airplane){
		this.flight_id = flight_id;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		
		this.departure_location = departure_location;
		this.arrival_location = arrival_location;
		
		this.airplane = airplane;

        bookings = new ArrayList<Booking>();

	}

    public Airplane getAirplane(){
        return airplane;
    }

    public boolean addBooking(Person p, Seat s){
        return false;
    }

}
