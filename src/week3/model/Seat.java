package model;

public class Seat {
	private int seat_id;
    private boolean isTaken;
	
	public Seat(int seat_id){
		this.seat_id = seat_id;
        this.isTaken = false;
	}

    public Seat(){
        this.seat_id = 0;
        this.isTaken = false;
    }

    public int getSeatId(){ return seat_id; }

    public boolean isTaken(){ return isTaken; }

    public void takeSeat(){ isTaken = true; }
}
