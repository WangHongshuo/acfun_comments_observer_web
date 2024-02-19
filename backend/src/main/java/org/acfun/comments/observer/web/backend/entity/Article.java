package org.acfun.comments.observer.web.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wang Hongshuo
 * @since 2024-02-17
 */
@Getter
@Setter
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Article ID
     */
    @TableId("aid")
    private Long aid;

    /**
     * Last Comment Floor Number
     */
    private Integer lastFloorNumber;

    /**
     * Is get all comments
     */
    private Boolean isCompleted;

    /**
     * Comments Count
     */
    private Integer commentsCount;
}
