package election.model;

import java.io.Serializable;

public class Suffrage implements Serializable {
	
	private Person person;
	
	private Poll poll;
	
	/**
	 * Geeft het stemrecht weer dat een persoon bij een stembureau heeft
	 * @param person natuurlijk persoon
	 * @param poll stembureau
	 */
	public Suffrage(Person person, Poll poll) {
		this.person = person;
		this.poll = poll;
	}
	
	/**
	 * Geeft het natuurlijke persoon terug waarvoor dit stemrecht geldt
	 * @return persoon
	 */
	public Person getPerson() {
		return this.person;
	}
	
	/**
	 * Geeft het stembureau waarvoor dit stemrecht geldt
	 * @return stembureau
	 */
	public Poll getPoll() {
		return this.poll;
	}

}
