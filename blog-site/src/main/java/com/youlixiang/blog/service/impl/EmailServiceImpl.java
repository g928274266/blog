package com.youlixiang.blog.service.impl;

import com.youlixiang.blog.properties.EmailProperties;
import com.youlixiang.blog.service.EmailService;
import com.youlixiang.blog.vo.EmailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @Author 郭非
 * @Date 2022/4/5
 * @Time 17:11
 * @Version 1.0
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private EmailProperties emailProperties;

    @Override
    public void sendEmail(EmailVO emailVO) {
        SimpleMailMessage message = new SimpleMailMessage();
        //设置发送者
        message.setFrom(emailVO.getEmailAddress());
        //设置接受者
        message.setTo(emailProperties.getReceiveAddress());
        //设置标题
        message.setSubject("博客留言");
        //设置内容
        message.setText(emailVO.getContent());
        //发送邮件
        javaMailSender.send(message);
    }
}
