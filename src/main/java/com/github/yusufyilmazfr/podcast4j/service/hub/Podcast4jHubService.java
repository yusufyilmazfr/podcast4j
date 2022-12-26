package com.github.yusufyilmazfr.podcast4j.service.hub;

import java.io.IOException;

public interface Podcast4jHubService {
    /**
     * Notify the index that a feed has changed
     *
     * @param feedId The PodcastIndex Feed ID
     * @return true if API call is success otherwise false.
     */
    boolean notifyByFeedId(Integer feedId) throws IOException, InterruptedException;

    /**
     * Notify the index that a feed has changed
     *
     * @param feedURL The Podcast feed URL
     * @return true if API call is success otherwise false.
     */

    boolean notifyByFeedURL(String feedURL) throws IOException, InterruptedException;
}
