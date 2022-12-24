package com.github.yusufyilmazfr.podcast4j.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.service.category.Podcast4jCategoryService;
import com.github.yusufyilmazfr.podcast4j.service.category.Podcast4jCategoryServiceImpl;
import com.github.yusufyilmazfr.podcast4j.service.recent.Podcast4jRecentService;
import com.github.yusufyilmazfr.podcast4j.service.recent.Podcast4jRecentServiceImpl;
import com.github.yusufyilmazfr.podcast4j.service.stats.Podcast4jStatsService;
import com.github.yusufyilmazfr.podcast4j.service.stats.Podcast4jStatsServiceImpl;

import java.util.function.Supplier;

public class Podcast4jServiceFactory {
    private static Podcast4jCategoryService categoryService;
    private static Podcast4jStatsService statsService;
    private static Podcast4jRecentService recentService;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private Podcast4jServiceFactory() {
    }

    public static Podcast4jServiceFactory with(Config config) {
        categoryService = new Podcast4jCategoryServiceImpl(config, objectMapper);
        statsService = new Podcast4jStatsServiceImpl(config, objectMapper);
        recentService = new Podcast4jRecentServiceImpl(config, objectMapper);
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
}
