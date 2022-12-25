package com.github.yusufyilmazfr.podcast4j.response;

import com.github.yusufyilmazfr.podcast4j.entity.Episode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EpisodeResponse extends BaseResponse{
    private Episode episode;
    private Integer id;
}
