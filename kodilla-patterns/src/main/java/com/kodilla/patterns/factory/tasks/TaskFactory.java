package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING_TASK = "SHOPPING TASK";
    public static final String DRIVING_TASK = "DRIVING TASK";
    public static final String PAINTING_TASK = "PAINTING TASK";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping Task", "milk", 1);
            case DRIVING_TASK:
                return new DrivingTask("Driving Task", "Radom", "Bicycle");
            case PAINTING_TASK:
                return new PaintingTask("Painting Task", "Blue", "Carrot");
            default:
                return null;
        }

    }
}
