package com.youlixiang.blog.service;

import com.youlixiang.blog.vo.EmailVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @Author 郭非
 * @Date 2022/4/5
 * @Time 17:11
 * @Version 1.0
 */
public interface EmailService {
    /**
     * 发送邮件
     *
     * @param emailVO 邮件信息
     */
    void sendEmail(EmailVO emailVO);
}
