package election.model;

import java.util.ArrayList;
import java.util.List;

public class Seat {
	
	private String name;
	
	private Body body;
	
	private List<Term> seatHolders;
	
	public Seat(String name, Body body) {
		this.name = name;
		this.body = body;
		this.seatHolders = new ArrayList<Term>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Body getBody() {
		return this.body;
	}
	
	public List<Term> getSeatHolders() {
		return this.seatHolders;
	}

}