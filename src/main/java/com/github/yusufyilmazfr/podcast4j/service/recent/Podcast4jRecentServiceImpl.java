package com.github.yusufyilmazfr.podcast4j.service.recent;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.entity.SoundBite;
import com.github.yusufyilmazfr.podcast4j.response.SoundBiteResponse;
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL;

@RequiredArgsConstructor
public class Podcast4jRecentServiceImpl implements Podcast4jRecentService {
    private final Config config;
    private final ObjectMapper objectMapper;

    private final HttpClient httpClient = HttpClient.newBuilder()
                                                    .followRedirects(HttpClient.Redirect.NEVER)
                                                    .build();

    @Override
    public List<SoundBite> getSoundBites(int max) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(new URI(BASE_API_V1_URL + "/recent/soundbites?max=" + max))
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), SoundBiteResponse.class).getSoundBites();
    }
}
