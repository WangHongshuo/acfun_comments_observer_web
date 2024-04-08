package org.acfun.comments.observer.web.backend.mapper;

import org.acfun.comments.observer.web.backend.entity.UserAuths;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户认证表，不同登录方式关联到同一用户 Mapper 接口
 * </p>
 *
 * @author Wang Hongshuo
 * @since 2024-04-08
 */
public interface UserAuthsMapper extends BaseMapper<UserAuths> {

}
