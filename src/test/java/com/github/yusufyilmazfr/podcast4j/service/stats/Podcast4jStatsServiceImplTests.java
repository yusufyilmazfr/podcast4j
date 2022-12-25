package com.github.yusufyilmazfr.podcast4j.service.stats;

import com.github.yusufyilmazfr.podcast4j.constant.TestConfig;
import com.github.yusufyilmazfr.podcast4j.entity.Stats;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class Podcast4jStatsServiceImplTests {
    private final Podcast4jServiceFactory serviceFactory;

    public Podcast4jStatsServiceImplTests() {
        serviceFactory = Podcast4jServiceFactory.with(TestConfig::getTestConfig);
    }

    @Test
    public void get_shouldReturnStatsAndCheckStatsPropertiesAreNotNull() throws IOException, InterruptedException {
        // Arrange
        Podcast4jStatsService statsService = serviceFactory.getStatsService();

        // Actual
        Stats stats = statsService.get();

        // Assert
        assertNotNull(stats);
        Assert.assertNotNull(stats.getFeedCountTotal());
        Assert.assertNotNull(stats.getEpisodeCountTotal());
        Assert.assertNotNull(stats.getFeedsWithNewEpisodes3days());
        Assert.assertNotNull(stats.getFeedsWithNewEpisodes10days());
        Assert.assertNotNull(stats.getFeedsWithNewEpisodes30days());
        Assert.assertNotNull(stats.getFeedsWithNewEpisodes90days());
        Assert.assertNotNull(stats.getFeedsWithValueBlocks());
    }
}
