package com.youlixiang.blog.user.vo;

import lombok.Data;

/**
 * 用户信息VO
 *
 * @Author 郭非
 * @Date 2022/3/14
 * @Time 11:37
 * @Version 1.0
 */
@Data
public class BlogUserVO {
    /**
     * 用户名
     */
    private String username;
    /**
     * 性别
     */
    private String gender;
    /**
     * 生日
     */
    private String birth;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 头像地址
     */
    private String avatarUrl;
    /**
     * qq
     */
    private String qq;
    /**
     * gitee
     */
    private String gitee;
    /**
     * github
     */
    private String github;
    /**
     * csdn
     */
    private String csdn;
    /**
     * slogan
     */
    private String slogan;
}
