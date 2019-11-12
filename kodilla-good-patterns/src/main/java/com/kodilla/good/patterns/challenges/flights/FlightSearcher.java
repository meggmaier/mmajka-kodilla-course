package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearcher {

    private List<Connection> fromToFlights;

    public FlightSearcher(List<Connection> fromToFlights) {
        this.fromToFlights = fromToFlights;
    }

    public List<Airport> searchAllDepartures(Airport home){

        return fromToFlights.stream()
                .filter(k -> k.getHome().equals(home))
                .map(Connection::getDestination)
                .collect(Collectors.toList());
    }

    public List<Airport> searchAllArrivals(Airport home){

        return fromToFlights.stream()
                .filter(v -> v.getDestination().equals(home))
                .map(Connection::getHome)
                .collect(Collectors.toList());
    }

    public List<Connection> getConnection(Airport home, Airport destination, Airport change){

        List<Connection> connections = new ArrayList<>();

        if(hasDirectConnection(home, destination)) {

             connections.add(new Connection(home, destination));

        } else {
            System.out.println("There's no direct connection.");
            System.out.println("Looking for alternative routs...");

            connections = fromToFlights.stream()
                    .filter(el -> el.getHome().equals(home) || el.getDestination().equals(destination))
                    .filter(a -> a.getDestination().equals(change) || a.getHome().equals(change))
                    .collect(Collectors.toList());
        }

        return connections;
    }

    private boolean hasDirectConnection(Airport home, Airport destination){

        return fromToFlights.stream()
                .filter(k -> k.getHome().equals(home))
                .anyMatch(el -> el.getDestination().equals(destination));
    }


}
