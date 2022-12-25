package com.github.yusufyilmazfr.podcast4j.arg.service.episode;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class ByIdArg {
    /**
     * (Required) The PodcastIndex episode ID to search for.
     */
    private Long id;
    /**
     * If present, return the full text value of any text fields (ex: `description`).
     * If not provided, field value is truncated to 100 words.
     * Parameter shall not have a value
     */
    private Boolean fulltext;

    public Map<String, Object> toParams() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("fulltext", fulltext);

        return map;
    }
}
