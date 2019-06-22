package com.kodilla.good.patterns.challenges.services;

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
}
