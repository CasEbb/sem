package election.model;

import java.io.Serializable;

public class Person implements Serializable {
	
	private String name;
	
	private String address;
	
	/**
	 * Maakt een nieuw persoon aan
	 * @param name naam van de persoon
	 * @param address woonadres
	 */
	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	/**
	 * Geeft de naam van deze persoon
	 * @return volledige naam
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Geeft het adres van de persoon
	 * @return het woonadres
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Wijzigt de naam van het persoon
	 * @param name nieuwe naam
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Wijzigt het adres van de persoon
	 * @param address nieuwe adres
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Geeft de naam en adres
	 */
	public String toString() {
		return "[" + this.name + ", " + this.address + "]";
	}

}
