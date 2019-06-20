package com.kodilla.good.patterns.challenges;

public class ProductInformation {

    private String productName;
    private int inStock;
    private double price;

    public ProductInformation(String productName, int inStock, double price) {
        this.productName = productName;
        this.inStock = inStock;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantityInStock() {
        return inStock;
    }

    public double getPrice() {
        return price;
    }
}
