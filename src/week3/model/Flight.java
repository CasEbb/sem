package week3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight {
    // Attributes
	private int flight_id;

    // Connections
	private Location departure_location;
	private Location arrival_location;
	private Airplane airplane;
    private List<Ticket> tickets;
	
	public Flight(int flight_id, Date departure_time, Date arrival_time,
					Location departure_location, Location arrival_location,
					Airplane airplane){

		this.flight_id = flight_id;
		
		this.departure_location = departure_location;
		this.arrival_location = arrival_location;
		
		this.airplane = airplane;

        this.tickets = new ArrayList<Ticket>();
	}

    public Flight(){

        this.flight_id = 0;

        this.departure_location = new Location();
        this.arrival_location = new Location();

        this.airplane = new Airplane();

        this.tickets = new ArrayList<Ticket>();
    }

    public Airplane getAirplane(){ return airplane; }

    public Location getDepartureLocation(){ return departure_location; }
    public Location getArrivalLocation(){ return arrival_location; }
    public Ticket getTicket(int id){ return tickets.get(id); }
    public int getFlightId(){ return flight_id; }

    public void addTicket(Ticket t){ tickets.add(t); }

}
