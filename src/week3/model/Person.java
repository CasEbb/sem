package model;

public abstract class Person {
	private int person_id;
	private String initials;
	private String last_name;
	private char gender;
	private String address;
	private int house_number;
	private String zipcode;
	private String country;
	private String passport;

    public Person(){
        this.person_id  = 0;
        this.initials   = "";
        this.last_name  = "";
        this.gender     = 'N';
        this.address    = "";
        this.house_number   = 0;
        this.zipcode    = "";
        this.country    = "";
        this.passport   = "";
    }

	public Person(int person_id, String initials, String last_name, char gender, 
			String address, int house_number, String zipcode, String country,
			String passport){
		this.person_id = person_id;
		this.initials = initials;
		this.last_name = last_name;
		this.gender = gender;
		this.address = address;
		this.house_number = house_number;
		this.zipcode = zipcode;
		this.country = country;
		this.passport = passport;
	}
}
