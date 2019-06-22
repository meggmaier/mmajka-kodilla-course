package com.kodilla.good.patterns.challenges.food2door.producers;

import com.kodilla.good.patterns.challenges.food2door.producerImplementingService.FoodProducer;
import com.kodilla.good.patterns.challenges.food2door.producerImplementingService.NewProducer;
import com.kodilla.good.patterns.challenges.food2door.producerImplementingService.ProducerInfo;
import com.kodilla.good.patterns.challenges.food2door.producerImplementingService.ProductInfo;

public class HealthyShop extends FoodProducer implements NewProducer {

    private int MINIMAL_ORDER = 50;

    public HealthyShop(ProducerInfo producerInfo, ProductInfo productInfo) {
        super(producerInfo, productInfo);
    }

    @Override
    public void process() {

        int quantityToOrder = getProductInfo().getProductQuantity();

        if (quantityToOrder < MINIMAL_ORDER) {
            System.out.println("Your order is too small to be realized.");
        } else {
            completeOrder();
        }
    }
}
