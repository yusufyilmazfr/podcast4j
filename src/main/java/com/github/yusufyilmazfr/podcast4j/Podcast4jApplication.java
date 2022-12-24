package com.github.yusufyilmazfr.podcast4j;

import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import com.github.yusufyilmazfr.podcast4j.service.category.Podcast4jCategoryService;
import com.github.yusufyilmazfr.podcast4j.service.stats.Podcast4jStatsService;

import java.io.IOException;
import java.net.URISyntaxException;

public class Podcast4jApplication {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        Config config = Config.builder()
                              .secret("HQT8wkdbb5KVMGur$$TmYvg#W6Dgph4nvQkyhV#f")
                              .authKey("CJSXRHDXXTFGKK3DYDNB")
                              .userAgent("SuperPodcastPlayer/1.8")
                              .build();

        Podcast4jServiceFactory factory = Podcast4jServiceFactory.with(config);

        Podcast4jCategoryService categoryService = factory.getCategoryService();
        Podcast4jStatsService statsService = factory.getStatsService();

        categoryService.getAll().forEach(System.out::println);
        System.out.println("statsService.get() = " + statsService.get());
    }
}
