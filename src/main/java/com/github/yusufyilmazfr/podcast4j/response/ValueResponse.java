package com.github.yusufyilmazfr.podcast4j.response;

import com.github.yusufyilmazfr.podcast4j.entity.Value;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ValueResponse extends BaseResponse {
    private Value value;
    private Map<String, String> query;
}
