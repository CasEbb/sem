package model;

import java.util.*;

public class Airline {
    // Attributes
    private String name;

    // Connections
    private List<Flight> flights;

    public Airline(String name){
        this.name = name;
        this.flights = new ArrayList<Flight>();
    }

    public void addFlight(Flight f){ flights.add(f); }


}
