package com.musinsa.test.application.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@DynamicUpdate
@ToString
public class ShortenUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "url", unique = true, nullable = false)
    private String url;

    @Column(name = "request_count")
    private int requestCount;

    public ShortenUrl(String url) {
        this.code = RandomStringUtils.randomAlphabetic(8); //fixme: insert 시 중복 키 에러 발생할 수 있음
        this.url = url;
    }

    public void requested() {
        requestCount++;
    }
}
