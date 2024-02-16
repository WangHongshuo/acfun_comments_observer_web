package org.acfun.comments.observer.web.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class MainPageController {

    @RequestMapping(value = "/")
    public ModelAndView mainPage(HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/html/index.html");
        return modelAndView;
    }
}
