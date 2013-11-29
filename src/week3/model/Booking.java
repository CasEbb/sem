package model;

public class Booking {
	private int booking_id;
	private Passenger passenger;
	private Seat seat;
	
	public Booking(int booking_id){
		this.booking_id = booking_id;
	}

    public boolean assignBooking(Passenger p, Seat s) {
        boolean assigned = false;
        if(passenger == null && seat == null){
            this.passenger = p;
            this.seat = s;
            assigned = true;
        }
        return assigned;
    }
}
