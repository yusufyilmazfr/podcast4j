package com.github.yusufyilmazfr.podcast4j;

import com.github.yusufyilmazfr.podcast4j.arg.service.recent.FeedsArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.NewFeedsArg;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import com.github.yusufyilmazfr.podcast4j.service.recent.Podcast4jRecentService;

import java.io.IOException;
import java.net.URISyntaxException;

public class Podcast4jApplication {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        Config config = Config.builder()
                .secret("HQT8wkdbb5KVMGur$$TmYvg#W6Dgph4nvQkyhV#f")
                .authKey("CJSXRHDXXTFGKK3DYDNB")
                .userAgent("SuperPodcastPlayer/1.8")
                .build();

        // factory
        Podcast4jServiceFactory factory = Podcast4jServiceFactory.with(config);

        // recent service - sound bites
        Podcast4jRecentService recentService = factory.getRecentService();
        recentService.getSoundBites(1).forEach(System.out::println);

        // recent service - new feeds
        NewFeedsArg newFeedsArg = NewFeedsArg.builder()
                .max(10)
                .since(1671903237L)
                .build();

        recentService.getNewFeeds(newFeedsArg).forEach(System.out::println);


        // recent service - feeds
        FeedsArg feedsArg = FeedsArg
                .builder()
                .max(1)
                .lang("tr")
                .cat("technology")
                .build();

        recentService.getFeeds(feedsArg).forEach(System.out::println);
    }
}
