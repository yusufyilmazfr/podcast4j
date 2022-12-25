package com.github.yusufyilmazfr.podcast4j.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.yusufyilmazfr.podcast4j.entity.Podcast;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PodcastResponse extends BaseResponse {
    @JsonProperty("feed")
    private Podcast podcast;
}
