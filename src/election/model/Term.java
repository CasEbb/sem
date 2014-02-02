package election.model;

import java.io.Serializable;
import java.util.Date;

public class Term implements Serializable {
	
	private Person person;
	
	private Seat seat;
		
	private Date startDate;
	
	private Date endDate;
	
	public Term(Person person, Seat seat, Date startDate) {
		this.person = person;
		this.seat = seat;
		this.startDate = startDate;
	}
	
	public Person getPerson() {
		return this.person;
	}
	
	public Seat getSeat() {
		return this.seat;
	}
	
	public Date getStartDate() {
		return this.startDate;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	
	public boolean endTerm() {
		if(this.endDate == null) {
			this.endDate = new Date();
			return true;
		} else {
			return false;
		}
	}

}
