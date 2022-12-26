package com.github.yusufyilmazfr.podcast4j.service.hub;

import com.github.yusufyilmazfr.podcast4j.constant.TestConfig;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import org.junit.Test;

import java.io.IOException;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_FEED_ID;
import static com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_FEED_URL;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Podcast4jHubServiceImplTests {
    private final Podcast4jServiceFactory serviceFactory;

    public Podcast4jHubServiceImplTests() {
        serviceFactory = Podcast4jServiceFactory.with(TestConfig::getTestConfig);
    }

    @Test
    public void notifyByFeedId_returnFalse_whenFeedIdIsNull() throws IOException, InterruptedException {
        // Arrange
        Integer feedId = null;
        Podcast4jHubService hubService = serviceFactory.getHubService();

        // Actual
        boolean actualResponse = hubService.notifyByFeedId(feedId);

        // Assert
        assertFalse(actualResponse);
    }

    @Test
    public void notifyByFeedId_returnTrue_whenFeedIdIsValid() throws IOException, InterruptedException {
        // Arrange
        Podcast4jHubService hubService = serviceFactory.getHubService();

        // Actual
        boolean actualResponse = hubService.notifyByFeedId(CODEFICTION_FEED_ID);

        // Assert
        assertTrue(actualResponse);
    }

    @Test
    public void notifyByFeedURL_returnFalse_whenFeedURLIsNull() throws IOException, InterruptedException {
        // Arrange
        String feedURL = null;
        Podcast4jHubService hubService = serviceFactory.getHubService();

        // Actual
        boolean actualResponse = hubService.notifyByFeedURL(feedURL);

        // Assert
        assertFalse(actualResponse);
    }

    @Test
    public void notifyByFeedURL_returnTrue_whenFeedURLIsValid() throws IOException, InterruptedException {
        // Arrange
        Podcast4jHubService hubService = serviceFactory.getHubService();

        // Actual
        boolean actualResponse = hubService.notifyByFeedURL(CODEFICTION_FEED_URL);

        // Assert
        assertTrue(actualResponse);
    }
}
