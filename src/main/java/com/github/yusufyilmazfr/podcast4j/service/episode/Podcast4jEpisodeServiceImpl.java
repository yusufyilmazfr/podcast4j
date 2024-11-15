package com.github.yusufyilmazfr.podcast4j.service.episode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yusufyilmazfr.podcast4j.arg.service.episode.*;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.entity.Episode;
import com.github.yusufyilmazfr.podcast4j.response.ByGUIDEpisodeResponse;
import com.github.yusufyilmazfr.podcast4j.response.EpisodeResponse;
import com.github.yusufyilmazfr.podcast4j.response.EpisodesResponse;
import com.github.yusufyilmazfr.podcast4j.response.RandomEpisodesResponse;
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL;
import static com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.toQueryParams;
import static com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.toURI;

@RequiredArgsConstructor
public class Podcast4jEpisodeServiceImpl implements Podcast4jEpisodeService {
    private final Config config;
    private final ObjectMapper objectMapper;

    private HttpClient httpClientInstance;

    public HttpClient getHttpClient() {
        if (httpClientInstance == null) {
            synchronized (HttpClient.class) {
                httpClientInstance = HttpClient.newBuilder()
                        .followRedirects(HttpClient.Redirect.NEVER)
                        .proxy(config.getProxySelector())
                        .build();
            }
        }
        return httpClientInstance;
    }

    @Override
    public Episode getEpisodeById(ByIdArg arg) throws IOException, InterruptedException {
        String queryParams = toQueryParams(arg.toParams());
        URI uri = toURI(BASE_API_V1_URL + "/episodes/byid?" + queryParams);

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(uri)
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), EpisodeResponse.class).getEpisode();
    }

    @Override
    public List<Episode> getEpisodesByFeedId(ByFeedIdArg arg) throws IOException, InterruptedException {
        String queryParams = toQueryParams(arg.toParams());
        URI uri = toURI(BASE_API_V1_URL + "/episodes/byfeedid?" + queryParams);

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(uri)
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), EpisodesResponse.class).getEpisodes();
    }

    @Override
    public List<Episode> getEpisodesByFeedURL(ByFeedURLArg arg) throws IOException, InterruptedException {
        String queryParams = toQueryParams(arg.toParams());
        URI uri = toURI(BASE_API_V1_URL + "/episodes/byfeedurl?" + queryParams);

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(uri)
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), EpisodesResponse.class).getEpisodes();
    }

    @Override
    public List<Episode> getEpisodesByiTunesId(ByiTunesArg arg) throws IOException, InterruptedException {
        String queryParams = toQueryParams(arg.toParams());
        URI uri = toURI(BASE_API_V1_URL + "/episodes/byitunesid?" + queryParams);

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(uri)
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), EpisodesResponse.class).getEpisodes();
    }

    @Override
    public Episode getEpisodeByGUID(ByGUIDArg arg) throws IOException, InterruptedException {
        String queryParams = toQueryParams(arg.toParams());
        URI uri = toURI(BASE_API_V1_URL + "/episodes/byguid?" + queryParams);

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(uri)
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), ByGUIDEpisodeResponse.class).getEpisode();
    }

    @Override
    public List<Episode> getLiveEpisodes(Integer max) throws IOException, InterruptedException {
        URI uri = toURI(BASE_API_V1_URL + "/episodes/live?max=" + max);

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(uri)
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), EpisodesResponse.class).getEpisodes();
    }

    @Override
    public List<Episode> getRandomEpisodes(RandomEpisodesArg arg) throws IOException, InterruptedException {
        String queryParams = toQueryParams(arg.toParams());
        URI uri = toURI(BASE_API_V1_URL + "/episodes/random?" + queryParams);

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(uri)
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), RandomEpisodesResponse.class).getEpisodes();
    }
}
