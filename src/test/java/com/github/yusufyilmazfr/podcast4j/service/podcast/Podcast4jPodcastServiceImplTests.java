package com.github.yusufyilmazfr.podcast4j.service.podcast;

import com.github.yusufyilmazfr.podcast4j.constant.TestConfig;
import com.github.yusufyilmazfr.podcast4j.entity.Podcast;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Podcast4jPodcastServiceImplTests {
    private final Podcast4jServiceFactory serviceFactory;

    public Podcast4jPodcastServiceImplTests() {
        serviceFactory = Podcast4jServiceFactory.with(TestConfig::getTestConfig);
    }

    @Test
    public void getPodcastByFeedId_shouldReturnMatchedPodcast() throws URISyntaxException, IOException, InterruptedException {
        // Arrange
        Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

        // Actual
        Podcast podcast = podcastService.getPodcastByFeedId(CODEFICTION_FEED_ID);

        // Assert
        assertNotNull(podcast);
        assertEquals(CODEFICTION_PODCAST_TITLE, podcast.getTitle());
        assertEquals(CODEFICTION_iTUNES_ID, podcast.getItunesId());
    }

    @Test
    public void getPodcastByFeedURL_shouldReturnMatchedPodcast() throws URISyntaxException, IOException, InterruptedException {
        // Arrange
        Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

        // Actual
        Podcast podcast = podcastService.getPodcastByFeedURL(CODEFICTION_FEED_URL);

        // Assert
        assertNotNull(podcast);
        assertEquals(CODEFICTION_PODCAST_TITLE, podcast.getTitle());
        assertEquals(CODEFICTION_FEED_URL, podcast.getUrl().toString());
        assertEquals(CODEFICTION_iTUNES_ID, podcast.getItunesId());
    }

    @Test
    public void getPodcastByiTunesID_shouldReturnMatchedPodcast() throws URISyntaxException, IOException, InterruptedException {
        // Arrange
        Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

        // Actual
        Podcast podcast = podcastService.getPodcastByiTunesID(CODEFICTION_iTUNES_ID);

        // Assert
        assertNotNull(podcast);
        assertEquals(CODEFICTION_PODCAST_TITLE, podcast.getTitle());
        assertEquals(CODEFICTION_FEED_URL, podcast.getUrl().toString());
        assertEquals(CODEFICTION_iTUNES_ID, podcast.getItunesId());
    }
}
