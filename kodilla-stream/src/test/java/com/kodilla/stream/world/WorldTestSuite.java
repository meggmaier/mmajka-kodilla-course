package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){
        //Given
        //1st list of countries
        List<Country> asiaCountries = new ArrayList<>();
        asiaCountries.add(new Country("Japan", new BigDecimal("126906009")));
        asiaCountries.add(new Country("China", new BigDecimal("1419271223")));
        asiaCountries.add(new Country("India", new BigDecimal("1366377599")));

        //2nd list of countries
        List<Country> europeCountries = new ArrayList<>();
        europeCountries.add(new Country("Russia", new BigDecimal("143964709")));
        europeCountries.add(new Country("Germany", new BigDecimal("82293457")));
        europeCountries.add(new Country("Turkey", new BigDecimal("81916871")));
        europeCountries.add(new Country("United Kingdom", new BigDecimal("66573504")));

        //3rd list of countries
        List<Country> africaCountries = new ArrayList<>();
        africaCountries.add(new Country("Nigeria", new BigDecimal("181563000")));
        africaCountries.add(new Country("Ethopia", new BigDecimal("103764000")));
        africaCountries.add(new Country("Egypt", new BigDecimal("89125000")));
        africaCountries.add(new Country("Democratic Republic of the Congo", new BigDecimal("77267000")));

        //world list
        List<Continent> world = new ArrayList<>();
        world.add(new Continent("Asia", asiaCountries));
        world.add(new Continent("Europe", europeCountries));
        world.add(new Continent("Africa", africaCountries));

        World worldPopulation = new World(world);

        //When
        BigDecimal totalPopulation = worldPopulation.getPeopleQuantity();

        //Then
        BigDecimal expectedPopulation = new BigDecimal("3739022372");
        Assert.assertEquals(expectedPopulation, totalPopulation);
    }

}
