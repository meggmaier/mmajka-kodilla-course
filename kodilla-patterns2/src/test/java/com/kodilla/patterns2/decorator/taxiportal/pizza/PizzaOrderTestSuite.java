package com.kodilla.patterns2.decorator.taxiportal.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {

    @Test
    public void getCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new MushroomDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(25), theCost);
    }

    @Test
    public void getDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new MushroomDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and mozzarella cheese + salami + mushrooms + extra cheese", description);

    }
}