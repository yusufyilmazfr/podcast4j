package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.net.URL;
import java.util.Map;

@Getter
@Setter
@ToString
public class Feed {

    private Integer id;
    private URL url;
    private String title;
    private Long newestItemPublishTime;
    private Long oldestItemPublishTime;
    private String description;
    private URL image;
    private String itunesId;
    private String language;
    private Map<Integer, String> categories;
}
