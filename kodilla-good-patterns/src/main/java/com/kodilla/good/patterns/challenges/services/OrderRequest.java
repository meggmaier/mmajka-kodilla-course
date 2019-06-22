package com.kodilla.good.patterns.challenges.services;

import com.kodilla.good.patterns.challenges.products.ProductInformation;

import java.util.List;

public class OrderRequest implements ProductOrder {

    List<ProductInformation> listOfProducts;

    public OrderRequest(List<ProductInformation> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    @Override
    public void order() {

        if (!listOfProducts.isEmpty()) {
            for (ProductInformation product : listOfProducts) {
                System.out.println("You've just ordered [" + product.getProductName() + "] for " + product.getPrice() + ".");

            }
        }
    }
}
