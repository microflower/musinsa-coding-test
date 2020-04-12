package com.musinsa.test.application.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ShortenUrl {
    private String code;
    private String url;
    private int requestCount;
}
