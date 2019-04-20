package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    public Class calculateAdvStatistics(Statistics statistics){
        int users = statistics.usersNames().size();
        int posts = statistics.postsCount();
        int comments = statistics.commentsCount();

        double postToUsersAverage = posts/users;
        double commentsToUsersAverage = comments/users;
        double commentsToPostsAverage = comments/posts;

        return ForumStatistics.class;
    }

    public void showStatistics(){

    }

}
