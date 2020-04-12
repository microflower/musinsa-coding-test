package com.musinsa.test.application.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching(proxyTargetClass = true)
public class CacheConfig {
//    @Bean
//    public CacheManager cacheManager() {
//        return new ConcurrentMapCacheManager("shortenUrl");
//    }
}
