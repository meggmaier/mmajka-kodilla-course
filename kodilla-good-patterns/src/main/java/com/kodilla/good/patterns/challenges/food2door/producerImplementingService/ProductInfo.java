package com.kodilla.good.patterns.challenges.food2door.producerImplementingService;

public class ProductInfo {

    private String productName;
    private int productQuantity;

    public ProductInfo(String productName, int productQuantity) {
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }
}
