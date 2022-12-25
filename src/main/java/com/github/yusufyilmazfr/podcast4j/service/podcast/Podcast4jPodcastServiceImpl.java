package com.github.yusufyilmazfr.podcast4j.service.podcast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yusufyilmazfr.podcast4j.arg.service.podcast.TrendPodcastsArg;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.entity.Podcast;
import com.github.yusufyilmazfr.podcast4j.entity.TrendPodcast;
import com.github.yusufyilmazfr.podcast4j.enums.MediumType;
import com.github.yusufyilmazfr.podcast4j.response.PodcastResponse;
import com.github.yusufyilmazfr.podcast4j.response.PodcastsByMediumResponse;
import com.github.yusufyilmazfr.podcast4j.response.TrendPodcastsResponse;
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL;
import static com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.toQueryParams;
import static com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.toURI;

@RequiredArgsConstructor
public class Podcast4jPodcastServiceImpl implements Podcast4jPodcastService {
    private final Config config;
    private final ObjectMapper objectMapper;

    private final HttpClient httpClient = HttpClient.newBuilder()
                                                    .followRedirects(HttpClient.Redirect.NEVER)
                                                    .build();


    @Override
    public Podcast getPodcastByFeedId(Integer feedId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/podcasts/byfeedid?id=" + feedId))
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), PodcastResponse.class).getPodcast();
    }

    @Override
    public Podcast getPodcastByFeedURL(String feedURL) throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/podcasts/byfeedurl?url=" + feedURL))
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), PodcastResponse.class).getPodcast();
    }

    @Override
    public Podcast getPodcastByiTunesID(Long iTunesId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/podcasts/byitunesid?id=" + iTunesId))
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), PodcastResponse.class).getPodcast();
    }

    @Override
    public List<Podcast> getPodcastsByMedium(MediumType mediumType) throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/podcasts/bymedium?medium=" + mediumType.getName()))
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), PodcastsByMediumResponse.class).getPodcasts();
    }

    @Override
    public List<TrendPodcast> getTrendPodcasts(TrendPodcastsArg arg) throws IOException, InterruptedException {
        String queryParams = toQueryParams(arg.toParams());

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/podcasts/trending?" + queryParams))
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), TrendPodcastsResponse.class).getTrendPodcasts();
    }
}
