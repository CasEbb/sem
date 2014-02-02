package election.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Seat implements Serializable {
	
	private String name;
	
	private List<Term> seatHolders;
	
	/**
	 * Representeert een zetel in een orgaan
	 * @param name naam van de zetel
	 */
	public Seat(String name) {
		this.name = name;
		this.seatHolders = new ArrayList<Term>();
	}
	
	/**
	 * Geeft de naam van de zetel terug
	 * @return zetelnaam
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Geeft de lijst terug met personen die ooit de zetel bemachtigd hebben
	 * @return lijst met (oud)zetelhouders
	 */
	public List<Term> getSeatHolders() {
		return this.seatHolders;
	}
	
	/**
	 * Geeft de zetelnaam
	 */
	public String toString() {
		return this.name;
	}
	
	/**
	 * Geeft de huidige zetelhouder terug
	 * @return bezetting van huidige houder
	 */
	public Term getCurrentTerm() {
		if(this.seatHolders.size() >= 1) {
			return this.seatHolders.get(this.seatHolders.size() - 1);
		} else {
			return null;
		}
	}
	
	/**
	 * Geeft de vorige eigenaar
	 * @return bezetting van de vorige zetelhouder
	 */
	public Term getPreviousTerm() {
		if(this.seatHolders.size() >= 2) {
			return this.seatHolders.get(this.seatHolders.size() - 2);
		} else {
			return null;
		}
	}

}
