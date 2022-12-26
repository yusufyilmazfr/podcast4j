package com.github.yusufyilmazfr.podcast4j.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.yusufyilmazfr.podcast4j.entity.Episode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ByGUIDEpisodeResponse extends BaseResponse {
    private Integer id;
    private String url;
    private String guid;
    private String podcastGuid;
    private Episode episode;
}
