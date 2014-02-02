package election.model;

import java.io.Serializable;
import java.util.Date;

public class Term implements Serializable {
	
	private Person person;
	
	private Seat seat;
		
	private Date startDate;
	
	private Date endDate;
	
	/**
	 * Maak een nieuwe zittingstijd aan
	 * @param person persoon die de zetel houdt
	 * @param seat de zetel
	 * @param startDate begindatum van zittingstijd
	 */
	public Term(Person person, Seat seat, Date startDate) {
		this.person = person;
		this.seat = seat;
		this.startDate = startDate;
	}

	/**
	 * Geeft de persoon terug waarvoor de zittingstijd geldt
	 * @return persoon
	 */
	public Person getPerson() {
		return this.person;
	}
	
	/**
	 * Geeft de zetel terug waarvoor de zittingstijd geldt
	 * @return zetel
	 */
	public Seat getSeat() {
		return this.seat;
	}
	
	/**
	 * Geeft de startdatum van de zittingstijd
	 * @return startdatum
	 */
	public Date getStartDate() {
		return this.startDate;
	}
	
	/**
	 * Geeft de einddatum van de zittingstijd
	 * @return einddatum
	 */
	public Date getEndDate() {
		return this.endDate;
	}
	
	/**
	 * Sluit de zittingstijd van een zetel af als dit nog niet is gedaan
	 * @return true als de zittingstijd nog niet afgesloten was, anders false
	 */
	public boolean endTerm() {
		if(this.endDate == null) {
			this.endDate = new Date();
			return true;
		} else {
			return false;
		}
	}

}
