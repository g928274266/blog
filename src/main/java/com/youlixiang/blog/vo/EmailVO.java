package com.youlixiang.blog.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * EmailVO
 *
 * @Author 郭非
 * @Date 2022/4/5
 * @Time 17:07
 * @Version 1.0
 */
@Data
public class EmailVO {
    /**
     * 发送人地址
     */
    @Email(message = "邮箱格式错误")
    private String emailAddress;
    /**
     * 发送内容
     */
    @Size(max = 255,message = "内容最多255")
    private String content;
}
