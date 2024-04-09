package org.acfun.comments.observer.web.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表，user_id表示唯一用户
 * </p>
 *
 * @author baomidou
 * @since 2024-04-09
 */
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户状态：0=正常，1=禁用
     */
    private Long state;

    /**
     * 头像地址
     */
    private String avatarImgUrl;

    /**
     * 密码
     */
    private String password;

    /**
     * 逻辑删除
     */
    private Boolean deleted;
}
