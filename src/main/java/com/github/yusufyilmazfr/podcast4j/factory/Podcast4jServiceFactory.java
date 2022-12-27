package com.github.yusufyilmazfr.podcast4j.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.service.applereplacement.Podcast4jAppleReplacementService;
import com.github.yusufyilmazfr.podcast4j.service.applereplacement.Podcast4jAppleReplacementServiceImpl;
import com.github.yusufyilmazfr.podcast4j.service.category.Podcast4jCategoryService;
import com.github.yusufyilmazfr.podcast4j.service.category.Podcast4jCategoryServiceImpl;
import com.github.yusufyilmazfr.podcast4j.service.episode.Podcast4jEpisodeService;
import com.github.yusufyilmazfr.podcast4j.service.episode.Podcast4jEpisodeServiceImpl;
import com.github.yusufyilmazfr.podcast4j.service.hub.Podcast4jHubService;
import com.github.yusufyilmazfr.podcast4j.service.hub.Podcast4jHubServiceImpl;
import com.github.yusufyilmazfr.podcast4j.service.podcast.Podcast4jPodcastService;
import com.github.yusufyilmazfr.podcast4j.service.podcast.Podcast4jPodcastServiceImpl;
import com.github.yusufyilmazfr.podcast4j.service.recent.Podcast4jRecentService;
import com.github.yusufyilmazfr.podcast4j.service.recent.Podcast4jRecentServiceImpl;
import com.github.yusufyilmazfr.podcast4j.service.search.Podcast4jSearchService;
import com.github.yusufyilmazfr.podcast4j.service.search.Podcast4jSearchServiceImpl;
import com.github.yusufyilmazfr.podcast4j.service.stats.Podcast4jStatsService;
import com.github.yusufyilmazfr.podcast4j.service.stats.Podcast4jStatsServiceImpl;
import com.github.yusufyilmazfr.podcast4j.service.value.Podcast4jValueService;
import com.github.yusufyilmazfr.podcast4j.service.value.Podcast4jValueServiceImpl;

import java.util.function.Supplier;

public class Podcast4jServiceFactory {
    private static Podcast4jCategoryService categoryService;
    private static Podcast4jStatsService statsService;
    private static Podcast4jRecentService recentService;
    private static Podcast4jEpisodeService episodeService;
    private static Podcast4jPodcastService podcastService;
    private static Podcast4jValueService valueService;
    private static Podcast4jHubService hubService;
    private static Podcast4jAppleReplacementService appleReplacementService;
    private static Podcast4jSearchService searchService;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private Podcast4jServiceFactory() {
    }

    public static Podcast4jServiceFactory with(Config config) {
        categoryService = new Podcast4jCategoryServiceImpl(config, objectMapper);
        statsService = new Podcast4jStatsServiceImpl(config, objectMapper);
        recentService = new Podcast4jRecentServiceImpl(config, objectMapper);
        episodeService = new Podcast4jEpisodeServiceImpl(config, objectMapper);
        podcastService = new Podcast4jPodcastServiceImpl(config, objectMapper);
        valueService = new Podcast4jValueServiceImpl(config, objectMapper);
        hubService = new Podcast4jHubServiceImpl(config);
        appleReplacementService = new Podcast4jAppleReplacementServiceImpl(config, objectMapper);
        searchService = new Podcast4jSearchServiceImpl(config, objectMapper);
        return new Podcast4jServiceFactory();
    }

    public static Podcast4jServiceFactory with(Supplier<Config> supplier) {
        return with(supplier.get());
    }

    public Podcast4jCategoryService getCategoryService() {
        return categoryService;
    }

    public Podcast4jStatsService getStatsService() {
        return statsService;
    }

    public Podcast4jRecentService getRecentService() {
        return recentService;
    }

    public Podcast4jEpisodeService getEpisodeService() {
        return episodeService;
    }

    public Podcast4jPodcastService getPodcastService() {
        return podcastService;
    }

    public Podcast4jValueService getValueService() {
        return valueService;
    }

    public Podcast4jHubService getHubService() {
        return hubService;
    }

    public Podcast4jAppleReplacementService getAppleReplacementService() {
        return appleReplacementService;
    }

    public Podcast4jSearchService getSearchService() {
        return searchService;
    }
}
