package com.github.yusufyilmazfr.podcast4j.arg.service.episode;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class RandomEpisodesArg {
    /**
     * Maximum number of results to return.
     */
    private Integer max;
    /**
     * Specifying a language code (like "en") will return only episodes having that specific language.
     * You can specify multiple languages by separating them with commas.
     * If you also want to return episodes that have no language given, use the token "unknown". (ex. en,es,ja,unknown).
     * Values are not case-sensitive.
     */
    private String lang;
    /**
     * Use this argument to specify that you **ONLY** want episodes with these categories in the results.
     * Separate multiple categories with commas.
     * You may specify either the Category ID and/or the Category Name.
     * Values are not case-sensitive.
     * The `cat` and `notcat` filters can be used together to fine tune a very specific result set.
     * Category numbers and names can be found in the [Podcast Namespace documentation](<a href="https://github.com/Podcastindex-org/podcast-namespace/blob/main/categories.json">categories</a>)
     */
    private String cat;
    /**
     * Use this argument to specify categories of episodes to **NOT** show in the results.
     * Separate multiple categories with commas.
     * You may specify either the Category ID and/or the Category Name.
     * Values are not case-sensitive.
     * The `cat` and `notcat` filters can be used together to fine tune a very specific result set.
     * Category numbers and names can be found in the [Podcast Namespace documentation](<a href="https://github.com/Podcastindex-org/podcast-namespace/blob/main/categories.json">categories</a>)
     */
    private String notCat;
    /**
     * If present, return the full text value of any text fields (ex: `description`).
     * If not provided, field value is truncated to 100 words.
     * Parameter shall not have a value
     */
    private Boolean fullText;

    public Map<String, Object> toParams() {
        Map<String, Object> map = new HashMap<>();
        map.put("max", max);
        map.put("fulltext", fullText);
        map.put("lang", lang);
        map.put("cat", cat);
        map.put("notcat", notCat);

        return map;
    }
}
