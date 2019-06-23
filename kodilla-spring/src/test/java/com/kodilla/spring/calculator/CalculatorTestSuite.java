package com.kodilla.spring.calculator;

import com.kodilla.spring.library.Library;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CalculatorTestSuite {

    @Test
    public void testCalculations(){

        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        double a = 10;
        double b = 2;

        //When
        double total = calculator.add(a, b);
        double difference = calculator.sub(a, b);
        double product = calculator.mul(a, b);
        double quotient = calculator.div(a, b);

        //Then
        Assert.assertEquals(12, total, 0);
        Assert.assertEquals(8, difference, 0);
        Assert.assertEquals(20, product, 0);
        Assert.assertEquals(5, quotient, 0);
    }

}
