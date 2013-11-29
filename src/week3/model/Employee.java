package model;

public class Employee extends Person {
    private Airline airline;

	private String occupation;
	private Employee observer;

    public Employee(){
        super();
    }

	public Employee(int person_id, String initials, String last_name,
			char gender, String address, int house_number, String zipcode,
			String country, String passport) {
		super(person_id, initials, last_name, gender, address, house_number,
				zipcode, country, passport);
        occupation = "";
        observer = new Employee();
        airline = new Airline("");
	}

    public Airline getAirline(){ return airline; }
    public Employee getObserver(){ return observer; }
    public String getOccupation(){ return occupation; }

    public void setAirline(Airline a){ this.airline = a; }
    public void setObserver(Employee o){ this.observer = o; }
    public void setOccupation(String o){ this.occupation = o; }

}
