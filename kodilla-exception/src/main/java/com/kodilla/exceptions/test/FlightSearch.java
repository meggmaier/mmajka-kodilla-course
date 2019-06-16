package com.kodilla.exceptions.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public void findFlight(Flight flight) throws RouteNotFoundException {

        String departureAirport = flight.getDepartureAirport();
        String arrivalAirport = flight.getArrivalAirport();

        Map<String, Boolean> flights = new HashMap<>();
        flights.put("Warszawa Okęcie", true);
        flights.put("Warszawa Modlin", false);
        flights.put("Wrocław", true);
        flights.put("Poznań Ławica", true);
        flights.put("Kraków Balice", false);
        flights.put("Katowice Pyrzowice", true);
        flights.put("Łódź Lublinek", false);

        if (flights.get(departureAirport) == null
                || flights.get(arrivalAirport) == null) {

            throw new RouteNotFoundException();
        }

        if (flights.get(departureAirport)
            && flights.get(arrivalAirport)) {
            System.out.println("You're flight from [" + departureAirport + "] to [" + arrivalAirport + "] is available for booking.");
        }

        else {
            throw new RouteNotFoundException();
        }
    }

}
