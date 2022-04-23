package com.youlixiang.blog.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.youlixiang.blog.entity.BlogArticle;
import com.youlixiang.blog.exception.CustomException;
import com.youlixiang.blog.vo.BlogArticlePublishVO;
import com.youlixiang.blog.vo.BlogArticleVO;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 郭非
 * @since 2022-03-16
 */
public interface BlogArticleService extends IService<BlogArticle> {
    /**
     * 查询文章列表
     *
     * @param current       当前页
     * @param limit         页面大小
     * @param blogArticleVO 查询条件
     * @return 文章信息集合
     */
    Map<String, Object> listArticle(Long current, Long limit, BlogArticleVO blogArticleVO);

    /**
     * 发布文章
     *
     * @param publishVO 文章信息
     * @throws CustomException 异常
     */
    void publishArticle(BlogArticlePublishVO publishVO) throws CustomException;
}
