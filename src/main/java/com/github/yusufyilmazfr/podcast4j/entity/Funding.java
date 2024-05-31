package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Funding {
    /**
     * URL to site to fund the podcast
     */
    private String url;
    /**
     * Description of url
     */
    private String message;
}
