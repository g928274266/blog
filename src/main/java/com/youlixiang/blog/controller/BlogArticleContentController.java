package com.youlixiang.blog.controller;


import com.youlixiang.blog.service.BlogArticleContentService;
import com.youlixiang.blog.util.CommonResult;
import com.youlixiang.blog.vo.BlogArticleContentVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 郭非
 * @since 2022-03-16
 */
@RestController
@RequestMapping("/article/blog-article-content")
@CrossOrigin
public class BlogArticleContentController {
    @Autowired
    private BlogArticleContentService blogArticleContentService;

    /**
     * 获取文章内容
     *
     * @param articleId 文章编号
     * @return 通用返回
     */
    @ApiOperation(value = "获取文章内容")
    @GetMapping("/getArticleContent/{articleId}")
    public CommonResult getArticleContent(@PathVariable("articleId") Integer articleId) {
        BlogArticleContentVO contentVO = blogArticleContentService.getArticleContent(articleId);
        return CommonResult.success().put("contentVO", contentVO);
    }
}

