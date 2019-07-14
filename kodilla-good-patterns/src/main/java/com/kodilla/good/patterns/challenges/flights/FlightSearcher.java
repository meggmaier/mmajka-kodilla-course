package com.kodilla.good.patterns.challenges.flights;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightSearcher {

    private HashMap <Airport, Airport> fromToFlights;

    public FlightSearcher(HashMap<Airport, Airport> fromToFlights) {
        this.fromToFlights = fromToFlights;
    }

    public HashMap<Airport, Airport> getFromToFlightsMap() {
        return fromToFlights;
    }

    public List<Airport> searchAllDepartures(Airport homeAirport){

        return fromToFlights.entrySet().stream()
                .filter(k -> k.getKey().equals(homeAirport))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public List<Airport> searchAllArrivals(Airport homeAirport){

        return fromToFlights.entrySet().stream()
                .filter(v -> v.getValue().equals(homeAirport))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public boolean hasDirectConnection(Airport homeAirport, Airport destinationAirport){

        return fromToFlights.entrySet().stream()
                .filter(k -> k.getKey().equals(homeAirport))
                .anyMatch(el -> el.getValue().equals(destinationAirport));
    }

    public HashMap<Airport, Airport> getConnection(Airport homeAirport, Airport destinationAirport){

        HashMap<Airport, Airport> connection = new HashMap<>();

        if(hasDirectConnection(homeAirport, destinationAirport)) {

                    fromToFlights.entrySet().stream()
                            .filter(k -> k.getKey().equals(homeAirport))
                            .filter(v -> v.getValue().equals(destinationAirport))
                            .forEach(entry -> connection.put(entry.getKey(), entry.getValue()));
        } else {
            System.out.println("There's no direct connection.");
            System.out.println("Looking for alternative routs...");

                    fromToFlights.entrySet().stream()
                        .filter(el -> el.getKey().equals(homeAirport) || el.getValue().equals(destinationAirport))
                        .filter(el -> el.getValue().equals(el.getKey()))
                        .forEach(entry -> connection.put(entry.getKey(), entry.getValue()));
        }
        return connection;
    }
}
