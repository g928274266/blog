package com.youlixiang.blog.user.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * 用户登录VO
 *
 * @Author 郭非
 * @Date 2022/3/13
 * @Time 13:59
 * @Version 1.0
 */
@Data
public class LoginVO {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;
    /**
     * 密码
     */
    @Min(value = 6, message = "密码最小长度为6")
    private String password;
}
