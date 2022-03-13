package com.youlixiang.blog.user.controller;

import com.youlixiang.blog.common.util.CommonResult;
import com.youlixiang.blog.common.validate.InsertGroup;
import com.youlixiang.blog.user.exception.RegisterException;
import com.youlixiang.blog.user.service.BlogUserService;
import com.youlixiang.blog.user.vo.RegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 郭非
 * @since 2022-03-12
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/user/blog-user")
public class BlogUserController {
    @Autowired
    private BlogUserService blogUserService;

    /**
     * 用户注册
     *
     * @param registerVo 注册信息
     * @return 通用返回
     */
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public CommonResult register(@Validated(value = {InsertGroup.class}) @RequestBody RegisterVo registerVo) throws RegisterException {
        blogUserService.register(registerVo);
        return CommonResult.success("注册成功");
    }
}

