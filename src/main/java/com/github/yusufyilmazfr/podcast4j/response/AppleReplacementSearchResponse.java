package com.github.yusufyilmazfr.podcast4j.response;

import com.github.yusufyilmazfr.podcast4j.entity.AppleReplacementSearch;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AppleReplacementSearchResponse {
    private Integer resultCount;
    private List<AppleReplacementSearch> results;
}
