package com.youlixiang.blog.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.youlixiang.blog.entity.BlogArticleContent;
import com.youlixiang.blog.vo.BlogArticleContentVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 郭非
 * @since 2022-03-16
 */
public interface BlogArticleContentService extends IService<BlogArticleContent> {
    /**
     * 获取文章内容
     *
     * @param articleId 文章编号
     * @return 文章内容信息
     */
    BlogArticleContentVO getArticleContent(Integer articleId);
}
