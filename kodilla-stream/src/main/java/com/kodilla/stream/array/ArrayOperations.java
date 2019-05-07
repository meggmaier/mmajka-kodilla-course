package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers){
        int first = numbers[0];
        int last = numbers[numbers.length-1];
        IntStream.range(first, last)
                .toArray();

        OptionalDouble numbersAverage
                = IntStream.range(first, last)
                            .average();
        return numbersAverage.getAsDouble();

    }
}
