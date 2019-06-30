package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task{

    private String taskName;
    private boolean taskExecuted;

    DrivingTask(String taskName, String where, String using){
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
