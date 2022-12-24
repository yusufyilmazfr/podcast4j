package com.github.yusufyilmazfr.podcast4j.config;

import lombok.Builder;
import lombok.Getter;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.*;

@Getter
@Builder
public class Config implements Cloneable {
    private String authKey;
    private String secret;
    private String userAgent;
    private int timeOut;

    public int getTimeOut() {
        return timeOut == 0 ? DEFAULT_HTTP_TIMEOUT : timeOut;
    }

    public String getUserAgent() {
        return userAgent == null ? DEFAULT_USER_AGENT : userAgent;
    }

    public Config clone() {
        return Config.builder()
                     .authKey(authKey)
                     .secret(secret)
                     .userAgent(userAgent)
                     .timeOut(timeOut)
                     .build();
    }
}
