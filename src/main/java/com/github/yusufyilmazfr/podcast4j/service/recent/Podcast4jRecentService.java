package com.github.yusufyilmazfr.podcast4j.service.recent;

import com.github.yusufyilmazfr.podcast4j.arg.service.recent.EpisodesArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.FeedsArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.NewFeedsArg;
import com.github.yusufyilmazfr.podcast4j.entity.Episode;
import com.github.yusufyilmazfr.podcast4j.entity.Feed;
import com.github.yusufyilmazfr.podcast4j.entity.NewFeed;
import com.github.yusufyilmazfr.podcast4j.entity.SoundBite;

import java.io.IOException;
import java.util.List;

public interface Podcast4jRecentService {

    List<Feed> getFeeds(FeedsArg arg) throws IOException, InterruptedException;

    List<NewFeed> getNewFeeds(NewFeedsArg arg) throws IOException, InterruptedException;

    List<SoundBite> getSoundBites(int max) throws IOException, InterruptedException;

    List<Episode> getEpisodes(EpisodesArg arg) throws IOException, InterruptedException;
}
