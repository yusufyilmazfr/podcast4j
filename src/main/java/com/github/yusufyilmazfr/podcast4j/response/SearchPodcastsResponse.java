package com.github.yusufyilmazfr.podcast4j.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.yusufyilmazfr.podcast4j.entity.Podcast;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchPodcastsResponse extends BaseResponse {
    @JsonProperty("feeds")
    private List<Podcast> podcasts;
    private String query;
}
