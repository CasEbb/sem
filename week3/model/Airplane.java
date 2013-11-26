package model;

public class Airplane {
	private int airplane_id;
	private String model;
	
	private Seat[] seats;
	
	public Airplane(int airplane_id, String model, Seat[] seats){
		this.airplane_id = airplane_id;
		this.model = model;
		
		this.seats = seats;
	}
}
