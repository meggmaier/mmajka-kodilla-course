package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {

    private String name;
    private BigDecimal peopleQuantity;

    public Country(String name, BigDecimal peopleQuantity) {
        this.name = name;
        this.peopleQuantity = peopleQuantity;
    }

    BigDecimal getPeopleQuantity(){
        return peopleQuantity;
    }
}
