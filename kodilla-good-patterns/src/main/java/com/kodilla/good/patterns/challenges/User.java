package com.kodilla.good.patterns.challenges;

public class User {

String firstName;
String lastName;
String invoiceAddress;
String deliveryAddress;

    public User(String firstName, String lastName, String invoiceAddress, String deliveryAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.invoiceAddress = invoiceAddress;
        this.deliveryAddress = deliveryAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}
