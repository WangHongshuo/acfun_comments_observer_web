package org.acfun.comments.observer.web.backend.service.impl;

import org.acfun.comments.observer.web.backend.entity.Article;
import org.acfun.comments.observer.web.backend.mapper.ArticleMapper;
import org.acfun.comments.observer.web.backend.service.IArticleService;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
