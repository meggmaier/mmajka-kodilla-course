package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;

public class Continent {

    private String name;
    private List<Country> countryList;


    public Continent(String name, List<Country> countryList) {
        this.name = name;
        this.countryList = countryList;
    }

    public List<Country> getCountries(){
        return countryList;
        }
    }


