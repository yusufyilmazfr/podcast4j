package com.github.yusufyilmazfr.podcast4j.service.recent;

import com.github.yusufyilmazfr.podcast4j.entity.SoundBite;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface Podcast4jRecentService {
    List<SoundBite> getSoundBites(int max) throws URISyntaxException, IOException, InterruptedException;
}
