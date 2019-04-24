package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ForumStatisticsTestSuite {

    @Test
    public void testCalculateAdvStatisticsZeroStatistics() {
        //Given zero statistics
        Statistics statisticsZero = mock(Statistics.class);

        ArrayList<String> usersNames = new ArrayList<>();
        when(statisticsZero.usersNames()).thenReturn(usersNames);

        int commentsZero = 0;
        when(statisticsZero.commentsCount()).thenReturn(commentsZero);

        int postsZero = 0;
        when(statisticsZero.postsCount()).thenReturn(postsZero);

        ForumStatistics emptyStatistics = new ForumStatistics();

        //When
        emptyStatistics.calculateAdvStatistics(statisticsZero);

        //Then
        Assert.assertEquals(emptyStatistics.getUsers(), 0);
        Assert.assertEquals(emptyStatistics.getComments(), 0);
        Assert.assertEquals(emptyStatistics.getPosts(), 0);

        Assert.assertEquals(emptyStatistics.getPostToUsersAverage(), 0, 0);
        Assert.assertEquals(emptyStatistics.getCommentsToUsersAverage(), 0, 0);
        Assert.assertEquals(emptyStatistics.getCommentsToPostsAverage(), 0, 0);
    }
    @Test
    public void testCalculateAdvStatisticsLessComments() {
        //Given posts =1000, users= 100, comments < posts
        Statistics statistics = mock(Statistics.class);
        int posts = 1000;
        when(statistics.postsCount()).thenReturn(posts);
        ArrayList<String> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            users.add(i, "a");
        }
        when(statistics.usersNames()).thenReturn(users);
        int commentsLess = 500;
        when(statistics.commentsCount()).thenReturn(commentsLess);

        ForumStatistics someStatistics = new ForumStatistics();


        //When
        someStatistics.calculateAdvStatistics(statistics);

        //Then
        Assert.assertEquals(someStatistics.getUsers(), 100);
        Assert.assertEquals(someStatistics.getComments(), 500);
        Assert.assertEquals(someStatistics.getPosts(), 1000);

        Assert.assertEquals(someStatistics.getPostToUsersAverage(), 10, 0);
        Assert.assertEquals(someStatistics.getCommentsToUsersAverage(), 5, 0);
        Assert.assertEquals(someStatistics.getCommentsToPostsAverage(), 0.5, 0);
    }
    @Test
    public void testCalculateAdvStatisticsMoreComments(){
        //Given comments > posts
        Statistics statistics3 = mock(Statistics.class);
        int posts3 = 1000;
        when(statistics3.postsCount()).thenReturn(posts3);
        ArrayList<String> users3 = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            users3.add(i, "a");
        }
        when(statistics3.usersNames()).thenReturn(users3);
        int commentsMore = 2000;
        when(statistics3.commentsCount()).thenReturn(commentsMore);

        ForumStatistics newStatistics = new ForumStatistics();

        //When
        newStatistics.calculateAdvStatistics(statistics3);

        //Then
        Assert.assertEquals(newStatistics.getUsers(), 100);
        Assert.assertEquals(newStatistics.getComments(), 2000);
        Assert.assertEquals(newStatistics.getPosts(), 1000);

        Assert.assertEquals(newStatistics.getPostToUsersAverage(), 10, 0);
        Assert.assertEquals(newStatistics.getCommentsToUsersAverage(), 20, 0);
        Assert.assertEquals(newStatistics.getCommentsToPostsAverage(), 2, 0);
    }
}
