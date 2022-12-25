package com.github.yusufyilmazfr.podcast4j.service.podcast;

import com.github.yusufyilmazfr.podcast4j.arg.service.podcast.TrendPodcastsArg;
import com.github.yusufyilmazfr.podcast4j.constant.TestConfig;
import com.github.yusufyilmazfr.podcast4j.entity.DeadPodcast;
import com.github.yusufyilmazfr.podcast4j.entity.Podcast;
import com.github.yusufyilmazfr.podcast4j.entity.TrendPodcast;
import com.github.yusufyilmazfr.podcast4j.enums.MediumType;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.*;
import static org.junit.Assert.*;

public class Podcast4jPodcastServiceImplTests {
    private final Podcast4jServiceFactory serviceFactory;

    public Podcast4jPodcastServiceImplTests() {
        serviceFactory = Podcast4jServiceFactory.with(TestConfig::getTestConfig);
    }

    @Test
    public void getPodcastByFeedId_shouldReturnMatchedPodcast() throws IOException, InterruptedException {
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
    public void getPodcastByFeedURL_shouldReturnMatchedPodcast() throws IOException, InterruptedException {
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
    public void getPodcastByGUID_shouldReturnMatchedPodcast() throws IOException, InterruptedException {
        // Arrange
        Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

        // Actual
        Podcast podcast = podcastService.getPodcastByGUID(CODEFICTION_GUID_ID);

        // Assert
        assertNotNull(podcast);
        assertEquals(CODEFICTION_PODCAST_TITLE, podcast.getTitle());
        assertEquals(CODEFICTION_FEED_URL, podcast.getUrl().toString());
        assertEquals(CODEFICTION_iTUNES_ID, podcast.getItunesId());
    }

    @Test
    public void getPodcastByiTunesID_shouldReturnMatchedPodcast() throws IOException, InterruptedException {
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

    @Test
    public void getPodcastsByMedium_shouldReturnMatchedPodcast() throws IOException, InterruptedException {
        // Arrange
        Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

        // Actual
        List<Podcast> podcasts = podcastService.getPodcastsByMedium(MediumType.MUSIC);

        // Assert
        assertNotNull(podcasts);
    }

    @Test
    public void getTrendPodcasts_shouldReturnMatchedPodcast() throws IOException, InterruptedException {
        // Arrange
        Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

        int expectedMaxCount = 5;
        String expectedLanguage = "en";
        String expectedCategory = "News";
        String expectedNotInCategory = "Entertainment";


        TrendPodcastsArg arg = TrendPodcastsArg.builder()
                                               .lang("en")
                                               .cat("News")
                                               .notCat("Entertainment")
                                               .max(5)
                                               .build();

        // Actual
        List<TrendPodcast> trendPodcasts = podcastService.getTrendPodcasts(arg);
        TrendPodcast firstTrendPodcast = trendPodcasts.get(0);

        // Assert
        assertEquals(expectedMaxCount, trendPodcasts.size());
        assertEquals(expectedLanguage, firstTrendPodcast.getLanguage());
        assertTrue(firstTrendPodcast.getCategories().containsValue(expectedCategory));
        assertFalse(firstTrendPodcast.getCategories().containsValue(expectedNotInCategory));
    }

    @Test
    public void getDeadPodcasts_shouldReturnMatchedPodcast() throws IOException, InterruptedException {
        // Arrange
        Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

        // Actual
        List<DeadPodcast> deadPodcasts = podcastService.getDeadPodcasts();

        // Assert
        assertNotNull(deadPodcasts);
    }
}
