package com.musinsa.test.application.service

import com.musinsa.test.application.repository.ShortenUrlRepository
import com.musinsa.test.application.repository.entity.ShortenUrl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import javax.transaction.Transactional

@Transactional
@SpringBootTest
class UrlServiceTest extends Specification {

    @Autowired
    ShortenUrlRepository shortenUrlRepository

    UrlService service

    def setup() {
        service = new UrlService(shortenUrlRepository)
    }

    def "URL Shortening Code를 8 Character 로 생성한다"() {
        given:
        def url = "http://test.com"

        when:
        def shortenUrl = service.generateShortenUrl(url)

        then:
        shortenUrl.url == url
        shortenUrl.code.length() == 8
    }

    def "동일 URL에 대한 요청은 동일 Code로 응답한다"() {
        when:
        def shortenUrl1 = service.generateShortenUrl(url1)
        def shortenUrl2 = service.generateShortenUrl(url2)

        then: '동일 entity'
        shortenUrl1.id == shortenUrl2.id
        shortenUrl1.url == shortenUrl2.url
        shortenUrl1.code == shortenUrl2.code

        where:
        url1              | url2
        "http://test.com" | "http://test.com"
    }

    def "다른 URL에 대한 요청은 다른 Code로 응답한다"() {
        when:
        def shortenUrl1 = service.generateShortenUrl(url1)
        def shortenUrl2 = service.generateShortenUrl(url2)

        then: '다른 entity'
        shortenUrl1.id != shortenUrl2.id
        shortenUrl1.url != shortenUrl2.url
        shortenUrl1.code != shortenUrl2.code

        where:
        url1              | url2
        "http://test.com" | "http://google.com"
    }

    def "Shortening Code로 저장된 url을 조회한다"() {
        given:
        def url = "http://test.com"
        def shortenUrl = new ShortenUrl(url)
        shortenUrlRepository.save(shortenUrl)
        def code = shortenUrl.code

        when:
        def originUrl = service.getOriginUrl(code)

        then:
        originUrl == url
    }

    def "Shortening Code로 저장된 url을 조회하는 경우 요청 수가 증가한다"() {
        given:
        def url = "http://test.com"
        def shortenUrl = new ShortenUrl(url)
        shortenUrlRepository.save(shortenUrl)
        def code = shortenUrl.code
        def id = shortenUrl.id

        when:
        for(int i=0; i<count; i++) {
            service.getOriginUrl(code)
        }
        def find = shortenUrlRepository.findById(id).get()

        then:
        find.requestCount == count

        where:
        count | _
        1     | _
        5     | _
        10    | _
    }
}
