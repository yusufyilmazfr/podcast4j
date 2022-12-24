package com.github.yusufyilmazfr.podcast4j.util;

import com.github.yusufyilmazfr.podcast4j.config.Config;

import java.net.http.HttpRequest;
import java.time.Duration;
import java.time.Instant;

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
}
