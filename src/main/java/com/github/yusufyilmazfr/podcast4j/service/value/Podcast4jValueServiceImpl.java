package com.github.yusufyilmazfr.podcast4j.service.value;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.entity.Value;
import com.github.yusufyilmazfr.podcast4j.response.ValueResponse;
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL;
import static com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.toURI;

@RequiredArgsConstructor
public class Podcast4jValueServiceImpl implements Podcast4jValueService {
    private final Config config;
    private final ObjectMapper objectMapper;

    private final HttpClient httpClient = HttpClient.newBuilder()
                                                    .followRedirects(HttpClient.Redirect.NEVER)
                                                    .build();

    @Override
    public Value getValueByFeedId(Integer feedId) throws IOException, InterruptedException {
        URI uri = toURI(BASE_API_V1_URL + "/value/byfeedid?id=" + feedId);

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(uri)
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), ValueResponse.class).getValue();
    }

    @Override
    public Value getValueByFeedURL(String feedURL) throws IOException, InterruptedException {
        URI uri = toURI(BASE_API_V1_URL + "/value/byfeedurl?url=" + feedURL);

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(uri)
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), ValueResponse.class).getValue();
    }
}
