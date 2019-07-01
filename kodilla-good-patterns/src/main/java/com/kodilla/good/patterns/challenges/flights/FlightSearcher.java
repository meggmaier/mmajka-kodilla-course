package com.kodilla.good.patterns.challenges.flights;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightSearcher {

    private HashMap <Airport, Airport> fromToFlights;
    private Airport homeAirport;
    private Airport destinationAirport;

    public FlightSearcher(HashMap<Airport, Airport> fromToFlights, Airport homeAirport, Airport destinationAirport) {
        this.fromToFlights = fromToFlights;
        this.homeAirport = homeAirport;
        this.destinationAirport = destinationAirport;
    }

    public HashMap<Airport, Airport> getFromToFlightsMap() {
        return fromToFlights;
    }

    public Airport getHomeAirport() {
        return homeAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public List<Airport> searchAllDepartures(){

        return fromToFlights.entrySet().stream()
                .filter(k -> k.getKey().equals(homeAirport))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public List<Airport> searchAllArrivals(){

        return fromToFlights.entrySet().stream()
                .filter(v -> v.getValue().equals(homeAirport))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private boolean hasDirectConnection(){

        return fromToFlights.entrySet().stream()
                .filter(k -> k.getKey().equals(homeAirport))
                .anyMatch(v -> v.getValue().equals(destinationAirport));
    }

    public HashMap<Airport, Airport> getDirectConnection(){

        HashMap<Airport, Airport> directConnection = new HashMap<>();

        if(hasDirectConnection()) {

                    fromToFlights.entrySet().stream()
                            .filter(k -> k.getKey().equals(homeAirport))
                            .filter(v -> v.getValue().equals(destinationAirport))
                            .forEach(entry -> directConnection.put(entry.getKey(), entry.getValue()));
        } else {
            System.out.println("There's no direct connections.");
        }

        return directConnection;
    }

    public HashMap<Airport, Airport> getNonDirectConnection(Airport changeAirport){

        HashMap<Airport, Airport> possibleFlightConnections = new HashMap<>();

        if(!hasDirectConnection()){

             fromToFlights.entrySet().stream()
                      //  .filter(el -> el.getKey().equals(homeAirport) || el.getValue().equals(destinationAirport))
                        .filter(el -> el.getKey().equals(changeAirport) || el.getValue().equals(changeAirport))
                        .forEach(entry -> possibleFlightConnections.put(entry.getKey(), entry.getValue()));

        }

        return possibleFlightConnections;
    }
}
