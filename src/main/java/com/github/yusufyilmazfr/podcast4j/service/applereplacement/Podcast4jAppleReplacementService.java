package com.github.yusufyilmazfr.podcast4j.service.applereplacement;

import com.github.yusufyilmazfr.podcast4j.entity.AppleReplacementSearch;

import java.io.IOException;
import java.util.List;

/**
 * Replaces the Apple search API but returns data from the Podcast Index database.
 * Note: No API key needed for this endpoint.
 * <p>
 * Apple: <a href="https://itunes.apple.com/search?media=podcast&entity=podcast&term=batman">search on Apple</a>
 * PodcastIndex: <a href="https://api.podcastindex.org/search?term=batman">search on PodcastIndex</a>
 */
public interface Podcast4jAppleReplacementService {
    List<AppleReplacementSearch> search(String term) throws IOException, InterruptedException;

    List<AppleReplacementSearch> lookup(Long iTunesId, String type) throws IOException, InterruptedException;
}
