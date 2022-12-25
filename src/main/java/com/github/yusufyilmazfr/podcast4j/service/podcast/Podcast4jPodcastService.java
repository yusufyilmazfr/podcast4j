package com.github.yusufyilmazfr.podcast4j.service.podcast;

import com.github.yusufyilmazfr.podcast4j.entity.Podcast;

import java.io.IOException;
import java.net.URISyntaxException;

public interface Podcast4jPodcastService {
    /**
     * This call returns everything we know about the feed from the PodcastIndex ID
     *
     * @param feedId The PodcastIndex Feed ID.
     * @return Podcast from the PodcastIndex.
     */
    Podcast getPodcastByFeedId(Integer feedId) throws URISyntaxException, IOException, InterruptedException;
}
