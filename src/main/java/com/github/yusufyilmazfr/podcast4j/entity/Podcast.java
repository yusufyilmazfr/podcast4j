package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.Map;

@Getter
@Setter
public class Podcast {
    /**
     * The internal PodcastIndex.org Feed ID.
     */
    private Integer id;
    /**
     * The GUID from the podcast:guid tag in the feed. This value is a unique, global identifier for the podcast.
     * See the namespace spec for <a href="https://github.com/Podcastindex-org/podcast-namespace/blob/main/docs/1.0.md#guid">guid</a> for details.
     */
    private String podcastGuid;
    /**
     * Name of the feed
     */
    private String title;
    /**
     * Current feed URL
     */
    private URL url;
    /**
     * The URL of the feed, before it changed to the current url value.
     */
    private URL originalUrl;
    /**
     * The channel-level link in the feed
     */
    private URL link;
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
     * The channel-level owner:name element.
     * Usually iTunes specific, but could be from another namespace if not present.
     */
    private String ownerName;
    /**
     * The channel-level image element.
     */
    private URL image;
    /**
     * Seemingly the best artwork we can find for the feed. Might be the same as image in most instances.
     */
    private URL artwork;
    /**
     * The channel-level pubDate for the feed, if it’s sane.
     * If not, this is a heuristic value, arrived at by analyzing other parts of the feed, like item-level pubDates.
     */
    private Long lastUpdateTime;
    /**
     * The last time we attempted to pull this feed from its url.
     */
    private Long lastCrawlTime;
    /**
     * The last time we tried to parse the downloaded feed content.
     */
    private Long lastParseTime;
    /**
     * Timestamp of the last time we got a "good", meaning non-4xx/non-5xx, status code when pulling this feed from its url.
     */
    private Long lastGoodHttpStatusTime;
    /**
     * The last http status code we got when pulling this feed from its url.
     * You will see some made up status codes sometimes. These are what we use to track state within the feed puller. These all start with 9xx.
     */
    private Integer lastHttpStatus;
    /**
     * The Content-Type header from the last time we pulled this feed from its url.
     */
    private String contentType;
    /**
     * The iTunes ID of this feed if there is one, and we know what it is.
     */
    private Long itunesId;
    /**
     * The type as specified by the itunes:type in the feed XML.
     */
    private String itunesType;
    /**
     * The channel-level generator element if there is one.
     */
    private String generator;
    /**
     * The channel-level language specification of the feed. Languages accord with the RSS Language Spec.
     */
    private String language;
    /**
     * Is feed marked as explicit
     */
    private boolean explicit;
    /**
     * Allowed: 0┃1
     * Type of source feed where: 0: RSS, 1: Atom
     */
    private Integer type;
    /**
     * At some point, we give up trying to process a feed and mark it as dead.
     * This is usually after 1000 errors without a successful pull/parse cycle.
     * Once the feed is marked dead, we only check it once per month.
     */
    private Integer dead;
    /**
     * The md5 hash of the following feed items in hex format.
     * <ul>
     *     <li>title</li>
     *     <li>link</li>
     *     <li>feedLanguage</li>
     *     <li>generator</li>
     *     <li>author</li>
     *     <li>ownerName</li>
     *     <li>ownerEmail (note: not exposed via the API)</li>
     * </ul>
     * Pseudo-code:
     * <p>
     * <code>chash = md5(title+link+feedLanguage+generator+author+ownerName+ownerEmail)</code>
     */
    private String chash;
    /**
     * Number of episodes for this feed known to the index.
     */
    private Integer episodeCount;
    /**
     * The number of errors we’ve encountered trying to pull a copy of the feed. Errors are things like a 500 or 404 response, a server timeout, bad encoding, etc.
     */
    private Integer crawlErrors;
    /**
     * The number of errors we’ve encountered trying to parse the feed content. Errors here are things like not well-formed xml, bad character encoding, etc.
     * We fix many of these types of issues on the fly when parsing. We only increment the errors count when we can’t fix it.
     */
    private Integer parseErrors;
    /**
     * Allowed: 0┃1
     * Tell other podcast platforms whether they are allowed to import this feed. A value of 1 means that any attempt to import this feed into a new platform should be rejected. Contains the value of the feed's channel-level podcast:locked tag where:
     * <ul>
     *     <li>0: 'no'</li>
     *     <li>1: 'yes'</li>
     * </ul>
     */
    private Integer locked;
    /**
     * A CRC32 hash of the image URL with the protocol (http://, https://) removed.
     */
    private Long imageUrlHash;
    private Long valueCreatedOn;
    private Long newestItemPubdate;
    /**
     * An array of categories, where the index is the Category ID and the value is the Category Name.
     */
    private Map<Integer, String> categories;
    /**
     * Information for donation/funding the podcast.
     */
    private Funding funding;
    /**
     * Information for supporting the podcast via one of the "Value for Value" methods.
     */
    private Value value;
}
