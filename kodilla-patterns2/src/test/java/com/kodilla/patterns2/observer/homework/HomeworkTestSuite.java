package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeworkTestSuite {

    @Test
    public void testHomeworkCount(){
        //Given
        Mentor adam = new Mentor("Adam");
        Mentor marek = new Mentor("Marek");

        Homework juliaQueue = new Homework("Julia's Homework");
        Homework bartekQueue = new Homework("Bartek's Homework");
        Homework olaQueue = new Homework("Ola's Homework");
        Homework tomekQueue = new Homework("Tomek's Homework");

        juliaQueue.registerObserver(adam);
        bartekQueue.registerObserver(marek);
        olaQueue.registerObserver(marek);
        tomekQueue.registerObserver(marek);

        //When
        juliaQueue.addHomework("Stream & lambda expression");
        juliaQueue.addHomework("Good patterns");

        bartekQueue.addHomework("Loops");

        olaQueue.addHomework("Exceptions");
        olaQueue.addHomework("Named Queries");
        olaQueue.addHomework("mySQL databases");

        tomekQueue.addHomework("Spring");
        tomekQueue.addHomework("Hibernate");

        //Then
        assertEquals(2, adam.getHomeworkCount());
        assertEquals(6, marek.getHomeworkCount());
    }
}
