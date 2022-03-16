package com.youlixiang.blog.user.controller;

import com.youlixiang.blog.common.exception.CustomException;
import com.youlixiang.blog.common.util.CommonResult;
import com.youlixiang.blog.common.validate.InsertGroup;
import com.youlixiang.blog.user.service.BlogUserService;
import com.youlixiang.blog.user.util.CheckLoginUtils;
import com.youlixiang.blog.user.vo.BlogUserVO;
import com.youlixiang.blog.user.vo.LoginVO;
import com.youlixiang.blog.user.vo.RegisterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
     * @throws CustomException 异常
     */
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public CommonResult register(@Validated(value = {InsertGroup.class})
                                 @RequestBody RegisterVO registerVO) throws CustomException {
        blogUserService.register(registerVO);
        return CommonResult.success("注册成功");
    }

    /**
     * 通过用户名登录
     *
     * @param loginVO 通过用户名登录
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "通过用户名登录")
    @PostMapping("/loginById")
    public CommonResult loginById(@Valid @RequestBody LoginVO loginVO) throws CustomException {
        String token = blogUserService.loginById(loginVO);
        return CommonResult.success().put("token", token);
    }

    /**
     * 获取用户信息
     *
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "获取用户信息")
    @GetMapping("/getInfo")
    public CommonResult getInfo(HttpServletRequest request) throws CustomException {
        String username = CheckLoginUtils.isLogin(request);
        BlogUserVO userVo = blogUserService.getInfo(username);
        return CommonResult.success().put("userVo", userVo);
    }

    /**
     * 更新头像
     *
     * @param request 请求
     * @param url     头像地址
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "更新头像")
    @PostMapping("/updateAvatar")
    public CommonResult uploadAvatar(HttpServletRequest request,
                                     @RequestParam(value = "url") String url) throws CustomException {
        String username = CheckLoginUtils.isLogin(request);
        blogUserService.updateAvatar(username, url);
        return CommonResult.success("上传头像成功");
    }

    /**
     * 更新用户信息
     *
     * @param request 请求
     * @param userVO  用户信息
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "更新用户信息")
    @PostMapping("/uploadInfo")
    public CommonResult uploadInfo(HttpServletRequest request, BlogUserVO userVO) throws CustomException {
        String username = CheckLoginUtils.isLogin(request);
        blogUserService.uploadInfo(username, userVO);
        return CommonResult.success("更新信息成功");
    }
}

