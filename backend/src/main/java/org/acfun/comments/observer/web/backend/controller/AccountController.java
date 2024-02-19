package org.acfun.comments.observer.web.backend.controller;

import org.acfun.comments.observer.web.backend.entity.Account;
import org.acfun.comments.observer.web.backend.service.IAccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import jakarta.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Wang Hongshuo
 * @since 2024-02-17
 */
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
