package com.kodilla.good.patterns.challenges.services;

import com.kodilla.good.patterns.challenges.products.ProductInformation;
import com.kodilla.good.patterns.challenges.users.User;

import java.math.BigDecimal;
import java.util.List;

public class PaymentService {

    private List<ProductInformation> listOfProducts;
    private User user;
    private PaymentMethod paymentMethod;

    public PaymentService(List<ProductInformation> listOfProducts, User user, PaymentMethod paymentMethod) {
        this.listOfProducts = listOfProducts;
        this.user = user;
        this.paymentMethod = paymentMethod;
    }

    public void pay() {

        System.out.println("You've chosen " + paymentMethod + " to pay for your order.");

    }

    public void getInvoice(){

        BigDecimal toPay = BigDecimal.valueOf(0);

        System.out.println("Please find your invoice below.");
        System.out.println(user.getFirstName() + " " + user.getLastName()
                + "\n" + user.getInvoiceAddress());

        for (ProductInformation products : listOfProducts){
            BigDecimal price = products.getPrice();
            System.out.println("Product: " + products.getProductName()
                    + "\n Price: " + price);
            toPay = toPay.add(price);
        }

        System.out.println("\n To pay: " + toPay);
    }
}
