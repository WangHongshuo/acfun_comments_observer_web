package org.acfun.comments.observer.web.backend.service.impl;

import org.acfun.comments.observer.web.backend.entity.UserAuths;
import org.acfun.comments.observer.web.backend.mapper.UserAuthsMapper;
import org.acfun.comments.observer.web.backend.service.IUserAuthsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
