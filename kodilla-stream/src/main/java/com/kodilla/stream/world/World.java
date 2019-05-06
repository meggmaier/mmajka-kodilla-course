package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;


public class World {

    private List<Continent> continentList;
    private BigDecimal peopleQuantity;

    public World(List<Continent> continentList) {
        this.continentList = continentList;
    }

    public List<Continent> getContinentList() {
        return continentList;
    }

    public BigDecimal getPeopleQuantity(){

            peopleQuantity = continentList.stream()
                    .flatMap(p -> p.getCountries().stream())
                    .map(Country::getPeopleQuantity)
                    .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
            return peopleQuantity;
        }

    }

