package com.github.yusufyilmazfr.podcast4j.arg.service.recent;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class EpisodesArg {
    /**
     * Maximum number of results to return.
     */
    private Integer max;
    /**
     * If you pass a PodcastIndex Episode ID, you will get recent episodes before that ID,
     * allowing you to walk back through the episode history sequentially.
     */
    private Long before;
    /**
     * If present, return the full text value of any text fields (ex: `description`).
     * If not provided, field value is truncated to 100 words.
     * Parameter shall not have a value
     */
    private Boolean fullText;
    /**
     * Any item containing this string will be discarded from the result set.
     * This may, in certain cases, reduce your set size below your `max` value.
     * Matches against the `title` and URL properties.
     */
    private String excludeString;

    public Map<String, Object> toParams() {
        Map<String, Object> map = new HashMap<>();
        map.put("max", max);
        map.put("before", before);
        map.put("fulltext", fullText);
        map.put("excludeString", excludeString);

        return map;
    }
}
