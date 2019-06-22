package com.kodilla.good.patterns.challenges.food2door.producerImplementingService;

public class FoodProducer {

    private ProducerInfo producerInfo;
    private ProductInfo productInfo;

    public FoodProducer(ProducerInfo producerInfo, ProductInfo productInfo) {
        this.producerInfo = producerInfo;
        this.productInfo = productInfo;
    }

    public ProducerInfo getProducerInfo() {
        return producerInfo;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void completeOrder(){
        System.out.println("Your order request to [" + producerInfo.getProducerName()
                + "] for [" + productInfo.getProductName()
                + "] of quantity of [" + productInfo.getProductQuantity()
                + "] is completed.");
    }
}
