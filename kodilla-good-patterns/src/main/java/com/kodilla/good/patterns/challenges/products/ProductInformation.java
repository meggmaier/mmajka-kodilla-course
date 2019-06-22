package com.kodilla.good.patterns.challenges.products;

import java.math.BigDecimal;

public class ProductInformation {

    private String productName;
    private int inStock;
    private BigDecimal price;

    public ProductInformation(String productName, int inStock, BigDecimal price) {
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

    public BigDecimal getPrice() {
        return price;
    }
}
