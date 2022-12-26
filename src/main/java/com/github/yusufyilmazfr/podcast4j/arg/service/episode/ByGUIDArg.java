package com.github.yusufyilmazfr.podcast4j.arg.service.episode;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class ByGUIDArg {
    /**
     * (Required) The guid value for the episode to retrieve.
     * This value is the value specified in the feed's `<guid>` field.
     */
    private String guid;
    /**
     * The PodcastIndex Feed ID
     */
    private Integer feedId;
    /**
     * The Feed URL
     */
    private String feedURL;
    /**
     * If present, return the full text value of any text fields (ex: `description`).
     * If not provided, field value is truncated to 100 words.
     * Parameter shall not have a value
     */
    private Boolean fulltext;

    public Map<String, Object> toParams() {
        Map<String, Object> map = new HashMap<>();
        map.put("guid", guid);
        map.put("feedid", feedId);
        map.put("feedurl", feedURL);
        map.put("fulltext", fulltext);

        return map;
    }
}
