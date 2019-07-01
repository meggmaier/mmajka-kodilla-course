package com.kodilla.good.patterns.challenges.food2door.producers;

import com.kodilla.good.patterns.challenges.food2door.producerImplementingService.FoodProducer;
import com.kodilla.good.patterns.challenges.food2door.producerImplementingService.NewProducer;
import com.kodilla.good.patterns.challenges.food2door.producerImplementingService.ProducerInfo;
import com.kodilla.good.patterns.challenges.food2door.producerImplementingService.ProductInfo;

public class ExtraFoodShop extends FoodProducer implements NewProducer {

    private boolean orderRequestConfirmed;

    public ExtraFoodShop(ProducerInfo producerInfo, ProductInfo productInfo) {
        super(producerInfo, productInfo);
    }

    @Override
    public void process() {

        if (!orderRequestConfirmed) {
            System.out.println("Your order request has not been officially confirmed yet.");
            System.out.println("Please check your Client Profile at extrafoodshop.com");
        } else {
            completeOrder();
        }
    }
}