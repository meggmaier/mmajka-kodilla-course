package com.kodilla.good.patterns.challenges.flights;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightSearcher {

    private List<Pair> fromToFlights;

    public FlightSearcher(List<Pair> fromToFlights) {
        this.fromToFlights = fromToFlights;
    }

    public List<Object> searchAllDepartures(Airport homeAirport){

        return fromToFlights.stream()
                .filter(k -> k.getKey().equals(homeAirport))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public List<Object> searchAllArrivals(Airport homeAirport){

        return fromToFlights.stream()
                .filter(v -> v.getValue().equals(homeAirport))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Pair> getConnection(Airport homeAirport, Airport destinationAirport){

        List<Pair> connection;

        if(hasDirectConnection(homeAirport, destinationAirport)) {

             connection = fromToFlights.stream()
                            .filter(k -> k.getKey().equals(homeAirport))
                            .filter(v -> v.getValue().equals(destinationAirport))
                            .collect(Collectors.toList());
        } else {
            System.out.println("There's no direct connection.");
            System.out.println("Looking for alternative routs...");

            connection = fromToFlights.stream()
                    .filter(el -> el.getKey().equals(homeAirport) || el.getValue().equals(destinationAirport))
                    .collect(Collectors.toList());

            for (int i = 0; i < connection.size()-1; i++) {
                Pair current = connection.get(i);
                Pair next = connection.get(i+1);
                    //if (current.getValue().equals(next.get) {

                   // }
                }

            }

        return connection;
    }

    private boolean hasDirectConnection(Airport homeAirport, Airport destinationAirport){

        return fromToFlights.stream()
                .filter(k -> k.getKey().equals(homeAirport))
                .anyMatch(el -> el.getValue().equals(destinationAirport));
    }


}
