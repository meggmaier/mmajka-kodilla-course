package com.kodilla.exceptions.test;

public class MainClass {
    public static void main(String[] args) {
        Flight flight1 = new Flight("Warszawa Modlin", "Wrocław");
        FlightSearch search = new FlightSearch();

        try {
            search.findFlight(flight1);
        } catch (RouteNotFoundException e) {
            System.out.println("This route is unavailable. Please try other airports.");
        } finally {
            System.out.println("Have a nive day!");
        }

    }
}
