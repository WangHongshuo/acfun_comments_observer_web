package org.acfun.comments.observer.web.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.acfun.comments.observer.web.backend.entity.Comment;
import org.acfun.comments.observer.web.backend.entity.RestBean;
import org.acfun.comments.observer.web.backend.service.ICommentService;
import org.acfun.comments.observer.web.backend.utils.addr.IPGetter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/backend/comment")
public class CommentController {

    @Resource
    private ICommentService commentService;

    private Cache<String, AtomicInteger> searchFreqRestrictionCache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.SECONDS).maximumSize(1000).build();

    private Cache<String, String> commentsCache = Caffeine.newBuilder().maximumSize(100).build();

    @PostMapping("query")
    public RestBean<String> query(@RequestBody Comment entity, HttpServletRequest request) {
        // search frequency restriction
        String requestAddr = "freq" + IPGetter.getIpAddr(request);
        if (searchFreqRestrictionCache.get(requestAddr, t -> new AtomicInteger(0)).intValue() >= 2) {
            return RestBean.failure(500, "请休息下再搜索");
        }

        // comments local cache
        String commentCacheKey = String.valueOf(entity.getAid()) + "-" + String.valueOf(entity.getFloorNumber());
        String cachedComment = commentsCache.getIfPresent(commentCacheKey);
        if (cachedComment != null && cachedComment.length() > 0) {
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
        return new String("test");
    }

    private void incSearchFreqRestrictionCache(String requestAddr) {
        AtomicInteger count = searchFreqRestrictionCache.get(requestAddr, t -> new AtomicInteger(0));
        count.incrementAndGet();
        searchFreqRestrictionCache.put(requestAddr, count);
    }
}
