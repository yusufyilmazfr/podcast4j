package com.github.yusufyilmazfr.podcast4j.service.episode;

import com.github.yusufyilmazfr.podcast4j.arg.service.episode.*;
import com.github.yusufyilmazfr.podcast4j.constant.TestConfig;
import com.github.yusufyilmazfr.podcast4j.entity.Episode;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.*;
import static org.junit.Assert.*;

public class Podcast4jEpisodeServiceImplTests {

    private final Podcast4jServiceFactory serviceFactory;

    public Podcast4jEpisodeServiceImplTests() {
        serviceFactory = Podcast4jServiceFactory.with(TestConfig::getTestConfig);
    }

    @Test
    public void getEpisodesByFeedId_shouldReturnMatchedEpisodes() throws IOException, InterruptedException {
        // Arrange
        Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

        ByFeedIdArg arg = ByFeedIdArg.builder()
                                     .id(CODEFICTION_FEED_ID)
                                     .max(10)
                                     .build();

        // Actual
        List<Episode> episodes = episodeService.getEpisodesByFeedId(arg);

        // Assert
        assertNotNull(episodes);
        assertEquals(10, episodes.size());
        assertEquals(CODEFICTION_FEED_ID, episodes.get(0).getFeedId());
    }

    @Test
    public void getEpisodesByFeedURL_shouldReturnMatchedEpisodes() throws IOException, InterruptedException {
        // Arrange
        Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

        ByFeedURLArg arg = ByFeedURLArg.builder()
                                       .url(CODEFICTION_FEED_URL)
                                       .max(10)
                                       .build();

        // Actual
        List<Episode> episodes = episodeService.getEpisodesByFeedURL(arg);

        // Assert
        assertNotNull(episodes);
        assertEquals(10, episodes.size());
        assertEquals(CODEFICTION_FEED_ID, episodes.get(0).getFeedId());
    }

    @Test
    public void getEpisodesByiTunesId_shouldReturnMatchedEpisodes() throws IOException, InterruptedException {
        // Arrange
        Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

        ByiTunesArg arg = ByiTunesArg.builder()
                                     .id(CODEFICTION_iTUNES_ID)
                                     .max(10)
                                     .build();

        // Actual
        List<Episode> episodes = episodeService.getEpisodesByiTunesId(arg);

        // Assert
        assertNotNull(episodes);
        assertEquals(10, episodes.size());
        assertEquals(CODEFICTION_FEED_ID, episodes.get(0).getFeedId());
    }

    @Test
    public void getEpisodeById_shouldReturnMatchedEpisodes() throws IOException, InterruptedException {
        // Arrange
        Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

        ByIdArg arg = ByIdArg.builder()
                             .id(CODEFICTION_EPISODE_ID)
                             .fulltext(Boolean.TRUE)
                             .build();

        // Actual
        Episode episode = episodeService.getEpisodeById(arg);

        // Assert
        assertNotNull(episode);
        assertEquals(CODEFICTION_FEED_ID, episode.getFeedId());
    }

    @Test
    public void getLiveEpisodes_shouldReturnMatchedEpisodes() throws IOException, InterruptedException {
        // Arrange
        Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

        // Actual
        List<Episode> episodes = episodeService.getLiveEpisodes(5);

        // Assert
        assertNotNull(episodes);
        assertNotEquals(0, episodes.size());
    }

    @Test
    public void getRandomEpisodes_shouldReturnMatchedEpisodes() throws IOException, InterruptedException {
        // Arrange
        Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

        String category = "Technology";
        String language = "tr";

        RandomEpisodesArg arg = RandomEpisodesArg.builder()
                                                 .lang(language)
                                                 .cat(category)
                                                 .max(5)
                                                 .build();

        // Actual
        List<Episode> episodes = episodeService.getRandomEpisodes(arg);
        Episode episode = episodes.get(0);

        // Assert
        assertEquals(language, episode.getFeedLanguage());
        assertTrue(episode.getCategories().containsValue(category));
    }
}
