package com.musinsa.test.application.controller;

import com.musinsa.test.application.exception.NotFoundUrlException;
import com.musinsa.test.application.service.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class RedirectController {

    private final UrlService urlService;

    public RedirectController(UrlService urlService) {
        this.urlService = urlService;
    }

    @RequestMapping("{code}")
    public void redirectUrl(@PathVariable("code") String code, HttpServletResponse response) throws IOException {
        String url = urlService.getOriginUrl(code);
        if (url == null) {
            throw new NotFoundUrlException(code);
        }
        response.sendRedirect(url);
    }
}
