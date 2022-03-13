package com.youlixiang.blog.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.youlixiang.blog.user.entity.BlogUser;
import com.youlixiang.blog.user.exception.CustomException;
import com.youlixiang.blog.user.vo.LoginVO;
import com.youlixiang.blog.user.vo.RegisterVO;

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
     * @param registerVO 注册信息
     */
    void register(RegisterVO registerVO) throws CustomException;

    /**
     * 通过用户名登录
     *
     * @param loginVO 登录信息
     * @return token
     */
    String loginById(LoginVO loginVO) throws CustomException;
}
