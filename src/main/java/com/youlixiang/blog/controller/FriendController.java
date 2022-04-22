package com.youlixiang.blog.controller;


import com.youlixiang.blog.exception.CustomException;
import com.youlixiang.blog.service.FriendService;
import com.youlixiang.blog.util.CheckLoginUtils;
import com.youlixiang.blog.util.CommonResult;
import com.youlixiang.blog.vo.BlogFriendVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 郭非
 * @since 2022-04-05
 */
@Api(tags = "友链模块")
@RestController
@RequestMapping("/blog/friend")
@CrossOrigin
public class FriendController {
    @Autowired
    private FriendService friendService;

    /**
     * 添加友链
     *
     * @param request      请求头
     * @param blogFriendVO 友链信息
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "添加友链")
    @PostMapping("/addFriend")
    public CommonResult addFriend(HttpServletRequest request, @RequestBody BlogFriendVO blogFriendVO) throws CustomException {
        CheckLoginUtils.isLogin(request);
        friendService.addFriend(blogFriendVO);
        return CommonResult.success("添加友链成功");
    }

    /**
     * 删除友链
     *
     * @param request  请求头
     * @param friendId 友链编号
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "删除友链")
    @DeleteMapping("/removeFriend/{friendId}")
    public CommonResult removeFriend(HttpServletRequest request,@PathVariable(value = "friendId") Integer friendId) throws CustomException {
        CheckLoginUtils.isLogin(request);
        friendService.removeFriend(friendId);
        return CommonResult.success("删除友链成功");
    }

    /**
     * 修改友链
     *
     * @param request      请求头
     * @param blogFriendVO 友链信息
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "修改友链")
    @PutMapping("/updateFriend")
    public CommonResult updateFriend(HttpServletRequest request, BlogFriendVO blogFriendVO) throws CustomException {
        CheckLoginUtils.isLogin(request);
        friendService.updateFriend(blogFriendVO);
        return CommonResult.success("修改友链成功");
    }

    /**
     * 查询友链列表
     *
     * @param current 当前页
     * @param limit   页面大小
     * @return 通用返回
     */
    @ApiOperation(value = "查询友链列表")
    @GetMapping("/listFriend/{current}/{limit}")
    public CommonResult listFriend(@PathVariable("current") Long current,
                                   @PathVariable("limit") Long limit) {
        Map<String, Object> friendMap = friendService.listFriend(current, limit);
        return CommonResult.success().put("friendMap", friendMap);
    }
}

