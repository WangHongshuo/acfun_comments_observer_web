package org.acfun.comments.observer.web.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.acfun.comments.observer.web.backend.entity.Comment;
import org.acfun.comments.observer.web.backend.entity.RestBean;
import org.acfun.comments.observer.web.backend.service.ICommentService;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Wang Hongshuo
 * @since 2024-02-16
 */
@RestController
@RequestMapping("/backend/comment")
public class CommentController {

    @Resource
    private ICommentService commentService;

    @RequestMapping("query")
    public RestBean<Comment> query(@RequestBody Comment entity, HttpSession session) {
        Comment record = commentService.getOne(
                new QueryWrapper<Comment>().eq("aid", entity.getAid()).eq("floor_number", entity.getFloorNumber()));

        if (record == null) {
            return RestBean.failure(404, "评论不存在");
        }
        return RestBean.success(record);
    }

    @RequestMapping("test")
    public String test() {
        return new String("test");
    }

}
