package com.youlixiang.blog.comment.service.impl;

import com.youlixiang.blog.comment.entity.BlogComment;
import com.youlixiang.blog.comment.mapper.BlogCommentMapper;
import com.youlixiang.blog.comment.service.BlogCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 郭非
 * @since 2022-03-13
 */
@Service
public class BlogCommentServiceImpl extends ServiceImpl<BlogCommentMapper, BlogComment> implements BlogCommentService {

}
