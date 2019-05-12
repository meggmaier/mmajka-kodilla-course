package com.kodilla.exceptions.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public void findFlight(Flight flight) throws RouteNotFoundException {

        Map<String,Boolean> flights = new HashMap<>();
        flights.put("Warszawa Okęcie", true);
        flights.put("Warszawa Modlin", false);
        flights.put("Wrocław", true);
        flights.put("Poznań Ławica", true);
        flights.put("Kraków Balice",false);
        flights.put("Katowice Pyrzowice", true);
        flights.put("Łódź Lublinek", false);

        if(flights.keySet().equals(flight.arrivalAirport) && flights.keySet().equals(flight.departureAirport)){
            System.out.println("You're flight is available for booking.");
        } else {
            throw new RouteNotFoundException();
        }

    }
}
