package com.musinsa.test.application.repository;

import com.musinsa.test.application.repository.entity.ShortenUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortenUrlRepository extends JpaRepository<ShortenUrl, Long> {

    ShortenUrl findByUrl(String url);

    ShortenUrl findByCode(String code);
}
