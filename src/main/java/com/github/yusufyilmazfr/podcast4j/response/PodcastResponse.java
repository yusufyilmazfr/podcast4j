package com.github.yusufyilmazfr.podcast4j.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.yusufyilmazfr.podcast4j.entity.Podcast;
import com.github.yusufyilmazfr.podcast4j.util.PodcastDeserializer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PodcastResponse extends BaseResponse {
    @JsonProperty("feed")
    @JsonDeserialize(using = PodcastDeserializer.class)
    private Podcast podcast;
}
