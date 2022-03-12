package com.youlixiang.blog.user.service.impl;

import com.youlixiang.blog.user.entity.BlogUser;
import com.youlixiang.blog.user.mapper.BlogUserMapper;
import com.youlixiang.blog.user.service.BlogUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 郭非
 * @since 2022-03-12
 */
@Service
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements BlogUserService {

}
