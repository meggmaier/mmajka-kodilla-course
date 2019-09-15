package com.kodilla.patterns2.decorator.taxiportal.pizza;

import java.math.BigDecimal;

public class MushroomDecorator extends AbstractPizzaOrderDecorator {

    public MushroomDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + mushrooms";
    }
}
