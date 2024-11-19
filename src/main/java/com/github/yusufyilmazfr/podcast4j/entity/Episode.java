package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.net.URL;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class Episode {
    private Long id;
    private String title;
    private URL link;
    private String description;
    private String guid;
    private Long datePublished;
    private String datePublishedPretty;
    private Long dateCrawled;
    private URL enclosureUrl;
    private String enclosureType;
    private Integer enclosureLength;
    private Integer duration;
    private Integer explicit;
    private Integer episode;
    private String episodeType;
    private Integer season;
    private URL image;
    private String imageUrlHash;
    private Long feedItunesId;
    private URL feedImage;
    private String feedImageUrlHash;
    private Integer feedId;
    private String podcastGuid;
    private String feedUrl;
    private String feedAuthor;
    private String feedTitle;
    private String feedLanguage;
    private Integer feedDead;
    private String feedDuplicateOf;
    private URL chaptersUrl;
    private URL transcriptUrl;
    private Value value;
    private List<Person> persons;
    private List<Transcript> transcripts;
    private Map<Integer, String> categories;
}
