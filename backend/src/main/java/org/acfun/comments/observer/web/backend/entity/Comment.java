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
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Comment ID
     */
    @TableId("cid")
    private Long cid;

    /**
     * Article ID
     */
    private Long aid;

    /**
     * Floor Number
     */
    private Integer floorNumber;

    /**
     * Comment
     */
    private String comment;

    /**
     * Is Delete
     */
    private Boolean isDel;

    /**
     * The number of reports of harmful information
     */
    private Long harmInfoReportCnt;
}
