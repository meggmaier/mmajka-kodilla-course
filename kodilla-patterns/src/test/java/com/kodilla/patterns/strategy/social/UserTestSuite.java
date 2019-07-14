package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies(){

        //Given
        User jeronimo = new Millenials("Jeronimo Martins");
        User walt = new YGeneration("Walt Disney");
        User august = new ZGeneration("August Storck");

        //When
        String jeronimoSocial = jeronimo.sharePost();
        System.out.println("Jeronimo is a " + jeronimoSocial);
        String waltSocial = walt.sharePost();
        System.out.println("Walt is a " + waltSocial);
        String augustSocial = august.sharePost();
        System.out.println("August is a " + augustSocial);

        //Then
        Assert.assertEquals("Facebook publisher.", jeronimoSocial);
        Assert.assertEquals("Twitter publisher.", waltSocial);
        Assert.assertEquals("Snapchat publisher.", augustSocial);
    }

    @Test
    public void testIndividualSharingStrategy(){

        //Given
        User jeronimo = new Millenials("Jeronimo Martins");

        //When
        String jeronimoSocial = jeronimo.sharePost();
        System.out.println("Jeronimo was a " + jeronimoSocial);
        jeronimo.setSharing(new SnapchatPublisher());
        jeronimoSocial = jeronimo.sharePost();
        System.out.println("Now Jeronimo is a " + jeronimoSocial);

        //Then
        Assert.assertEquals("Snapchat publisher.", jeronimoSocial);
    }
}
