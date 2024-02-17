package org.acfun.comments.observer.web.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MainPageController {

    @RequestMapping(value = "/")
    public String mainPage(HttpServletResponse response) {
        return "index";
    }
}
