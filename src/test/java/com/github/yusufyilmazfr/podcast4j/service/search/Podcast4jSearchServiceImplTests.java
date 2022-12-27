package com.github.yusufyilmazfr.podcast4j.service.search;

import com.github.yusufyilmazfr.podcast4j.arg.service.search.SearchPodcastsByTermArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.search.SearchPodcastsByTitleArg;
import com.github.yusufyilmazfr.podcast4j.constant.TestConfig;
import com.github.yusufyilmazfr.podcast4j.entity.Podcast;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_PODCAST_TITLE;
import static com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_iTUNES_ID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Podcast4jSearchServiceImplTests {
    private final Podcast4jServiceFactory serviceFactory;

    public Podcast4jSearchServiceImplTests() {
        serviceFactory = Podcast4jServiceFactory.with(TestConfig::getTestConfig);
    }

    @Test
    public void searchPodcastsByTerm_shouldReturnMatchedPodcasts() throws IOException, InterruptedException {
        // Arrange
        Podcast4jSearchService searchService = serviceFactory.getSearchService();

        SearchPodcastsByTermArg arg = SearchPodcastsByTermArg.builder()
                                                             .q(CODEFICTION_PODCAST_TITLE)
                                                             .build();

        // Actual
        List<Podcast> podcasts = searchService.searchPodcastsByTerm(arg);

        // Assert
        assertNotNull(podcasts);
        assertEquals(CODEFICTION_PODCAST_TITLE, podcasts.get(0).getTitle());
        assertEquals(CODEFICTION_iTUNES_ID, podcasts.get(0).getItunesId());
    }

    @Test
    public void searchPodcastsByTitle_shouldReturnMatchedPodcasts() throws IOException, InterruptedException {
        // Arrange
        Podcast4jSearchService searchService = serviceFactory.getSearchService();

        SearchPodcastsByTitleArg arg = SearchPodcastsByTitleArg.builder()
                                                               .q(CODEFICTION_PODCAST_TITLE)
                                                               .similar(Boolean.TRUE)
                                                               .build();

        // Actual
        List<Podcast> podcasts = searchService.searchPodcastsByTitle(arg);

        // Assert
        assertNotNull(podcasts);
        assertEquals(CODEFICTION_PODCAST_TITLE, podcasts.get(0).getTitle());
        assertEquals(CODEFICTION_iTUNES_ID, podcasts.get(0).getItunesId());
    }
}
