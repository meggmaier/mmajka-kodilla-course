package com.kodilla.testing.forum.statistics;

public class ForumStatistics {


    public Class calculateAdvStatistics(Statistics statistics){
        int users = statistics.usersNames().size();
        int posts = statistics.postsCount();
        int comments = statistics.commentsCount();

        if (users != 0 && posts > users ) {
            double postToUsersAverage = posts / users;
        } else { double postToUsersAverage = 0;}

         if (users != 0 && comments > users) {
             double commentsToUsersAverage = comments / users;
         } else { double commentsToUsersAverage = 0;}

         if (posts != 0 && comments > posts){
            double commentsToPostsAverage = comments / posts;
        } else {
            double commentsToPostsAverage = 0;
        }

        return ForumStatistics.class;
    }

    public void showStatistics(){
        System.out.println(ForumStatistics.class);    }

}
