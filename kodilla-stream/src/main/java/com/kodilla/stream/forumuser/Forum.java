package com.kodilla.stream.forumuser;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum(){
        theUserList.add(new ForumUser(10001, "user1",'M', LocalDate.of(1990,1,1), 22));
        theUserList.add(new ForumUser(10002, "user2",'F', LocalDate.of(1991,8,12), 32));
        theUserList.add(new ForumUser(10003, "user3",'M', LocalDate.of(1992,7,13), 0));
        theUserList.add(new ForumUser(10004, "user4",'F', LocalDate.of(1993,6,14), 42));
        theUserList.add(new ForumUser(10005, "user5",'M', LocalDate.of(1994,5,15), 2));
    }

    public List<ForumUser> getUserList(){
        return new ArrayList<>(theUserList);
    }
}
