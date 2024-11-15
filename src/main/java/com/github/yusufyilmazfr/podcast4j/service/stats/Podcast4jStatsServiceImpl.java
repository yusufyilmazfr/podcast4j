package com.github.yusufyilmazfr.podcast4j.service.stats;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.entity.Stats;
import com.github.yusufyilmazfr.podcast4j.response.StatsResponse;
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL;
import static com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.toURI;

@RequiredArgsConstructor
public class Podcast4jStatsServiceImpl implements Podcast4jStatsService {
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
    public Stats get() throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/stats/current"))
                                             .build();

        HttpResponse<String> content = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), StatsResponse.class).getStats();
    }
}
