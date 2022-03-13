package com.youlixiang.blog.user.controller;

import com.youlixiang.blog.common.util.CommonResult;
import com.youlixiang.blog.common.util.JwtUtils;
import com.youlixiang.blog.common.validate.InsertGroup;
import com.youlixiang.blog.user.exception.CustomException;
import com.youlixiang.blog.user.service.BlogUserService;
import com.youlixiang.blog.user.vo.LoginVO;
import com.youlixiang.blog.user.vo.RegisterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
     * @param registerVO 注册信息
     * @return 通用返回
     */
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public CommonResult register(@Validated(value = {InsertGroup.class}) @RequestBody RegisterVO registerVO) throws CustomException {
        blogUserService.register(registerVO);
        return CommonResult.success("注册成功");
    }

    /**
     * 通过用户名登录
     *
     * @param loginVO 登录信息
     * @return 通用返回
     */
    @ApiOperation(value = "通过用户名登录")
    @PostMapping("/login")
    public CommonResult login(@RequestBody LoginVO loginVO) throws CustomException {
        String token = blogUserService.loginById(loginVO);
        return CommonResult.success().put("token", token);
    }
}

