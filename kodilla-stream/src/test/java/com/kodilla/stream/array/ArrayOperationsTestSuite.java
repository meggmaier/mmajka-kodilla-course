package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;


public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){
        //Given
        int[] array = new int []{1,23,456,7891,9,87,654,3,2};

        //When
        double arrayAverage = ArrayOperations.getAverage(array);

        //Then
        Assert.assertEquals(1014, arrayAverage, 0);
    }
}
