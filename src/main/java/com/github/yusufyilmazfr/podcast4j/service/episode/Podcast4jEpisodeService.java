package com.github.yusufyilmazfr.podcast4j.service.episode;

import com.github.yusufyilmazfr.podcast4j.arg.service.episode.ByFeedIdArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.episode.ByFeedURLArg;
import com.github.yusufyilmazfr.podcast4j.entity.Episode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface Podcast4jEpisodeService {
    List<Episode> getEpisodesByFeedId(ByFeedIdArg arg) throws IOException, InterruptedException, URISyntaxException;

    List<Episode> getEpisodesByFeedURL(ByFeedURLArg arg) throws IOException, InterruptedException, URISyntaxException;
}
