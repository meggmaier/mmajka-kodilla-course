package com.kodilla.good.patterns.challenges.products;

import java.util.List;

public class Basket  {

    private List<ProductInformation> basket;

    public Basket(List<ProductInformation> basket) {
        this.basket = basket;
    }

    public List<ProductInformation> getBasket() {
        return basket;
    }

    public List<ProductInformation> putInBasket(ProductInformation productInformation){

            if(productInformation.getQuantityInStock() > 0){

                basket.add(productInformation);

            } else {
                System.out.println("The product [" + productInformation.getProductName() + "] is out of stock.");
            }
        return basket;
    }

}
