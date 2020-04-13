package com.musinsa.test.application.repository

import com.musinsa.test.application.repository.entity.ShortenUrl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class ShortenUrlRepositoryTest extends Specification {
    @Autowired
    ShortenUrlRepository urlRepository

    def "shortenUrl save, find test"() {
        given:
        def shortenUrl = new ShortenUrl(
                code: "ASDASDAS",
                url: "http://testurl.com"
        )
        urlRepository.save(shortenUrl)

        when:
        ShortenUrl find = urlRepository.findById(shortenUrl.getId()).get()

        then:
        find.id == 1
        find.code == "ASDASDAS"
        find.url == "http://testurl.com"
        find.requestCount == 0
    }
}
