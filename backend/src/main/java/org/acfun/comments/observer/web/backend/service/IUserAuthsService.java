package org.acfun.comments.observer.web.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.acfun.comments.observer.web.backend.entity.User;
import org.acfun.comments.observer.web.backend.entity.UserAuths;

/**
 * <p>
 * 用户认证表，不同登录方式关联到同一用户 服务类
 * </p>
 *
 * @author baomidou
 * @since 2024-04-09
 */
public interface IUserAuthsService extends IService<UserAuths> {
    User getUserByIdentifier(String username);
}
