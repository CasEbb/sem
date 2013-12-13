package week3.model;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    // Connections
	private List<Ticket> tickets;
	
	public Booking(int booking_id){
		this.tickets = new ArrayList<Ticket>();
    }

    public void addTicket(Ticket t){ tickets.add(t); }
}
