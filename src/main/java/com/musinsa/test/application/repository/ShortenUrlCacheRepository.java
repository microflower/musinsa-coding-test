package com.musinsa.test.application.repository;

import com.musinsa.test.application.vo.ShortenUrl;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class ShortenUrlCacheRepository implements ShortenUrlRepository {

    @Override
    @Cacheable(value = "shortenUrl", key = "#url")
    public ShortenUrl findByUrl(String url) {
        return null;
    }

    @Override
    @CachePut(value = "shortenUrl", key = "#shortenUrl.url")
    public ShortenUrl save(ShortenUrl shortenUrl) {
        return shortenUrl;
    }
}
