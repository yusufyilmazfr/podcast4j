package com.github.yusufyilmazfr.podcast4j.service.podcast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yusufyilmazfr.podcast4j.arg.service.podcast.TrendPodcastsArg;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.entity.DeadPodcast;
import com.github.yusufyilmazfr.podcast4j.entity.Podcast;
import com.github.yusufyilmazfr.podcast4j.entity.TrendPodcast;
import com.github.yusufyilmazfr.podcast4j.enums.MediumType;
import com.github.yusufyilmazfr.podcast4j.response.*;
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

    private HttpClient httpClientInstance;

    private HttpClient getHttpClient() {
        if (httpClientInstance == null) {
            synchronized (HttpClient.class) {
                HttpClient.Builder builder = HttpClient.newBuilder()
                        .followRedirects(HttpClient.Redirect.NEVER);
                if (config.getProxySelector() != null) {
                    builder.proxy(config.getProxySelector());
                }
                httpClientInstance = builder.build();
            }
        }
        return httpClientInstance;
    }


    @Override
    public Podcast getPodcastByFeedId(Integer feedId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/podcasts/byfeedid?id=" + feedId))
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), PodcastResponse.class).getPodcast();
    }

    @Override
    public Podcast getPodcastByFeedURL(String feedURL) throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/podcasts/byfeedurl?url=" + feedURL))
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), PodcastResponse.class).getPodcast();
    }

    @Override
    public Podcast getPodcastByGUID(String GUID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                              .uri(toURI(BASE_API_V1_URL + "/podcasts/byguid?guid=" + GUID))
                                              .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), PodcastResponse.class).getPodcast();
    }

    @Override
    public Podcast getPodcastByiTunesID(Long iTunesId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/podcasts/byitunesid?id=" + iTunesId))
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), PodcastResponse.class).getPodcast();
    }

    @Override
    public List<Podcast> getPodcastsByTag() throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/podcasts/bytag?podcast-value"))
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), PodcastsByTagResponse.class).getPodcasts();
    }

    @Override
    public List<Podcast> getPodcastsByMedium(MediumType mediumType) throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/podcasts/bymedium?medium=" + mediumType.getName()))
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), PodcastsByMediumResponse.class).getPodcasts();
    }

    @Override
    public List<TrendPodcast> getTrendPodcasts(TrendPodcastsArg arg) throws IOException, InterruptedException {
        String queryParams = toQueryParams(arg.toParams());

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/podcasts/trending?" + queryParams))
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), TrendPodcastsResponse.class).getTrendPodcasts();
    }

    @Override
    public List<DeadPodcast> getDeadPodcasts() throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/podcasts/dead"))
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), DeadPodcastsResponse.class).getDeadPodcasts();
    }
}
