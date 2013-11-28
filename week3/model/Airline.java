package model;

import java.util.*;

public class Airline {
    private String name;

    private List<Flight> flights;

    public Airline(String name){
        this.name = name;
        this.flights = new ArrayList<Flight>();
    }


}
