package com.github.yusufyilmazfr.podcast4j.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.yusufyilmazfr.podcast4j.entity.SoundBite;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SoundBiteResponse extends BaseResponse {
    @JsonProperty("items")
    private List<SoundBite> soundBites;
}
