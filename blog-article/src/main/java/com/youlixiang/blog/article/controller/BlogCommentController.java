package com.youlixiang.blog.article.controller;


import com.youlixiang.blog.article.service.BlogCommentService;
import com.youlixiang.blog.article.vo.BlogCommentVO;
import com.youlixiang.blog.common.util.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2022-03-16
 */
@Api(tags = "文章评论模块")
@RestController
@RequestMapping("/article/blog-comment")
public class BlogCommentController {
    @Autowired
    private BlogCommentService blogCommentService;


    @ApiOperation(value = "增加评论")
    @PostMapping("/addComment")
    public CommonResult addComment(@RequestBody BlogCommentVO blogCommentVO) {
        
        return CommonResult.success();
    }
}

