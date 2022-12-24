package com.github.yusufyilmazfr.podcast4j.arg.service.recent;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class NewFeedsArg {
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
     * The PodcastIndex Feed ID to start from (or go to if `desc` specified).
     * If `since` parameter also specified, value of `since` is ignored.
     */
    private Integer feedId;
    /**
     * If present, display feeds in descending order.
     * Only applicable when using `feedid` parameter.
     * Parameter shall not have a value
     */
    private Boolean desc;

    public Map<String, Object> toParams() {
        Map<String, Object> map = new HashMap<>();
        map.put("max", max);
        map.put("since", since);
        map.put("feedid", feedId);
        map.put("desc", desc);

        return map;
    }
}
