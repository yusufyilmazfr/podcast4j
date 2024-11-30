package com.github.yusufyilmazfr.podcast4j.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.yusufyilmazfr.podcast4j.entity.Podcast;

import java.io.IOException;

public class PodcastDeserializer extends JsonDeserializer<Podcast> {

    @Override
    public Podcast deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        // handle empty array when no feed
        if (node.isArray() && node.isEmpty()) {
            return null;
        }
        return jsonParser.getCodec().treeToValue(node, Podcast.class);
    }
}
