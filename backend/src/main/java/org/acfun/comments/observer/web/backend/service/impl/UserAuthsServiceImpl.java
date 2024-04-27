package org.acfun.comments.observer.web.backend.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.acfun.comments.observer.web.backend.entity.User;
import org.acfun.comments.observer.web.backend.entity.UserAuths;
import org.acfun.comments.observer.web.backend.mapper.UserAuthsMapper;
import org.acfun.comments.observer.web.backend.service.IUserAuthsService;
import org.acfun.comments.observer.web.backend.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户认证表，不同登录方式关联到同一用户 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2024-04-09
 */
@Service
public class UserAuthsServiceImpl extends ServiceImpl<UserAuthsMapper, UserAuths> implements IUserAuthsService {

    @Resource
    private UserAuthsMapper userAuthsMapper;

    @Resource
    private IUserService userService;

    public User getUserByIdentifier(String identifier) {
        UserAuths userAuths = userAuthsMapper.selectOne(Wrappers.<UserAuths>lambdaQuery().eq(UserAuths::getIdentifier, identifier));
        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserId, userAuths.getUserId()));
        return user;
    }
}
