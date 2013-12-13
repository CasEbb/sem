package week3.model;

import java.util.ArrayList;
import java.util.List;

public class Airplane {
    // Connections
	private List<Seat> seats;
    private List<Flight> flights;
    /**
     * Creates an instance of an Airplane.
     * @param airplane_id The id of the Airplane
     * @param model Airplane model
     * @param seats Amount of Seats in this Airplane
     */
	public Airplane(int airplane_id, String model, int seats){
		this.seats = new ArrayList<Seat>();
        for(int i = 0; i < seats ; i++){
            this.seats.add(new Seat());
        }
	}

    // getters

    public Airplane() {
		// TODO Auto-generated constructor stub
	}

	/**
     * Returns the seat with id.
     * @param id The Seat id to be retrieved
     * @return Seat Seat object with seatId id
     */
    public Seat getSeat(int id){ return seats.get(id); }
    public int getSeatAmount(){ return seats.size(); }

    // setters

    /**
     * Sets the owner of the Airplane.
     * @param a Airline instance of owner
     */
    public void setAirline(Airline a){ }

    // adds

    /**
     * Adds a Flight to the current Airplane.
     * @param f The instance of Flight to add
     */
    public void addFlight(Flight f){ flights.add(f); }
}
