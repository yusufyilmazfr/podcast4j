package com.github.yusufyilmazfr.podcast4j.service.hub;

import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL;
import static com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.toURI;

@RequiredArgsConstructor
public class Podcast4jHubServiceImpl implements Podcast4jHubService {
    private final Config config;

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
    public boolean notifyByFeedId(Integer feedId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/hub/pubnotify?id=" + feedId))
                                             .build();

        HttpResponse<String> response = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode() == 200;
    }

    @Override
    public boolean notifyByFeedURL(String feedURL) throws IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(toURI(BASE_API_V1_URL + "/hub/pubnotify?url=" + feedURL))
                                             .build();

        HttpResponse<String> response = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode() == 200;
    }
}
