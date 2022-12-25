package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class DeadPodcast {
    /**
     * The internal PodcastIndex.org Feed ID.
     */
    private Integer id;
    /**
     * Name of the feed
     */
    private String title;
    /**
     * Current feed URL
     */
    private URL url;

    /**
     * The internal PodcastIndex.org Feed ID this feed duplicates
     */
    private Integer duplicateOf;
}
