package com.github.yusufyilmazfr.podcast4j.arg.service.episode;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class ByiTunesArg {
    /**
     * (Required) The iTunes Feed ID to search for
     */
    private Long id;
    /**
     * Maximum number of results to return.
     */
    private Integer max;
    /**
     * Return items since the specified time.
     * The value can be a unix epoch timestamp or a negative integer that represents a number of seconds prior to right now.
     */
    private Long since;
    /**
     * If present, return the full text value of any text fields (ex: `description`).
     * If not provided, field value is truncated to 100 words.
     * Parameter shall not have a value
     */
    private Boolean fulltext;

    public Map<String, Object> toParams() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("max", max);
        map.put("since", since);
        map.put("fulltext", fulltext);

        return map;
    }
}
