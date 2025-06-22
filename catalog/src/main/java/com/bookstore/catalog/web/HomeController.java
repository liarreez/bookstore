package com.bookstore.catalog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String getGreeting() {
        return "BookStore에 오신 것을 환영합니다!";
    }
}
