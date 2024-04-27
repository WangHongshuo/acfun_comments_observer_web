package org.acfun.comments.observer.web.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.acfun.comments.observer.web.backend.domain.dto.RestBean;
import org.acfun.comments.observer.web.backend.entity.Comment;
import org.acfun.comments.observer.web.backend.service.ICommentService;
import org.acfun.comments.observer.web.backend.utils.addr.IPGetter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2024-04-09
 */
@RestController
@RequestMapping("/backend/comment")
public class CommentController {

    private final Cache<String, AtomicInteger> searchFreqRestrictionCache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.SECONDS).maximumSize(1000).build();
    private final Cache<String, String> commentsCache = Caffeine.newBuilder().maximumSize(100).build();
    @Resource
    private ICommentService commentService;

    @PostMapping("query")
    public RestBean query(@RequestBody Comment entity, HttpServletRequest request) {
        // search frequency restriction
        String requestAddr = "freq" + IPGetter.getIpAddr(request);
        if (searchFreqRestrictionCache.get(requestAddr, t -> new AtomicInteger(0)).intValue() >= 2) {
            return RestBean.failure(500, "请休息下再搜索");
        }

        // comments local cache
        String commentCacheKey = String.valueOf(entity.getAid()) + "-" + String.valueOf(entity.getFloorNumber());
        String cachedComment = commentsCache.getIfPresent(commentCacheKey);
        if (cachedComment != null && !cachedComment.isEmpty()) {
            incSearchFreqRestrictionCache(requestAddr);
            return RestBean.success("from cache", cachedComment);
        }

        // db
        Comment record = commentService.getOne(
                new QueryWrapper<Comment>().eq("aid", entity.getAid()).eq("floor_number", entity.getFloorNumber()));
        incSearchFreqRestrictionCache(requestAddr);

        if (record == null) {
            return RestBean.failure(404, "评论不存在");
        }

        commentsCache.put(commentCacheKey, record.getComment());
        return RestBean.success(record.getComment());
    }

    @RequestMapping("test")
    public String test() {
        return "test";
    }

    private void incSearchFreqRestrictionCache(String requestAddr) {
        AtomicInteger count = searchFreqRestrictionCache.get(requestAddr, t -> new AtomicInteger(0));
        count.incrementAndGet();
        searchFreqRestrictionCache.put(requestAddr, count);
    }
}
