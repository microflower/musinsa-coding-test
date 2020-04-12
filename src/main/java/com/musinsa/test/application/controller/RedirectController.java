package com.musinsa.test.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class RedirectController {

    @RequestMapping("{code}")
    public void redirectUrl(@PathVariable("code") String code, HttpServletResponse response) throws IOException {
        response.sendRedirect("http://naver.com");
    }
}
