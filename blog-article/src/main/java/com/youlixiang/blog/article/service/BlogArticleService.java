package com.youlixiang.blog.article.service;

import com.youlixiang.blog.article.entity.BlogArticle;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlixiang.blog.article.vo.BlogArticleVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郭非
 * @since 2022-03-16
 */
public interface BlogArticleService extends IService<BlogArticle> {

    List<BlogArticleVO> listArticle(Long current, Long limit, BlogArticleVO blogArticleVO);
}
