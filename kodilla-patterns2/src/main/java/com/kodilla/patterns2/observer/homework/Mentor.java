package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer{

    private final String name;
    private int homeworkCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(Homework homework) {
        int size = homework.getHomeworks().size();
        String homeworks;

        if (size == 1){
            homeworks = "homework";
        } else {
            homeworks = "homeworks";
        }


        System.out.println(name + ": New homework to review: " + homework.getName() +
                "\n" + " (total: " + size + " " + homeworks + " in queue)");
        homeworkCount++;
    }

    public String getName() {
        return name;
    }

    public int getHomeworkCount() {
        return homeworkCount;
    }
}
