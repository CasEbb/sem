package model;

import java.util.ArrayList;
import java.util.List;

public class Passenger extends Person {

    private List<Booking> bookings;

	public Passenger(int person_id, String initials, String last_name,
			char gender, String address, int house_number, String zipcode,
			String country, String passport) {
		super(person_id, initials, last_name, gender, address, house_number,
				zipcode, country, passport);

        bookings = new ArrayList<Booking>();

	}

    /*public Booking createBooking (int booking_id, Flight flight, Seat seat){
        if (Flight.)
    }*/

}
