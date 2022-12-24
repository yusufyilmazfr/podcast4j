package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Stats {
    private int feedCountTotal;
    private int episodeCountTotal;
    private int feedsWithNewEpisodes3days;
    private int feedsWithNewEpisodes10days;
    private int feedsWithNewEpisodes30days;
    private int feedsWithNewEpisodes90days;
    private int feedsWithValueBlocks;
}
