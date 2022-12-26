package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AppleReplacementSearch {
    /**
     * The channel-level author element.
     * Usually iTunes specific, but could be from another namespace if not present.
     */
    private String artistName;
    /**
     * A URL for the artwork associated with the returned media type.
     * Note: Apple returns the image sized to value in the field name but the PodcastIndex returns the original image specified in the feed.
     */
    private String artworkUrl30;
    /**
     * A URL for the artwork associated with the returned media type.
     * Note: Apple returns the image sized to value in the field name but the PodcastIndex returns the original image specified in the feed.
     */
    private String artworkUrl60;
    /**
     * A URL for the artwork associated with the returned media type.
     * Note: Apple returns the image sized to value in the field name but the PodcastIndex returns the original image specified in the feed.
     */
    private String artworkUrl100;
    /**
     * The name of the feed.
     * Note: Apple censors the name but PodcastIndex does not.
     */
    private String collectionCensoredName;
    /**
     * A URL for the artwork associated with the returned media type.
     * Note: Apple returns the image sized to value in the field name but the PodcastIndex returns the original image specified in the feed.
     */
    private String artworkUrl600;
    /**
     * Allowed: explicit┃cleaned
     * Indicates if the feed is marked explicit.
     */
    private String collectionExplicitness;
    /**
     * Price of content. Will always return 0.
     */
    private Integer collectionHdPrice;
    /**
     * The iTunes Feed ID
     */
    private float collectionId;
    /**
     * Name of the feed
     */
    private String collectionName;
    /**
     * Price of content. Will always return 0.
     */
    private float collectionPrice;
    /**
     * The URL for viewing the feed on the Apple website.
     */
    private String collectionViewUrl;
    /**
     * Allowed: Clean┃Explicit
     * Indicates if the feed is explicit or clean.
     */
    private String contentAdvisoryRating;
    /**
     * The country the feed is from.
     * Note: Right now, always returns "USA"
     */
    private String country;
    /**
     * Currency *Price value is in.
     * Note: will always return "USD"
     */
    private String currency;
    /**
     * Current feed URL
     */
    private String feedUrl;
    /**
     * List of ids representing the names in the genres.
     * Values are determined by the IDs used in the url of genres on <a href="https://podcasts.apple.com/us/genre/podcasts/id26">genres</a>
     */
    List<Integer> genreIds;
    /**
     * List of genre names.
     */
    List<String> genres;
    /**
     * The kind of content returned by the search request.
     * Note: will always return "podcast"
     */
    private String kind;
    /**
     * The primary genre name.
     */
    private String primaryGenreName;
    /**
     * Date and time of request
     */
    private String releaseDate;
    /**
     * The name of the feed.
     * Note: Apple censors the name but PodcastIndex does not.
     */
    private String trackCensoredName;
    /**
     * Number of episodes in feed
     */
    private Integer trackCount;
    /**
     * Allowed: explicit┃cleaned
     */
    private String trackExplicitness;
    /**
     * Price of content. Will always return 0.
     */
    private Integer trackHdPrice;
    /**
     * Price of content. Will always return 0.
     */
    private Integer trackHdRentalPrice;
    /**
     * The iTunes Feed ID
     */
    private Long trackId;
    /**
     * Name of the feed
     */
    private String trackName;
    /**
     * Price of content. Will always return 0.
     */
    private Integer trackPrice;
    /**
     * Price of content. Will always return 0.
     */
    private Integer trackRentalPrice;
    /**
     * The URL for viewing the feed on the Apple website.
     */
    private String trackViewUrl;
    /**
     * The name of the object returned by the search request.
     * Note: will always return "track"
     */

    private String wrapperType;

}
