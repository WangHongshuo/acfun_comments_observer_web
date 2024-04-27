package org.acfun.comments.observer.web.backend.domain.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.annotation.Resource;
import org.acfun.comments.observer.web.backend.entity.User;
import org.acfun.comments.observer.web.backend.service.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username), true);
        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), null);
    }

}
