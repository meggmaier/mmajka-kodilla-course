package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;

public class ProductOrderService {

    private OrderRequest orderRequest;
    private PaymentService paymentService;
    private DeliveryService deliveryService;

    public ProductOrderService(OrderRequest orderRequest, PaymentService paymentService, DeliveryService deliveryService) {
        this.orderRequest = orderRequest;
        this.paymentService = paymentService;
        this.deliveryService = deliveryService;
    }

    public void process(){
        orderRequest.order();
        paymentService.getInvoice();
        paymentService.pay();
        deliveryService.deliver();
    }

    public static void main(String[] args) {

        List<ProductInformation> listOfProducts = new ArrayList<>();

        ProductInformation product1 = new ProductInformation("Jumper with puppies", 5, 6.99);
        ProductInformation product2 = new ProductInformation("Toothbrush", 1, 0.99);
        ProductInformation product3 = new ProductInformation("Gun", 0, 99.99);

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
