package election.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Body implements Serializable {

	private String name;
	
	private List<Seat> seats;
	
	private Election election = null;
	
	/**
	 * Intialiaseert een verkiesbaar orgaan.
	 * @param name de naam van het orgaan
	 * @param seats zetels in het orgaan
	 */
	public Body(String name, List<Seat> seats) {
		this.name = name;
		this.seats = seats;
	}
	
	/**
	 * Geeft de naam van het orgaan
	 * @return String met de naam
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Geeft de zetels van het orgaan
	 * @return List met de orgaanzetels
	 */
	public List<Seat> getSeats() {
		return this.seats;
	}
	
	/**
	 * Verandert de naam van het orgaan
	 * @param name de nieuwe naam
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Geeft een verkiezing terug als die bezig is voor dit orgaan
	 * @return een verkiezing of null
	 */
	public Election getElection() {
		return this.election;
	}
	
	/**
	 * Alias voor getName()
	 */
	public String toString() {
		return this.name;
	}
	
	/**
	 * Geeft aan of dit orgaan een lopende verkiezing heeft
	 * @return boolean of er een verkiezing loopt
	 */
	public boolean inElection() {
		return (this.election != null);
	}

	/**
	 * Start een verkiezing voor dit orgaan
	 * @param date de datum van de verkiezing
	 * @param seats de zetels die vergeven mogen worden
	 * @param candidates kandidaten voor de zetels
	 * @param voters de mensen met stemrecht voor deze verkiezing
	 * @param numPollOffset identificatie van het eerste stembureau
	 * @param numPolls aantal stembureaus
	 * @return geeft de lijst met stembureaus terug
	 */
	public List<Poll> startElection(Date date, List<Seat> seats, List<Person> candidates, List<Person> voters, int numPollOffset, int numPolls) {
		if(this.election == null) {
			Election e = new Election(this, date, seats, candidates, voters, numPollOffset, numPolls);
			this.election = e;
			return e.getPolls();
		} else {
			return null;
		}
	}
	
	/**
	 * Sluit een mogelijk lopende verkiezing af
	 * @return true als er een verkiezing liep
	 */
	public boolean endElection() {
		if(this.election != null) {
			this.election = null;
			return true;
		} else {
			return false;
		}
	}
	
}
