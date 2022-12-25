package com.github.yusufyilmazfr.podcast4j.response;

import com.github.yusufyilmazfr.podcast4j.entity.Episode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RandomEpisodesResponse extends BaseResponse {
    private List<Episode> episodes;
    private Integer max;
}
