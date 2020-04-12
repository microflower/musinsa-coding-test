package com.musinsa.test.application.service;

import com.musinsa.test.application.repository.ShortenUrlCacheRepository;
import com.musinsa.test.application.repository.ShortenUrlRepository;
import com.musinsa.test.application.vo.ShortenUrl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UrlService {

    private final ShortenUrlRepository shortenUrlRepository;

    public UrlService(ShortenUrlCacheRepository shortenUrlCacheRepository) {
        this.shortenUrlRepository = shortenUrlCacheRepository;
    }

    public ShortenUrl generateShortenUrl(String url) {
        ShortenUrl shortenUrl = shortenUrlRepository.findByUrl(url);

        if (shortenUrl != null) {
            return shortenUrl;
        }
        return save(url);
    }

    private ShortenUrl save(String url) {
        ShortenUrl shortenUrl = ShortenUrl.builder()
                .code(RandomStringUtils.randomAlphabetic(8))
                .url(url)
                .build();

        log.info("save shortenUrl : {}", shortenUrl);

        shortenUrlRepository.save(shortenUrl);
        return shortenUrl;
    }

}
