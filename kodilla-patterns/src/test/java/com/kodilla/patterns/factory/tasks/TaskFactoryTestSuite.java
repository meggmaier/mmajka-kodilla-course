package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryShoppingTask(){

        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPING_TASK);
        shoppingTask.executeTask();

        //Then
        Assert.assertEquals("Shopping Task", shoppingTask.getTaskName());
        Assert.assertEquals(true, shoppingTask.isTaskExecuted());
    }

    @Test
    public void testFactoryDrivingTask(){

        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.DRIVING_TASK);

        //Then
        Assert.assertEquals("Driving Task", shoppingTask.getTaskName());
    }

    @Test
    public void testFactoryPaintingTask(){

        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.PAINTING_TASK);

        //Then
        Assert.assertEquals("Painting Task", shoppingTask.getTaskName());
    }
}
