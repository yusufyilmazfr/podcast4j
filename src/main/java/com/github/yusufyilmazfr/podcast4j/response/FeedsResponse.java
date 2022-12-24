package com.github.yusufyilmazfr.podcast4j.response;

import com.github.yusufyilmazfr.podcast4j.entity.Feed;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedsResponse extends BaseResponse {
    private List<Feed> feeds;
    private Integer max;
    private Long since;
}
