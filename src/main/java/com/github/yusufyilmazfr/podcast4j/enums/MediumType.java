package com.github.yusufyilmazfr.podcast4j.enums;

public enum MediumType {
    /**
     * Describes a feed for a podcast show. If no medium tag is present in the channel, this medium is assumed.
     */
    PODCAST("podcast"),
    /**
     * A feed of music organized into an "album" with each item a song within the album.
     */
    MUSIC("music"),
    /**
     * Like a "podcast" but used in a more visual experience. Something akin to a dedicated video channel like would be found on YouTube.
     */
    VIDEO("video"),
    /**
     * Specific types of videos with one item per feed. This is different from a video medium because the content is considered to be cinematic; like a movie or documentary.
     */
    FILM("film"),
    /**
     * Specific types of audio with one item per feed, or where items represent chapters within the book.
     */
    AUDIO_BOOK("audiobook"),
    /**
     * Describes a feed of curated written articles. Newsletter articles now sometimes have an spoken version audio enclosure attached.
     */
    NEWSLETTER("newsletter"),
    /**
     * Describes a feed of informally written articles. Similar to newsletter but more informal as in a traditional blog platform style.
     */
    BLOG("blog");

    private final String name;

    MediumType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
