package week3.model;

public abstract class Person {
	private int person_id;
	public Person(int person_id, String initials, String last_name, char gender, 
			String address, int house_number, String zipcode, String country,
			String passport){
		this.person_id = person_id;
	}

    public Person(){
        this.person_id  = 0;
    }

    public int getId(){
        return person_id;
    }
}
