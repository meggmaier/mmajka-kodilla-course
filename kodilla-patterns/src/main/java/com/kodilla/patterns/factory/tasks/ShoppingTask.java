package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task{

    private String taskName;
    private boolean taskExecuted;

    ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.taskExecuted = false;
    }

    @Override
    public void executeTask() {
        System.out.println(taskName + " in progress.");
        taskExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if (taskExecuted) {
            System.out.println(taskName + " is executed.");
            return true;
        }
        System.out.println(taskName + "is still not executed.");
        return false;
    }
}
