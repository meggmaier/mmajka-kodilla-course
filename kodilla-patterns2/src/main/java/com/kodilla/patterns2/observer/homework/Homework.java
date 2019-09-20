package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Homework implements Observable {

    private final List<Observer> observers;
    private final List<String> homeworks;
    private final String name;

    public Homework(String name) {
        observers = new ArrayList<>();
        homeworks = new ArrayList<>();
        this.name = name;
    }

    public void addHomework(String post){
        homeworks.add(post);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<String> getHomeworks() {
        return homeworks;
    }

    public String getName() {
        return name;
    }
}
