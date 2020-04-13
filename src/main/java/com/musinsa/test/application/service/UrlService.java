package com.musinsa.test.application.service;

import com.musinsa.test.application.repository.ShortenUrlRepository;
import com.musinsa.test.application.repository.entity.ShortenUrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class UrlService {

    private final ShortenUrlRepository shortenUrlRepository;

    public UrlService(ShortenUrlRepository shortenUrlRepository) {
        this.shortenUrlRepository = shortenUrlRepository;
    }

    @Transactional
    public ShortenUrl generateShortenUrl(String url) {
        ShortenUrl shortenUrl = shortenUrlRepository.findByUrl(url);
        if (shortenUrl != null) {
            return shortenUrl;
        }
        return save(url);
    }

    @Transactional
    public String getOriginUrl(String code) {
        ShortenUrl shortenUrl = shortenUrlRepository.findByCode(code);
        if (shortenUrl == null) {
            return null;
        }
        shortenUrl.requested();
        return shortenUrl.getUrl();
    }

    private ShortenUrl save(String url) {
        ShortenUrl shortenUrl = new ShortenUrl(url);
        shortenUrlRepository.save(shortenUrl);

        log.info("save shortenUrl : {}", shortenUrl);

        return shortenUrl;
    }

}
