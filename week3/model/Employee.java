package model;

public class Employee extends Person {
	private String occupation;
	private Employee observer;

	public Employee(int person_id, String initials, String last_name,
			char gender, String address, int house_number, String zipcode,
			String country, String passport) {
		super(person_id, initials, last_name, gender, address, house_number,
				zipcode, country, passport);
	}

}
