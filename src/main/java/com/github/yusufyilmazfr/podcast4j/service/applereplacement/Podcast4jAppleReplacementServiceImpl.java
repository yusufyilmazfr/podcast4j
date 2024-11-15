package com.github.yusufyilmazfr.podcast4j.service.applereplacement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.entity.AppleReplacementSearch;
import com.github.yusufyilmazfr.podcast4j.response.AppleReplacementSearchResponse;
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_APP_URL;
import static com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.toURI;

@RequiredArgsConstructor
public class Podcast4jAppleReplacementServiceImpl implements Podcast4jAppleReplacementService {
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
    public List<AppleReplacementSearch> search(String term) throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_APP_URL + "/search?term=" + term))
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), AppleReplacementSearchResponse.class).getResults();
    }

    @Override
    public List<AppleReplacementSearch> lookup(Long iTunesId, String type) throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_APP_URL + "/lookup?id=" + iTunesId + "&entity=" + type))
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), AppleReplacementSearchResponse.class).getResults();
    }
}
