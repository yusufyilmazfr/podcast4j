package com.github.yusufyilmazfr.podcast4j.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.yusufyilmazfr.podcast4j.entity.Episode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EpisodesResponse extends BaseResponse {
    @JsonProperty("items")
    private List<Episode> episodes;
    private String query;
}
