package com.github.yusufyilmazfr.podcast4j.service.search;

import com.github.yusufyilmazfr.podcast4j.arg.service.search.SearchPodcastsByTermArg;
import com.github.yusufyilmazfr.podcast4j.arg.service.search.SearchPodcastsByTitleArg;
import com.github.yusufyilmazfr.podcast4j.entity.Podcast;

import java.io.IOException;
import java.util.List;

public interface Podcast4jSearchService {
    List<Podcast> searchPodcastsByTerm(SearchPodcastsByTermArg arg) throws IOException, InterruptedException;

    List<Podcast> searchPodcastsByTitle(SearchPodcastsByTitleArg arg) throws IOException, InterruptedException;
}
