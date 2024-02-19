package org.acfun.comments.observer.web.backend.controller;

import org.acfun.comments.observer.web.backend.entity.Account;
import org.acfun.comments.observer.web.backend.service.IAccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/backend/account")
public class AccountController {

    @Resource
    private IAccountService accountService;

    @RequestMapping("test")
    public String test() {
        Account account = accountService.getOne(new QueryWrapper<Account>().eq("id", 1));
        return account.getEmail();
    }
}
