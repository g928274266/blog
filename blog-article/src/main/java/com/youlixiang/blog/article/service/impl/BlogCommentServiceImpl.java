package com.youlixiang.blog.article.service.impl;

import com.youlixiang.blog.article.entity.BlogComment;
import com.youlixiang.blog.article.mapper.BlogCommentMapper;
import com.youlixiang.blog.article.service.BlogCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 郭非
 * @since 2022-03-16
 */
@Service
public class BlogCommentServiceImpl extends ServiceImpl<BlogCommentMapper, BlogComment> implements BlogCommentService {

}
