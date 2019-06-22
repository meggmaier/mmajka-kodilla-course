package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.products.Basket;
import com.kodilla.good.patterns.challenges.products.ProductInformation;
import com.kodilla.good.patterns.challenges.services.*;
import com.kodilla.good.patterns.challenges.users.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AllegroApp {

    public static void main(String[] args) {

        List<ProductInformation> listOfProducts = new ArrayList<>();

        ProductInformation product1 = new ProductInformation("Jumper with puppies", 5, BigDecimal.valueOf(6.99));
        ProductInformation product2 = new ProductInformation("Toothbrush", 1, BigDecimal.valueOf(0.99));
        ProductInformation product3 = new ProductInformation("Gun", 0, BigDecimal.valueOf(99.99));

        Basket basket = new Basket(listOfProducts);
        basket.putInBasket(product1);
        basket.putInBasket(product2);
        basket.putInBasket(product3);

        User user = new User("John", "Wick", "X Street, NY", "Y Street, NY");
        OrderRequest orderRequest1 = new OrderRequest(listOfProducts);
        PaymentService paymentService = new PaymentService(listOfProducts, user, PaymentMethod.PAYPAL );
        DeliveryService deliveryService = new DeliveryService(DeliveryMethod.PACZKOMAT, user);

        ProductOrderService pod = new ProductOrderService(orderRequest1, paymentService, deliveryService);

        pod.process();
    }
}
