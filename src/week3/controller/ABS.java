package controller;

import model.*;
import view.*;
import java.util.*;

public class ABS {

    private List<Passenger> passengers;
    private List<Flight> flights;
    private List<Ticket> tickets;

    /**
     * Creates a new instance of the Airline Booking System
     */
    public ABS(){
        passengers = new ArrayList<Passenger>();
        flights = new ArrayList<Flight>();
        tickets = new ArrayList<Ticket>();
    }

    /**
     * Books a Flight for a Passenger and creates a ticket.
     * @param fid The id of the Flight
     * @param pid The id of the Passenger
     * @require fid and pid are valid ids; seatsAvailable() == true
     * @ensure new Ticket with tid == fid + " " + pid && seat assigned
     */
    public void book(int fid, int pid){
        Flight flight = new Flight();
        Passenger person = new Passenger();
        Seat seat = new Seat();

        boolean cFor = true;
        for(int f = 0; cFor == true && f < flights.size() ; f++) {
            if(flights.get(f).getFlightId() == fid){
                flight = flights.get(f);
                cFor = false;
            }
        }
        cFor = true;
        for(int p = 0; cFor == true && p < flights.size() ; p++) {
            if(passengers.get(p).getId() == fid){
                person = passengers.get(p);
                cFor = false;
            }
        }
        cFor = true;
        for(int s = 0; cFor == true && s < tickets.size() ; s++){
            if(!tickets.get(s).getSeat().isTaken()){
                seat = tickets.get(s).getSeat();
                tickets.get(s).getSeat().takeSeat();
            }
        }
        int tid = Integer.parseInt(String.format("%d %d", fid, pid));
        tickets.add(new Ticket(tid, person, seat, flight));

    }

    /**
     * Checks whether a Passenger has booked a Flight
     * @param fid The id of the Flight
     * @param pid The id of the Passenger
     * @require fid and pid are valid ids
     * @ensure true when Passenger.pid has booked Flight.fid; otherwise false.
     * @return true | false
     */
    public boolean isBooked(int fid, int pid){
        boolean found = false;
        for(int s = 0; found == false && s < tickets.size() ; s++){
            if(tickets.get(s).getSeat().isTaken()){
                found = (tickets.get(s).getFlight().getFlightId() == fid && tickets.get(s).getPassenger().getId() == pid);
            }
        }
        return found;
    }
}
