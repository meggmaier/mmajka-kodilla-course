package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigmac() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("plain")
                .burgers(1)
                .sauce(Sauces.THOUSAND_ISLAND_DRESSING)
                .ingredient(Ingredients.LETTUCE)
                .ingredient(Ingredients.BECON)
                .ingredient(Ingredients.ONION)
                .ingredient(Ingredients.CHEESE)
                .build();

        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();

        //Then
        Assert.assertEquals(4, howManyIngredients);
    }
}
