package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class Funding {
    /**
     * URL to site to fund the podcast
     */
    private URL url;
    /**
     * Description of url
     */
    private String message;
}
