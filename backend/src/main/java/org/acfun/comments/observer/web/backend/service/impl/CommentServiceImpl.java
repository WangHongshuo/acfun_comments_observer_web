package org.acfun.comments.observer.web.backend.service.impl;

import org.acfun.comments.observer.web.backend.entity.Comment;
import org.acfun.comments.observer.web.backend.mapper.CommentMapper;
import org.acfun.comments.observer.web.backend.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wang Hongshuo
 * @since 2024-02-16
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
