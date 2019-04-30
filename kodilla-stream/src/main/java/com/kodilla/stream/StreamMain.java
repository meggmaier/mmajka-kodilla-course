package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, ForumUser> filteredList =
        forum.getUserList().stream()
                .filter(s -> s.getSex() == 'M')
                .filter(a -> a.getDateOfBirth().getYear() < 1999 )
                .filter(p -> p.getNumberOfPublishedPosts() > 1)
                .collect(Collectors.toMap(ForumUser::getUserID, user -> user));

        filteredList.entrySet().stream()
                .map (entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);




    }
}
