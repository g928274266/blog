package com.youlixiang.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlixiang.blog.entity.BlogArticle;
import com.youlixiang.blog.entity.BlogArticleContent;
import com.youlixiang.blog.mapper.BlogArticleContentMapper;
import com.youlixiang.blog.mapper.BlogArticleMapper;
import com.youlixiang.blog.service.BlogArticleContentService;
import com.youlixiang.blog.vo.BlogArticleContentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 郭非
 * @since 2022-03-16
 */
@Service
public class BlogArticleContentServiceImpl extends ServiceImpl<BlogArticleContentMapper, BlogArticleContent> implements BlogArticleContentService {
    @Resource
    private BlogArticleMapper blogArticleMapper;
    @Resource
    private BlogArticleContentMapper blogArticleContentMapper;

    @Override
    public BlogArticleContentVO getArticleContent(Integer articleId) {
        BlogArticle blogArticle = blogArticleMapper.selectById(articleId);

        BlogArticleContentVO contentVO = new BlogArticleContentVO();

        if (blogArticle != null) {
            Long viewCount = blogArticle.getViewCount();
            viewCount += 1;
            blogArticle.setViewCount(viewCount);
            blogArticleMapper.updateById(blogArticle);

            BlogArticleContent articleContent = blogArticleContentMapper.selectById(articleId);

            if (articleContent != null) {
                BeanUtils.copyProperties(blogArticle, contentVO);
                contentVO.setContent(articleContent.getContent());
                contentVO.setModifiedTime(articleContent.getGmtModified());
            }
        }

        return contentVO;
    }
}
