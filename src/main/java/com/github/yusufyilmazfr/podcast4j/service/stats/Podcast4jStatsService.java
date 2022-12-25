package com.github.yusufyilmazfr.podcast4j.service.stats;

import com.github.yusufyilmazfr.podcast4j.entity.Stats;

import java.io.IOException;

public interface Podcast4jStatsService {
    Stats get() throws IOException, InterruptedException;
}
