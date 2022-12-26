package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class Transcript {
    /**
     * URL of the podcast transcript.
     */
    private URL url;
    /**
     * Allowed:
     * <ul>
     *     <li>application/json</li>
     *     <li>application/srt</li>
     *     <li>text/html</li>
     *     <li>text/plain</li>
     *     <li>text/srt</li>
     *     <li>text/vtt</li>
     * </ul>
     */
    String type;
}
