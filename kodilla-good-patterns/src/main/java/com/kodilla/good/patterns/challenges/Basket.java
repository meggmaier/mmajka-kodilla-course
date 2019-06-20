package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;

public class Basket  {

    List<ProductInformation> basket;

    public Basket(List<ProductInformation> basket) {
        this.basket = basket;
    }

    public List<ProductInformation> getBasket() {
        return basket;
    }

    public List<ProductInformation> putInBasket(ProductInformation productInformation){

            if(productInformation.getQuantityInStock() > 0){

                basket.add(new ProductInformation(productInformation.getProductName(), productInformation.getQuantityInStock(), productInformation.getPrice()));

            } else {
                System.out.println("The product [" + productInformation.getProductName() + "] is out of stock.");
            }
        return basket;
    }

}
