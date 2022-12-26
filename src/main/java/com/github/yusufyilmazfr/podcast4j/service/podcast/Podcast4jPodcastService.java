package com.github.yusufyilmazfr.podcast4j.service.podcast;

import com.github.yusufyilmazfr.podcast4j.arg.service.podcast.TrendPodcastsArg;
import com.github.yusufyilmazfr.podcast4j.entity.DeadPodcast;
import com.github.yusufyilmazfr.podcast4j.entity.Podcast;
import com.github.yusufyilmazfr.podcast4j.entity.TrendPodcast;
import com.github.yusufyilmazfr.podcast4j.enums.MediumType;

import java.io.IOException;
import java.util.List;

public interface Podcast4jPodcastService {
    /**
     * This call returns everything we know about the feed from the PodcastIndex ID
     *
     * @param feedId The PodcastIndex Feed ID.
     * @return Podcast from the PodcastIndex.
     */
    Podcast getPodcastByFeedId(Integer feedId) throws IOException, InterruptedException;

    Podcast getPodcastByFeedURL(String feedURL) throws IOException, InterruptedException;

    Podcast getPodcastByGUID(String GUID) throws IOException, InterruptedException;

    Podcast getPodcastByiTunesID(Long iTunesId) throws IOException, InterruptedException;

    List<Podcast> getPodcastsByTag() throws IOException, InterruptedException;

    /**
     * This call returns everything we know about the feeds from the PodcastIndex by medium.
     *
     * @param mediumType (Required) The medium value to search for.
     *                   Full list of possible values documented in [medium](<a href="https://github.com/Podcastindex-org/podcast-namespace/blob/main/docs/1.0.md#medium">medium</a>) tag spec.
     * @return
     * @throws IOException
     * @throws InterruptedException
     */

    List<Podcast> getPodcastsByMedium(MediumType mediumType) throws IOException, InterruptedException;

    List<TrendPodcast> getTrendPodcasts(TrendPodcastsArg arg) throws IOException, InterruptedException;

    /**
     * This call returns all feeds that have been marked dead (dead == 1)
     *
     * @return DeadPodcast list.
     */
    List<DeadPodcast> getDeadPodcasts() throws IOException, InterruptedException;
}
