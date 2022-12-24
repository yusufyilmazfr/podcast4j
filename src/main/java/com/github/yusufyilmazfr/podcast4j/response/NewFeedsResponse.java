package com.github.yusufyilmazfr.podcast4j.response;

import com.github.yusufyilmazfr.podcast4j.entity.NewFeed;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewFeedsResponse extends BaseResponse {
    private int max;
    private List<NewFeed> feeds;
}
