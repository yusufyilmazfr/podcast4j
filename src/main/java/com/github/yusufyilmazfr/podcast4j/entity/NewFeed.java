package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.net.URL;

@Getter
@Setter
@ToString
public class NewFeed {
    private int id;
    private URL url;
    private long timeAdded;
    private String status;
    private String contentHash;
    private String language;
    private URL image;
}
