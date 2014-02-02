package election.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Seat implements Serializable {
	
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
	
	public Term getCurrentTerm() {
		if(this.seatHolders.size() >= 1) {
			return this.seatHolders.get(this.seatHolders.size() - 1);
		} else {
			return null;
		}
	}
	
	public Term getPreviousTerm() {
		if(this.seatHolders.size() >= 2) {
			return this.seatHolders.get(this.seatHolders.size() - 2);
		} else {
			return null;
		}
	}

}
