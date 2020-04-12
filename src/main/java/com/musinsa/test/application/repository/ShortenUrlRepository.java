package com.musinsa.test.application.repository;

import com.musinsa.test.application.vo.ShortenUrl;

public interface ShortenUrlRepository {

    ShortenUrl findByUrl(String url);

    ShortenUrl save(ShortenUrl shortenUrl);
}
