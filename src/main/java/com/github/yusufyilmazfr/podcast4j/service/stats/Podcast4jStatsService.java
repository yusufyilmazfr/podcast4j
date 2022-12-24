package com.github.yusufyilmazfr.podcast4j.service.stats;

import com.github.yusufyilmazfr.podcast4j.entity.Stats;

import java.io.IOException;
import java.net.URISyntaxException;

public interface Podcast4jStatsService {
    Stats get() throws URISyntaxException, IOException, InterruptedException;
}
