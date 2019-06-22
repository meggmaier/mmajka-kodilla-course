package com.kodilla.good.patterns.challenges.food2door.producers;

import com.kodilla.good.patterns.challenges.food2door.producerImplementingService.FoodProducer;
import com.kodilla.good.patterns.challenges.food2door.producerImplementingService.NewProducer;
import com.kodilla.good.patterns.challenges.food2door.producerImplementingService.ProducerInfo;
import com.kodilla.good.patterns.challenges.food2door.producerImplementingService.ProductInfo;

public class GlutenFreeShop extends FoodProducer implements NewProducer {

    public GlutenFreeShop(ProducerInfo producerInfo, ProductInfo productInfo) {
        super(producerInfo, productInfo);
    }

    private void createOrderRequest(){
        System.out.println("New Order Request has been created.");
        autoMail();
    }

    private void autoMail(){
        System.out.println("New Order Request has been sent at orderrequests@glutenfreeshop.com");
    }

    @Override
    public void process() {
        createOrderRequest();
        completeOrder();
    }
}
