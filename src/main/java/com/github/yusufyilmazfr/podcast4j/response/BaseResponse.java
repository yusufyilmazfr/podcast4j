package com.github.yusufyilmazfr.podcast4j.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseResponse {
    private int count;
    private boolean status;
    private String description;
}
