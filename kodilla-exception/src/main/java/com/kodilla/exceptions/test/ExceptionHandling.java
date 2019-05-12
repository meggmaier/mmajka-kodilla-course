package com.kodilla.exceptions.test;

public class ExceptionHandling {

    public static void main(String args[]){
        SecondChallenge challenge = new SecondChallenge();

        try {
            challenge.probablyIWillThrowException(2,5);
        } catch (Exception e){
            System.out.println("Exception occured!");
        } finally {
            System.out.println("...Lucky you if there's no exception.");
        }

    }
}
