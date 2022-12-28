package com.github.yusufyilmazfr.podcast4j.service.recent;

import com.github.yusufyilmazfr.podcast4j.arg.service.recent.EpisodesArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.FeedsArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.NewFeedsArg;
import com.github.yusufyilmazfr.podcast4j.constant.TestConfig;
import com.github.yusufyilmazfr.podcast4j.entity.Episode;
import com.github.yusufyilmazfr.podcast4j.entity.Feed;
import com.github.yusufyilmazfr.podcast4j.entity.NewFeed;
import com.github.yusufyilmazfr.podcast4j.entity.SoundBite;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class Podcast4jRecentServiceImplTests {
    private final Podcast4jServiceFactory serviceFactory;

    public Podcast4jRecentServiceImplTests() {
        serviceFactory = Podcast4jServiceFactory.with(TestConfig::getTestConfig);
    }

    @Test
    public void getFeeds_shouldReturnMatchedFeeds() throws IOException, InterruptedException {
        // Arrange
        Podcast4jRecentService recentService = serviceFactory.getRecentService();

        FeedsArg arg = FeedsArg.builder()
                               .max(1)
                               .lang("tr")
                               .cat("technology")
                               .build();

        // Actual
        List<Feed> feeds = recentService.getFeeds(arg);

        // Assert
        assertNotNull(feeds);
        assertEquals(1, feeds.size());
        assertEquals("tr", feeds.get(0).getLanguage());
    }

    @Test
    public void getNewFeeds_shouldReturnMatchedNewFeeds() throws IOException, InterruptedException {
        // Arrange
        Podcast4jRecentService recentService = serviceFactory.getRecentService();

        NewFeedsArg arg = NewFeedsArg.builder()
                                     .max(1)
                                     .build();

        // Actual
        List<NewFeed> feeds = recentService.getNewFeeds(arg);

        // Assert
        assertNotNull(feeds);
        assertEquals(1, feeds.size());
    }

    @Test
    public void getSoundBites_shouldReturnMatchedSoundBites() throws IOException, InterruptedException {
        // Arrange
        Podcast4jRecentService recentService = serviceFactory.getRecentService();
        int expectedSize = 5;

        // Actual
        List<SoundBite> soundBites = recentService.getSoundBites(expectedSize);

        // Assert
        assertNotNull(soundBites);
        assertEquals(expectedSize, soundBites.size());
    }

    @Test
    public void getEpisodes_shouldReturnMatchedRecentEpisodes() throws IOException, InterruptedException {
        // Arrange
        Podcast4jRecentService recentService = serviceFactory.getRecentService();
        String excludedWord = "MP3";

        EpisodesArg arg = EpisodesArg.builder()
                                     .max(5)
                                     .excludeString(excludedWord)
                                     .build();

        // Actual
        List<Episode> episodes = recentService.getEpisodes(arg);

        // Assert
        assertNotNull(episodes);
        assertEquals(5, episodes.size());
        assertFalse(episodes.stream().anyMatch(episode -> episode.getDescription().contains(excludedWord)));
    }
}
