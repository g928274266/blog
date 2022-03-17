package com.youlixiang.blog.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlixiang.blog.article.entity.BlogArticle;
import com.youlixiang.blog.article.entity.BlogType;
import com.youlixiang.blog.article.mapper.BlogArticleMapper;
import com.youlixiang.blog.article.mapper.BlogTypeMapper;
import com.youlixiang.blog.article.service.BlogArticleService;
import com.youlixiang.blog.article.vo.BlogArticleVO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 郭非
 * @since 2022-03-16
 */
@Service
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements BlogArticleService {
    @Resource
    private BlogArticleMapper blogArticleMapper;

    @Override
    public List<BlogArticleVO> listArticle(Long current, Long limit, BlogArticleVO blogArticleVO) {
        return blogArticleMapper.listArticle(current,limit,blogArticleVO);
    }
}
