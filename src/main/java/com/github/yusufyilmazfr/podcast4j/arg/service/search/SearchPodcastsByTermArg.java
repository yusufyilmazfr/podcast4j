package com.github.yusufyilmazfr.podcast4j.arg.service.search;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class SearchPodcastsByTermArg {

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
     * Only returns feeds with an itunesId.
     */
    private Boolean aponly;
    /**
     * If present, only non-explicit feeds will be returned. Meaning, feeds where the itunes:explicit flag is set to false.
     * Parameter shall not have a value
     */
    private Boolean clean;
    /**
     * If present, include similar matches in search response. For search/byterm, prioritizes title matches.
     */
    private Boolean similar;
    /**
     * If present, return the full text value of any text fields (ex: `description`).
     * If not provided, field value is truncated to 100 words.
     * Parameter shall not have a value
     */
    private Boolean fulltext;

    public Map<String, Object> toParams() {
        Map<String, Object> map = new HashMap<>();
        map.put("q", q);
        map.put("val", val);
        map.put("max", max);
        map.put("aponly", aponly);
        map.put("clean", clean);
        map.put("similar", similar);
        map.put("fulltext", fulltext);

        return map;
    }
}
