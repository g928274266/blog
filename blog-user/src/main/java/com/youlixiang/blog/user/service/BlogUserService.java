package com.youlixiang.blog.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.youlixiang.blog.user.entity.BlogUser;
import com.youlixiang.blog.user.exception.RegisterException;
import com.youlixiang.blog.user.vo.RegisterVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 郭非
 * @since 2022-03-12
 */
public interface BlogUserService extends IService<BlogUser> {
    /**
     * 用户注册
     *
     * @param registerVo 注册信息
     */
    void register(RegisterVo registerVo) throws RegisterException;
}
