package election.model;

import java.util.ArrayList;
import java.util.List;

public class Seat {
	
	private String name;
	
	private List<Term> seatHolders;
	
	public Seat(String name) {
		this.name = name;
		this.seatHolders = new ArrayList<Term>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Term> getSeatHolders() {
		return this.seatHolders;
	}
	
	public String toString() {
		return this.name;
	}

}
