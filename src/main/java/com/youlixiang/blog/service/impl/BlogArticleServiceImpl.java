package com.youlixiang.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlixiang.blog.entity.BlogArticle;
import com.youlixiang.blog.mapper.BlogArticleMapper;
import com.youlixiang.blog.service.BlogArticleService;
import com.youlixiang.blog.vo.BlogArticleVO;
import org.springframework.stereotype.Service;

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
        return blogArticleMapper.listArticle(current, limit, blogArticleVO);
    }
}
