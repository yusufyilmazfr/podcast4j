package com.github.yusufyilmazfr.podcast4j.util;

import com.github.yusufyilmazfr.podcast4j.config.Config;

import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

import static com.github.yusufyilmazfr.podcast4j.util.SecurityUtil.toSHA1;

public final class HttpRequestUtil {
    public static HttpRequest.Builder with(Config config) {
        long epochSeconds = Instant
                .now()
                .getEpochSecond();

        String data4Hash = config.getAuthKey() + config.getSecret() + epochSeconds;
        String hashString = toSHA1(data4Hash);

        return HttpRequest.newBuilder()
                .timeout(Duration.ofMillis(config.getTimeOut()))
                .header("X-Auth-Date", String.valueOf(epochSeconds))
                .header("X-Auth-Key", config.getAuthKey())
                .header("Authorization", hashString)
                .header("User-Agent", config.getUserAgent());
    }

    public static String toQueryParams(Map<String, Object> data) {
        var builder = new StringBuilder();

        for (Map.Entry<String, Object> entry : data.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }

            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }

        return builder.toString();
    }
}
