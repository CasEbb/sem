package model;

public class Airplane {
	private int airplane_id;
	private String model;
	
	private Seat[] seats;
	
	public Airplane(int airplane_id, String model, int seats){
		this.airplane_id = airplane_id;
		this.model = model;
		
		for( int i = 0; i < seats ; i++){
            this.seats[i] = new Seat(i);
        }
	}

    public Seat getSeat(int id){
        return seats[id];
    }

    public int getSeatAmount(){
        return seats.length;
    }
}
