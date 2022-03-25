package com.youlixiang.blog.user.vo;

import com.youlixiang.blog.common.validate.InsertGroup;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 用户注册VO
 *
 * @Author 郭非
 * @Date 2022/3/12
 * @Time 23:08
 * @Version 1.0
 */
@Data
public class RegisterVO {
    /**
     * 用户名
     */
    private String username;
    /**
     * 性别
     */
    @Size(max = 1, min = 1, message = "性别最多一个字符", groups = {InsertGroup.class})
    private String gender;
    /**
     * 手机号
     */
    @Pattern(
            regexp = "^[1]([3-9])[0-9]{9}$",
            message = "非法手机号码",
            groups = {InsertGroup.class})
    private String phone;
    /**
     * 邮箱
     */
    @Pattern(regexp = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",
            message = "非法邮箱地址",
            groups = {InsertGroup.class})
    private String email;
    /**
     * 密码
     */
    @Min(value = 6, message = "密码最小长度为6", groups = {InsertGroup.class})
    private String password;
    /**
     * 确认密码
     */
    private String confirmPassword;
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
