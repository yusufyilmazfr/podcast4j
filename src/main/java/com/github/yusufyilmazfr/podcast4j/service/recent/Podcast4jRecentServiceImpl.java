package com.github.yusufyilmazfr.podcast4j.service.recent;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.EpisodesArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.FeedsArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.NewFeedsArg;
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.entity.Episode;
import com.github.yusufyilmazfr.podcast4j.entity.Feed;
import com.github.yusufyilmazfr.podcast4j.entity.NewFeed;
import com.github.yusufyilmazfr.podcast4j.entity.SoundBite;
import com.github.yusufyilmazfr.podcast4j.response.EpisodesResponse;
import com.github.yusufyilmazfr.podcast4j.response.FeedsResponse;
import com.github.yusufyilmazfr.podcast4j.response.NewFeedsResponse;
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
import static com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.toQueryParams;

@RequiredArgsConstructor
public class Podcast4jRecentServiceImpl implements Podcast4jRecentService {
    private final Config config;
    private final ObjectMapper objectMapper;

    private final HttpClient httpClient = HttpClient.newBuilder()
                                                    .followRedirects(HttpClient.Redirect.NEVER)
                                                    .build();

    @Override
    public List<Feed> getFeeds(FeedsArg arg) throws URISyntaxException, IOException, InterruptedException {
        String queryParams = toQueryParams(arg.toParams());
        String url = BASE_API_V1_URL + "/recent/feeds?" + queryParams;


        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(new URI(url))
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), FeedsResponse.class).getFeeds();
    }

    @Override
    public List<NewFeed> getNewFeeds(NewFeedsArg arg) throws IOException, InterruptedException, URISyntaxException {
        String queryParams = toQueryParams(arg.toParams());
        String url = BASE_API_V1_URL + "/recent/newfeeds?" + queryParams;

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(new URI(url))
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), NewFeedsResponse.class).getFeeds();
    }

    @Override
    public List<SoundBite> getSoundBites(int max) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(new URI(BASE_API_V1_URL + "/recent/soundbites?max=" + max))
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), SoundBiteResponse.class).getSoundBites();
    }

    @Override
    public List<Episode> getEpisodes(EpisodesArg arg) throws URISyntaxException, IOException, InterruptedException {
        String queryParams = toQueryParams(arg.toParams());
        String url = BASE_API_V1_URL + "/recent/episodes?" + queryParams;

        HttpRequest request = HttpRequestUtil.with(config)
                                             .uri(new URI(url))
                                             .build();

        HttpResponse<String> content = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(content.body(), EpisodesResponse.class).getEpisodes();
    }
}
