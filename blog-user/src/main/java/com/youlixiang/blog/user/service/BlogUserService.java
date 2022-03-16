package com.youlixiang.blog.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.youlixiang.blog.user.entity.BlogUser;
import com.youlixiang.blog.user.exception.CustomException;
import com.youlixiang.blog.user.vo.BlogUserVO;
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
     * @throws CustomException 异常
     */
    void register(RegisterVO registerVO) throws CustomException;

    /**
     * 通过用户名登录
     *
     * @param loginVO 登录信息
     * @return token
     * @throws CustomException 异常
     */
    String loginById(LoginVO loginVO) throws CustomException;

    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     * @throws CustomException 异常
     */
    BlogUserVO getInfo(String username) throws CustomException;

    /**
     * 更新头像
     *
     * @param username 用户名
     * @param url      头像地址
     * @throws CustomException 异常
     */
    void updateAvatar(String username, String url) throws CustomException;

    /**
     * 更新用户信息
     *
     * @param username 用户名
     * @param userVO   用户信息
     */
    void uploadInfo(String username, BlogUserVO userVO);
}
