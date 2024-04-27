package org.acfun.comments.observer.web.backend.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.acfun.comments.observer.web.backend.constant.UserConstants;
import org.acfun.comments.observer.web.backend.domain.dto.RestBean;
import org.acfun.comments.observer.web.backend.domain.dto.UserLogin;
import org.acfun.comments.observer.web.backend.domain.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表，user_id表示唯一用户 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2024-04-09
 */
@RestController
@RequestMapping("/backend/user")
public class UserController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public RestBean login(@RequestBody UserLogin userLogin, HttpServletRequest request) {
        RestBean restBean = RestBean.success();
        String token = loginService.login(userLogin.getUsername(), userLogin.getPassword());
        restBean.put(UserConstants.TAG_TOKEN, token);
        return restBean;
    }
}
