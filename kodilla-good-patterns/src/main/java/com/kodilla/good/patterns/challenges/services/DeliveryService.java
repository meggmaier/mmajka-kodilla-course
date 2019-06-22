package com.kodilla.good.patterns.challenges.services;

import com.kodilla.good.patterns.challenges.users.User;

public class DeliveryService {

    private DeliveryMethod deliveryMethod;
    private User user;

    public DeliveryService(DeliveryMethod deliveryMethod, User user) {
        this.deliveryMethod = deliveryMethod;
        this.user = user;
    }

    public void deliver() {
        System.out.println("You've chosen " + deliveryMethod + " to deliver your order.");

        if(user.getDeliveryAddress().equals(user.getInvoiceAddress())){
            System.out.println("Your order will be delivered to the same address as on invoice.");
        } else {
            System.out.println("Your order will be delivered to " + user.getDeliveryAddress() + ".");
        }
    }
}
