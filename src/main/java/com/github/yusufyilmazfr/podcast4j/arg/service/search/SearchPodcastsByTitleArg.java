package com.github.yusufyilmazfr.podcast4j.arg.service.search;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class SearchPodcastsByTitleArg {

    /**
     * (Required) Terms to search for
     */
    private String q;
    /**
     * Only returns feeds with a value block of the specified type. Use any to return feeds with any value block.
     * <p>
     * Allowed:
     * <ul>
     *     <li>any</li>
     *     <li>lightning</li>
     *     <li>hive</li>
     *     <li>webmonetization</li>
     * </ul>
     */
    private String val;
    /**
     *Maximum number of results to return.
     *
     * Examples: 10
     */
    private Integer max;
    /**
     * If present, only non-explicit feeds will be returned. Meaning, feeds where the itunes:explicit flag is set to false.
     * Parameter shall not have a value
     */
    private Boolean clean;
    /**
     * If present, return the full text value of any text fields (ex: `description`).
     * If not provided, field value is truncated to 100 words.
     * Parameter shall not have a value
     */
    private Boolean fulltext;
    /**
     * If present, include similar matches in search response
     */
    private Boolean similar;

    public Map<String, Object> toParams() {
        Map<String, Object> map = new HashMap<>();
        map.put("q", q);
        map.put("val", val);
        map.put("max", max);
        map.put("clean", clean);
        map.put("fulltext", fulltext);
        map.put("similar", similar);

        return map;
    }
}

