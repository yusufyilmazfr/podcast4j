package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Stats {
    private Integer feedCountTotal;
    private Integer episodeCountTotal;
    private Integer feedsWithNewEpisodes3days;
    private Integer feedsWithNewEpisodes10days;
    private Integer feedsWithNewEpisodes30days;
    private Integer feedsWithNewEpisodes90days;
    private Integer feedsWithValueBlocks;
}
