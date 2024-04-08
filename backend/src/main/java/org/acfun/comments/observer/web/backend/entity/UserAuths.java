package org.acfun.comments.observer.web.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户认证表，不同登录方式关联到同一用户
 * </p>
 *
 * @author Wang Hongshuo
 * @since 2024-04-08
 */
@Getter
@Setter
@TableName("user_auths")
public class UserAuths implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 身份唯一标识，如账号，邮箱，手机号等
     */
    private String identifier;

    /**
     * 身份唯一标识类别：0=无效，1=账号，2=邮箱
     */
    private Integer identifierType;

    /**
     * 逻辑删除
     */
    private Boolean deleted;
}
