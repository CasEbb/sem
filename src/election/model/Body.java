package election.model;

import java.util.ArrayList;
import java.util.List;

public class Body {

	private String name;
	
	private List<Seat> seats;
	
	public Body(String name) {
		this.name = name;
		this.seats = new ArrayList<Seat>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Seat> getSeats() {
		return this.seats;
	}

}
