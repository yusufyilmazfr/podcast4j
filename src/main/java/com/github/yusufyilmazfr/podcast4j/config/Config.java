package com.github.yusufyilmazfr.podcast4j.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;

import java.net.ProxySelector;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.*;

@Getter
@Builder
public class Config implements Cloneable {
    private String authKey;
    private String secret;
    private String userAgent;
    private int timeOut;
    private ObjectMapper objectMapper;
    private ProxySelector proxySelector;

    public int getTimeOut() {
        return timeOut == 0 ? DEFAULT_HTTP_TIMEOUT : timeOut;
    }

    public String getUserAgent() {
        return userAgent == null ? DEFAULT_USER_AGENT : userAgent;
    }

    public ProxySelector getProxySelector() {
        return proxySelector;
    }

    public Config clone() {
        return Config.builder()
                     .authKey(authKey)
                     .secret(secret)
                     .userAgent(userAgent)
                     .timeOut(timeOut)
                     .objectMapper(objectMapper)
                     .proxySelector(proxySelector)
                     .build();
    }
}
