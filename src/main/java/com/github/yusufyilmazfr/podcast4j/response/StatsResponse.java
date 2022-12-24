package com.github.yusufyilmazfr.podcast4j.response;

import com.github.yusufyilmazfr.podcast4j.entity.Stats;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatsResponse extends BaseResponse {
    private Stats stats;
}
