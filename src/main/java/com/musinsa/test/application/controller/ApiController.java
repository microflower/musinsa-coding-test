package com.musinsa.test.application.controller;

import com.musinsa.test.application.repository.entity.ShortenUrl;
import com.musinsa.test.application.service.UrlService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private final UrlService urlService;

    public ApiController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping(value = "/shortenUrl", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShortenUrl shortenUrl(@RequestBody String url) {
        return urlService.generateShortenUrl(url);
    }
}
