package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.net.URL;

@Getter
@Setter
@ToString
public class SoundBite {
    private URL enclosureUrl;
    private String title;
    private int startTime;
    private int duration;
    private long episodeId;
    private String episodeTitle;
    private String feedTitle;
    private URL feedUrl;
    private int feedId;
}
