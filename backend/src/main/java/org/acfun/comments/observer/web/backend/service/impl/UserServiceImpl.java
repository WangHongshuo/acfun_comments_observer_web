package org.acfun.comments.observer.web.backend.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.acfun.comments.observer.web.backend.entity.Permission;
import org.acfun.comments.observer.web.backend.entity.RolePermission;
import org.acfun.comments.observer.web.backend.entity.UserRole;
import org.acfun.comments.observer.web.backend.entity.User;
import org.acfun.comments.observer.web.backend.mapper.UserMapper;
import org.acfun.comments.observer.web.backend.service.IPermissionService;
import org.acfun.comments.observer.web.backend.service.IRolePermissionService;
import org.acfun.comments.observer.web.backend.service.IRoleService;
import org.acfun.comments.observer.web.backend.service.IUserRoleService;
import org.acfun.comments.observer.web.backend.service.IUserService;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表，user_id表示唯一用户 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2024-04-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private IRoleService roleService;

    @Resource
    private IUserRoleService userRoleService;

    @Resource
    private IRolePermissionService rolePermissionService;

    @Resource
    private IPermissionService permissionService;

    public List<Permission> getPermissionsByUsername(String username) {
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
        return this.getPermissionsByUser(user);
    }

    public List<Permission> getPermissionsById(Long Id) {
        User user = userMapper.selectById(Id);
        return this.getPermissionsByUser(user);
    }

    public List<Permission> getPermissionsByUser(User user) {
        List<Permission> permissions = new ArrayList<>();
        if (user == null) {
            return permissions;
        }
        List<UserRole> userRoles = userRoleService
                .list(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, user.getUserId()));

        if (CollectionUtils.isEmpty(userRoles)) {
            return permissions;
        }

        List<Long> roleIds = new ArrayList<>();
        userRoles.stream().forEach(userRole -> {
            roleIds.add(userRole.getRoleId());
        });

        List<RolePermission> rolePermissions = rolePermissionService
                .list(Wrappers.<RolePermission>lambdaQuery().in(RolePermission::getRoleId, roleIds));
        if (CollectionUtils.isEmpty(rolePermissions)) {
            return permissions;
        }
        List<Long> permissionIds = new ArrayList<>();
        rolePermissions.stream().forEach(rolePermission -> {
            permissionIds.add(rolePermission.getPermissionId());
        });

        permissions = permissionService.list(Wrappers.<Permission>lambdaQuery().in(Permission::getId, permissionIds));

        return permissions;
    }
}
