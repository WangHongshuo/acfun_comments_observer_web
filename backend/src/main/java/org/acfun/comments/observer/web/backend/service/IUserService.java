package org.acfun.comments.observer.web.backend.service;

import java.util.List;

import org.acfun.comments.observer.web.backend.entity.Permission;
import org.acfun.comments.observer.web.backend.entity.User;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表，user_id表示唯一用户 服务类
 * </p>
 *
 * @author baomidou
 * @since 2024-04-09
 */
public interface IUserService extends IService<User> {
    List<Permission> getPermissionsByUsername(String username);

    List<Permission> getPermissionsById(Long Id);

    List<Permission> getPermissionsByUser(User user);
}
