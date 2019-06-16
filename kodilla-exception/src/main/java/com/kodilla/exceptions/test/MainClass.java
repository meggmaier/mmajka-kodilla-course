package com.kodilla.exceptions.test;

import java.util.HashMap;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) {

        Flight flight1 = new Flight("Warszawa Modlin", "Wrocław");
        Flight flight2 = new Flight("Warszawa Okęcie", "Wrocław");
        Flight flight3 = new Flight("Berlin", "Wrocław");

        FlightSearch search = new FlightSearch();

        try {
            System.out.println("Checking: [" + flight1.getDepartureAirport() + "] to [" + flight1.getArrivalAirport() + "]");
            search.findFlight(flight1);
        } catch (RouteNotFoundException e) {
            System.out.println("This route is unavailable. Please try other airports.");
        } finally {
           System.out.println("Have a nice day!");
        }

        try {
            System.out.println("Checking: [" + flight2.getDepartureAirport() + "] to [" + flight2.getArrivalAirport() + "]");
            search.findFlight(flight2);
        } catch (RouteNotFoundException e) {
            System.out.println("This route is unavailable. Please try other airports.");
        } finally {
            System.out.println("Have a nice day!");
        }

        try {
            System.out.println("Checking: [" + flight3.getDepartureAirport() + "] to [" + flight3.getArrivalAirport() + "]");
            search.findFlight(flight3);
        } catch (RouteNotFoundException e) {
            System.out.println("This route is unavailable. Please try other airports.");
        } finally {
            System.out.println("Have a nice day!");
        }
    }
}
