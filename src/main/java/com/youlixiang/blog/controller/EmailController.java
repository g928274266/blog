package com.youlixiang.blog.controller;

import com.youlixiang.blog.service.EmailService;
import com.youlixiang.blog.util.CommonResult;
import com.youlixiang.blog.vo.EmailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @Author 郭非
 * @Date 2022/4/5
 * @Time 17:00
 * @Version 1.0
 */
@Api(tags = "邮箱模块")
@RestController
@CrossOrigin
public class EmailController {
    @Autowired
    private EmailService emailService;

    /**
     * 发送邮件
     *
     * @param emailVO 邮件信息
     * @return 通用返回
     */
    @ApiOperation(value = "发送邮件")
    @PostMapping("/sendEmail")
    public CommonResult sendEmail(@Valid @RequestBody EmailVO emailVO) {
        emailService.sendEmail(emailVO);
        return CommonResult.success("发送邮件成功");
    }
}
