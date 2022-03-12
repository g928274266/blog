package com.youlixiang.blog.user.vo;

import lombok.Data;

/**
 * 用户注册Vo
 *
 * @Author 郭非
 * @Date 2022/3/12
 * @Time 23:08
 * @Version 1.0
 */
@Data
public class RegisterVo {
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
     * 密码
     */
    private String password;
    /**
     * 确认密码
     */
    private String confirmPassword;
}
