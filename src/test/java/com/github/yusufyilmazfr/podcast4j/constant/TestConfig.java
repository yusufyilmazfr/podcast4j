package com.github.yusufyilmazfr.podcast4j.constant;

import com.github.yusufyilmazfr.podcast4j.config.Config;

public final class TestConfig {
    public static Config getTestConfig() {
        return Config.builder()
                     .secret("HQT8wkdbb5KVMGur$$TmYvg#W6Dgph4nvQkyhV#f")
                     .authKey("CJSXRHDXXTFGKK3DYDNB")
                     .userAgent("SuperPodcastPlayer/1.8")
                     .build();
    }
}
