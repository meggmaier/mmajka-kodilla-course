package com.kodilla.good.patterns.challenges.flights;

import java.util.HashMap;

public class FlightsApp {

    public static void main(String[] args) {
        Airport pzn = new Airport("Poznań");
        Airport wawa = new Airport("Warszawa");
        Airport krk = new Airport("Kraków");
        Airport wrc = new Airport("Wrocław");

        HashMap<Airport, Airport> flights = new HashMap<>();

        flights.put(pzn, wawa);
        flights.put(pzn, wrc);
        flights.put(wawa, krk);
        flights.put(wawa, wrc);
        flights.put(wrc, wawa);
        flights.put(krk, wrc);

        FlightSearcher flightSearcher = new FlightSearcher(flights, pzn, krk);

        System.out.println("All arrivals: " + flightSearcher.searchAllArrivals() +
                "\n All departures: " + flightSearcher.searchAllDepartures() +
                "\n Direct connections: " + flightSearcher.getDirectConnection()
                + "\n Non-direct connections: " + flightSearcher.getNonDirectConnection(wawa)
                    );

    }

}
