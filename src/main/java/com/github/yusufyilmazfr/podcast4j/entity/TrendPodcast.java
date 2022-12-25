package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.Map;

@Getter
@Setter
public class TrendPodcast {
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
     * The channel-level description
     * Uses the longest of the possible fields in the feed: <description>, <itunes:summary> and <content:encoded>
     */
    private String description;
    /**
     * The channel-level author element.
     * Usually iTunes specific, but could be from another namespace if not present.
     */
    private String author;
    /**
     * The channel-level image element.
     */
    private URL image;
    /**
     * Seemingly the best artwork we can find for the feed. Might be the same as image in most instances.
     */
    private URL artwork;
    /**
     * The iTunes ID of this feed if there is one, and we know what it is.
     */
    private Long itunesId;
    /**
     * The ranking for how the podcast is trending in the index
     */
    private Integer trendScore;
    /**
     * The channel-level language specification of the feed. Languages accord with the RSS Language Spec.
     */
    private String language;
    /**
     * The date and time the most recent episode in the feed was published
     */
    private Long newestItemPublishTime;
    /**
     * An array of categories, where the index is the Category ID and the value is the Category Name.
     */
    private Map<Integer, String> categories;
}
