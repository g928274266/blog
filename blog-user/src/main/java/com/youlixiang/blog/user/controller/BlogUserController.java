package com.youlixiang.blog.user.controller;

import com.youlixiang.blog.common.util.CommonResult;
import com.youlixiang.blog.user.vo.RegisterVo;
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
@RestController
@RequestMapping("/user/blog-user")
public class BlogUserController {
    /**
     * 用户注册
     *
     * @param registerVo 注册信息
     * @return 通用返回
     */
    @PostMapping("/register")
    public CommonResult register(@RequestBody RegisterVo registerVo) {
        return new CommonResult();
    }
}

