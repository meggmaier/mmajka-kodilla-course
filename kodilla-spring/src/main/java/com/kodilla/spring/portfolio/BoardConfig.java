package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("to do")
    private TaskList toDoList;
    @Autowired
    @Qualifier("in progress")
    private TaskList inProgressList;
    @Autowired
    @Qualifier("done")
    private TaskList doneList;

    @Bean
    public Board getBoard(){
        return new Board(toDoList, inProgressList, doneList);
    }

    @Bean (name = "to do")
    public TaskList getToDoList() {

        System.out.println("This is the To Do List");
        return new TaskList();
    }

    @Bean (name = "in progress")
    public TaskList getInProgressList() {

        System.out.println("This is the In Progress List");
        return new TaskList();
    }

    @Bean (name = "done")
    public TaskList getDoneList() {

        System.out.println("This is the Done List");
        return new TaskList();
    }
}
