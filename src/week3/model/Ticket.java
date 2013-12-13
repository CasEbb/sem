package week3.model;

public class Ticket {
    private int ticket_id;
    private Passenger passenger;
    private Seat seat;
    private Flight flight;

    public Ticket(int t, Passenger p, Seat s, Flight f){
        this.ticket_id = t;
        this.passenger = p;
        this.seat = s;
        this.flight = f;
    }

    public int getTicketId(){ return ticket_id; }

    public Passenger getPassenger(){ return passenger; }

    public Seat getSeat(){ return seat; }

    public Flight getFlight(){ return flight; }
}
