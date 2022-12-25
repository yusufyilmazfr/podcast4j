package com.github.yusufyilmazfr.podcast4j.service.value;

import com.github.yusufyilmazfr.podcast4j.entity.Value;

import java.io.IOException;

public interface Podcast4jValueService {
    Value getValueByFeedId(Integer feedId) throws IOException, InterruptedException;

    Value getValueByFeedURL(String feedURL) throws IOException, InterruptedException;
}
