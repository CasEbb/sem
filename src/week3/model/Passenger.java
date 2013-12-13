package week3.model;


public class Passenger extends Person {

	public Passenger(int person_id, String initials, String last_name,
			char gender, String address, int house_number, String zipcode,
			String country, String passport) {
		super(person_id, initials, last_name, gender, address, house_number,
				zipcode, country, passport);
	}

    public Passenger(){
        super();
    }

}
