package org.acfun.comments.observer.web.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import jakarta.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

import org.acfun.comments.observer.web.backend.entity.Comment;
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
    public Map<String, Object> query(@RequestBody Comment entity) {

        Map<String, Object> result = new HashMap<>();
        Comment record = commentService.getOne(
                new QueryWrapper<Comment>().eq("aid", entity.getAid()).eq("floor_number", entity.getFloorNumber()));

        if (record == null) {
            result.put("retCode", -1);
            return result;
        }
        result.put("retCode", 0);
        result.put("comment", record.getComment());
        return result;
    }

}
