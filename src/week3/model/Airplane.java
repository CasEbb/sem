package model;

import java.util.ArrayList;
import java.util.List;

public class Airplane {
	private int airplane_id;
	private String model;
	
	private List<Seat> seats;
	
	public Airplane(int airplane_id, String model, int seats){
		this.airplane_id = airplane_id;
		this.model = model;
		
	    this.seats = new ArrayList<Seat>();
	}

    public Airplane(){
        this.airplane_id = 0;
        this.model = "";

    }

    public Seat getSeat(int id){ return seats.get(id); }

    public int getSeatAmount(){ return seats.size(); }
}
