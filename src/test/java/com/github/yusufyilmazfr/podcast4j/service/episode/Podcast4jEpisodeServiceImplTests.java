package com.github.yusufyilmazfr.podcast4j.service.episode;

import com.github.yusufyilmazfr.podcast4j.arg.service.episode.ByFeedIdArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.episode.ByFeedURLArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.episode.ByIdArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.episode.ByiTunesArg;
import com.github.yusufyilmazfr.podcast4j.constant.TestConfig;
import com.github.yusufyilmazfr.podcast4j.entity.Episode;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.*;
import static org.junit.Assert.*;

public class Podcast4jEpisodeServiceImplTests {

    private final Podcast4jServiceFactory serviceFactory;

    public Podcast4jEpisodeServiceImplTests() {
        serviceFactory = Podcast4jServiceFactory.with(TestConfig::getTestConfig);
    }

    @Test
    public void getEpisodesByFeedId_shouldReturnMatchedEpisodes() throws IOException, URISyntaxException, InterruptedException {
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
    public void getEpisodesByFeedURL_shouldReturnMatchedEpisodes() throws IOException, URISyntaxException, InterruptedException {
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
    public void getEpisodesByiTunesId_shouldReturnMatchedEpisodes() throws IOException, URISyntaxException, InterruptedException {
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
    public void getEpisodeById_shouldReturnMatchedEpisodes() throws IOException, URISyntaxException, InterruptedException {
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
    public void getLiveEpisodes_shouldReturnMatchedEpisodes() throws IOException, URISyntaxException, InterruptedException {
        // Arrange
        Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

        // Actual
        List<Episode> episodes = episodeService.getLiveEpisodes(5);

        // Assert
        assertNotNull(episodes);
        assertNotEquals(0, episodes.size());
    }
}
