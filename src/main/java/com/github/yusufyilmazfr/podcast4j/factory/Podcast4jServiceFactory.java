package com.github.yusufyilmazfr.podcast4j.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.service.category.Podcast4jCategoryService;
import com.github.yusufyilmazfr.podcast4j.service.category.Podcast4jCategoryServiceImpl;

import java.util.function.Supplier;

public class Podcast4jServiceFactory {
    private static Podcast4jCategoryService categoryService;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private Podcast4jServiceFactory() {
    }

    public static Podcast4jServiceFactory with(Config config) {
        categoryService = new Podcast4jCategoryServiceImpl(config, objectMapper);
        return new Podcast4jServiceFactory();
    }

    public static Podcast4jServiceFactory with(Supplier<Config> supplier) {
        categoryService = new Podcast4jCategoryServiceImpl(supplier.get(), objectMapper);
        return new Podcast4jServiceFactory();
    }

    public Podcast4jCategoryService getCategoryService() {
        return categoryService;
    }
}
