package org.acfun.comments.observer.web.backend.service.impl;

import org.acfun.comments.observer.web.backend.entity.User;
import org.acfun.comments.observer.web.backend.mapper.UserMapper;
import org.acfun.comments.observer.web.backend.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表，user_id表示唯一用户 服务实现类
 * </p>
 *
 * @author Wang Hongshuo
 * @since 2024-04-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
