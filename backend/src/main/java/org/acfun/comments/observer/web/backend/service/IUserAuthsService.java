package org.acfun.comments.observer.web.backend.service;

import org.acfun.comments.observer.web.backend.entity.UserAuths;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户认证表，不同登录方式关联到同一用户 服务类
 * </p>
 *
 * @author Wang Hongshuo
 * @since 2024-03-25
 */
public interface IUserAuthsService extends IService<UserAuths> {

}