package com.kodilla.exceptions.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {

        try {
            return a/b;

        } catch (ArithmeticException e){

            System.out.println("Whoopsie, you've tried diving by zero, so it'll be zero! " + e);

        } finally {

            System.out.println("Tip: Dividing by zero gives zero.");

        }

            return a/b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        double result = firstChallenge.divide(3, 0);

        System.out.println(result);

    }
}
