package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers){

        OptionalDouble numbersAverage
                = IntStream.range(0, numbers.length)
                            .map(i -> numbers[i])
                            .average();
        return numbersAverage.getAsDouble();

    }
}
