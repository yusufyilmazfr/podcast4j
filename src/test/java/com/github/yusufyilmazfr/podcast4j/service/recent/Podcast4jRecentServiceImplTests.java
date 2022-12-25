package com.github.yusufyilmazfr.podcast4j.service.recent;

import com.github.yusufyilmazfr.podcast4j.arg.service.recent.EpisodesArg;
import com.github.yusufyilmazfr.podcast4j.constant.TestConfig;
import com.github.yusufyilmazfr.podcast4j.entity.Episode;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.*;

public class Podcast4jRecentServiceImplTests {
    private final Podcast4jServiceFactory serviceFactory;

    public Podcast4jRecentServiceImplTests() {
        serviceFactory = Podcast4jServiceFactory.with(TestConfig::getTestConfig);
    }

    @Test
    public void getEpisodes_shouldReturnMatchedRecentEpisodes() throws URISyntaxException, IOException, InterruptedException {
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
