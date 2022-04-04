package com.youlixiang.blog.controller;


import com.youlixiang.blog.exception.CustomException;
import com.youlixiang.blog.service.BlogUserService;
import com.youlixiang.blog.util.CheckLoginUtils;
import com.youlixiang.blog.util.CommonResult;
import com.youlixiang.blog.validate.InsertGroup;
import com.youlixiang.blog.vo.BlogUserVO;
import com.youlixiang.blog.vo.LoginVO;
import com.youlixiang.blog.vo.RegisterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

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
@CrossOrigin
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
    public CommonResult getInfo() throws CustomException {
        BlogUserVO userVo = blogUserService.getInfo("youlixiang");
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

    /**
     * 用户登出
     *
     * @param request 请求
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "用户登出")
    @GetMapping("/logout")
    public CommonResult logout(HttpServletRequest request) throws CustomException {
        CheckLoginUtils.isLogin(request);
        return CommonResult.success("用户登出成功");
    }

    /**
     * 获取用户列表
     *
     * @param current 当前页
     * @param limit   页面大小
     * @return 通用返回
     */
    @ApiOperation(value = "用户列表")
    @GetMapping("/listUser/{current}/{limit}")
    public CommonResult listUser(@PathVariable("current") Long current,
                                 @PathVariable("limit") Long limit) {
        Map<String, Object> userMap = blogUserService.listUser(current, limit);
        return CommonResult.success().put("userMap", userMap);
    }

    /**
     * 删除用户
     *
     * @param request  请求
     * @param username 用户名
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "删除用户")
    @DeleteMapping("/removeUser/{username}")
    public CommonResult removeUser(HttpServletRequest request, @PathVariable("username") String username) throws CustomException {
        CheckLoginUtils.isLogin(request);
        blogUserService.removeUser(username);
        return CommonResult.success("删除用户成功");
    }
}

