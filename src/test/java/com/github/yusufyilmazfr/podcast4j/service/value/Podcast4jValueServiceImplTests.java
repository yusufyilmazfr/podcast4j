package com.github.yusufyilmazfr.podcast4j.service.value;

import com.github.yusufyilmazfr.podcast4j.constant.TestConfig;
import com.github.yusufyilmazfr.podcast4j.entity.Value;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class Podcast4jValueServiceImplTests {
    private final Integer PODCAST_INDEX_FEED_ID_FOR_VALUE = 920666;
    private final String PODCAST_INDEX_FEED_URL_FOR_VALUE = "https://mp3s.nashownotes.com/pc20rss.xml";

    private final Podcast4jServiceFactory serviceFactory;

    public Podcast4jValueServiceImplTests() {
        serviceFactory = Podcast4jServiceFactory.with(TestConfig::getTestConfig);
    }

    @Test
    public void getValueByFeedId_shouldReturnMatchedValue() throws IOException, InterruptedException {
        // Arrange
        Podcast4jValueService valueService = serviceFactory.getValueService();

        // Actual
        Value value = valueService.getValueByFeedId(PODCAST_INDEX_FEED_ID_FOR_VALUE);

        // Assert
        assertNotNull(value);
        assertNotNull(value.getModel());
        assertNotNull(value.getDestinations());
    }

    @Test
    public void getValueByFeedURL_shouldReturnMatchedValue() throws IOException, InterruptedException {
        // Arrange
        Podcast4jValueService valueService = serviceFactory.getValueService();

        // Actual
        Value value = valueService.getValueByFeedURL(PODCAST_INDEX_FEED_URL_FOR_VALUE);

        // Assert
        assertNotNull(value);
        assertNotNull(value.getModel());
        assertNotNull(value.getDestinations());
    }
}
