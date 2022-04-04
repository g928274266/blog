package com.youlixiang.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlixiang.blog.entity.BlogArticleContent;
import com.youlixiang.blog.mapper.BlogArticleContentMapper;
import com.youlixiang.blog.service.BlogArticleContentService;
import org.springframework.stereotype.Service;

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

}
