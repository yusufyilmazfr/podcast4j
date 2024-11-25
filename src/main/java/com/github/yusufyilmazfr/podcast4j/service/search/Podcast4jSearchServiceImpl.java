package com.github.yusufyilmazfr.podcast4j.service.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yusufyilmazfr.podcast4j.arg.service.search.SearchPodcastsByTermArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.search.SearchPodcastsByTitleArg;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.entity.Podcast;
import com.github.yusufyilmazfr.podcast4j.response.SearchPodcastsResponse;
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
public class Podcast4jSearchServiceImpl implements Podcast4jSearchService {
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
    public List<Podcast> searchPodcastsByTerm(SearchPodcastsByTermArg arg) throws IOException, InterruptedException {
        String queryParams = toQueryParams(arg.toParams());

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/search/byterm?" + queryParams))
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), SearchPodcastsResponse.class).getPodcasts();
    }

    @Override
    public List<Podcast> searchPodcastsByTitle(SearchPodcastsByTitleArg arg) throws IOException, InterruptedException {
        String queryParams = toQueryParams(arg.toParams());

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/search/bytitle?" + queryParams))
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), SearchPodcastsResponse.class).getPodcasts();

    }
}
