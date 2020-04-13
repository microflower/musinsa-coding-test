package com.musinsa.test.application.service;

import com.musinsa.test.application.repository.ShortenUrlRepository;
import com.musinsa.test.application.repository.entity.ShortenUrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UrlService {

    private final ShortenUrlRepository shortenUrlRepository;

    public UrlService(ShortenUrlRepository shortenUrlRepository) {
        this.shortenUrlRepository = shortenUrlRepository;
    }

    public ShortenUrl generateShortenUrl(String url) {
        ShortenUrl shortenUrl = shortenUrlRepository.findByUrl(url);

        if (shortenUrl != null) {
            return shortenUrl;
        }
        return save(url);
    }

    private ShortenUrl save(String url) {
        ShortenUrl shortenUrl = new ShortenUrl(url);
        shortenUrlRepository.save(shortenUrl);

        log.info("save shortenUrl : {}", shortenUrl);

        return shortenUrl;
    }

}
