package com.github.yusufyilmazfr.podcast4j.service.episode;

import com.github.yusufyilmazfr.podcast4j.arg.service.episode.*;
import com.github.yusufyilmazfr.podcast4j.entity.Episode;

import java.io.IOException;
import java.util.List;

public interface Podcast4jEpisodeService {
    Episode getEpisodeById(ByIdArg arg) throws IOException, InterruptedException;

    List<Episode> getEpisodesByFeedId(ByFeedIdArg arg) throws IOException, InterruptedException;

    List<Episode> getEpisodesByFeedURL(ByFeedURLArg arg) throws IOException, InterruptedException;

    List<Episode> getEpisodesByiTunesId(ByiTunesArg arg) throws IOException, InterruptedException;

    List<Episode> getLiveEpisodes(Integer max) throws IOException, InterruptedException;

    List<Episode> getRandomEpisodes(RandomEpisodesArg arg) throws IOException, InterruptedException;
}
