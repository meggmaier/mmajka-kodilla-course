package com.kodilla.exceptions.test;

public class MainClass {

    private static void checkFlight(Flight flightToFind, FlightSearch search){
    try {
        System.out.println("Checking: [" + flightToFind.getDepartureAirport() + "] to [" + flightToFind.getArrivalAirport() + "]");
        search.findFlight(flightToFind);
    } catch (RouteNotFoundException e) {
        System.out.println("This route is unavailable. Please try other airports.");
    } finally {
        System.out.println("Have a nice day!");
    }
}

    public static void main(String[] args) {

        Flight flight1 = new Flight("Warszawa Modlin", "Wrocław");
        Flight flight2 = new Flight("Warszawa Okęcie", "Wrocław");
        Flight flight3 = new Flight("Berlin", "Wrocław");

        FlightSearch search = new FlightSearch();

        checkFlight(flight1, search);
        checkFlight(flight2, search);
        checkFlight(flight3, search);
    }
}
