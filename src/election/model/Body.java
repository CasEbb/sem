package election.model;

import java.util.List;

public class Body {

	private String name;
	
	private List<Seat> seats;
	
	public Body(String name, List<Seat> seats) {
		this.name = name;
		this.seats = seats;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Seat> getSeats() {
		return this.seats;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}

}
