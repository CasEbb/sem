package model;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    // Attributes
	private int booking_id;

    // Connections
	private List<Ticket> tickets;
	
	public Booking(int booking_id){
		this.booking_id = booking_id;
        this.tickets = new ArrayList<Ticket>();
    }

    public void addTicket(Ticket t){ tickets.add(t); }
}
