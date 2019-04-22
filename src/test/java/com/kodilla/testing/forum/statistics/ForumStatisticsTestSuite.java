package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ForumStatisticsTestSuite {

    @Test
    public void testCalculateAdvStatistics(){
        //Given zero statistics
        Statistics statisticsZero = mock(Statistics.class);

        ArrayList<String> usersNames = new ArrayList<>();
        when(statisticsZero.usersNames()).thenReturn(usersNames);
        int commentsZero = 0;
        when(statisticsZero.commentsCount()).thenReturn(commentsZero);
        int postsZero = 0;
        when(statisticsZero.postsCount()).thenReturn(postsZero);

        ForumStatistics emptyStatistics = new ForumStatistics();
        Class forumStatisticsClass = ForumStatistics.class;

        //When
        Class zeroClass = emptyStatistics.calculateAdvStatistics(statisticsZero);

        //Then
        Assert.assertEquals(zeroClass, forumStatisticsClass);

        //Given2 posts =1000, users= 100, comments < posts
        Statistics statistics = mock(Statistics.class);
        int posts = 1000;
        when(statistics.postsCount()).thenReturn(posts);
        ArrayList<String> users = new ArrayList<>();
        for (int i = 0; i <= 100; i++){
            users.add(i, "a");
        }
        when(statistics.usersNames()).thenReturn(users);
        int commentsLess = 999;
        when(statistics.commentsCount()).thenReturn(commentsLess);

        ForumStatistics someStatistics = new ForumStatistics();
        Class forumStatistics = ForumStatistics.class;

        //When2
        Class someStatisticsClass = someStatistics.calculateAdvStatistics(statistics);

        //Then2
        Assert.assertEquals(forumStatistics, someStatisticsClass);

        //Given3 comments > posts
        Statistics statistics3 = mock(Statistics.class);
        int posts3 = 1000;
        when(statistics3.postsCount()).thenReturn(posts3);
        ArrayList<String> users3 = new ArrayList<>();
        for (int i = 0; i <= 100; i++){
            users3.add(i, "a");
        }
        when(statistics3.usersNames()).thenReturn(users);
        int commentsMore = 1001;
        when(statistics3.commentsCount()).thenReturn(commentsMore);

        ForumStatistics newStatistics = new ForumStatistics();
        Class forumStatisticsClass3 = ForumStatistics.class;

        //When3
        Class newForumStatistics = newStatistics.calculateAdvStatistics(statistics);

        //Then3
        Assert.assertEquals(forumStatisticsClass3, newForumStatistics);
    }
}
