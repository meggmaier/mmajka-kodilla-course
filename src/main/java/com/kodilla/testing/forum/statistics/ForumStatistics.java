package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    private int users;
    private int posts;
    private int comments;
    private double postToUsersAverage;
    private double commentsToUsersAverage;
    private double commentsToPostsAverage;

    public void calculateAdvStatistics(Statistics statistics){
        users = statistics.usersNames().size();
        posts = statistics.postsCount();
        comments = statistics.commentsCount();

        if (users != 0) {
            postToUsersAverage = (double)posts / users;
        } else {
            postToUsersAverage = 0;
        }

         if (users != 0) {
             commentsToUsersAverage = (double)comments / users;
         } else {
             commentsToUsersAverage = 0;
         }

         if (posts != 0){
            commentsToPostsAverage = (double)comments / posts;
        } else {
            commentsToPostsAverage = 0;
        }
    }

    public int getUsers() {
        return users;
    }

    public int getPosts() {
        return posts;
    }

    public int getComments() {
        return comments;
    }

    public double getPostToUsersAverage() {
        return postToUsersAverage;
    }

    public double getCommentsToUsersAverage() {
        return commentsToUsersAverage;
    }

    public double getCommentsToPostsAverage() {
        return commentsToPostsAverage;
    }

    public void showStatistics(){
    }

}
