package com.github.yusufyilmazfr.podcast4j.service.podcast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.entity.Podcast;
import com.github.yusufyilmazfr.podcast4j.response.PodcastResponse;
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL;

@RequiredArgsConstructor
public class Podcast4jPodcastServiceImpl implements Podcast4jPodcastService {
    private final Config config;
    private final ObjectMapper objectMapper;

    private final HttpClient httpClient = HttpClient.newBuilder()
                                                    .followRedirects(HttpClient.Redirect.NEVER)
                                                    .build();


    @Override
    public Podcast getPodcastByFeedId(Integer feedId) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(new URI(BASE_API_V1_URL + "/podcasts/byfeedid?id=" + feedId))
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), PodcastResponse.class).getPodcast();
    }

    @Override
    public Podcast getPodcastByFeedURL(String feedURL) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(new URI(BASE_API_V1_URL + "/podcasts/byfeedurl?url=" + feedURL))
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), PodcastResponse.class).getPodcast();
    }

    @Override
    public Podcast getPodcastByiTunesID(Long iTunesId) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(new URI(BASE_API_V1_URL + "/podcasts/byitunesid?id=" + iTunesId))
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), PodcastResponse.class).getPodcast();
    }
}
