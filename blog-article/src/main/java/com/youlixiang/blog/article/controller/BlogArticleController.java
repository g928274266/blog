package com.youlixiang.blog.article.controller;


import com.youlixiang.blog.article.service.BlogArticleService;
import com.youlixiang.blog.article.vo.BlogArticleVO;
import com.youlixiang.blog.common.util.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 郭非
 * @since 2022-03-16
 */
@Api(tags = "文章模块")
@RestController
@RequestMapping("/article/blog-article")
public class BlogArticleController {
    @Autowired
    private BlogArticleService blogArticleService;

    @ApiOperation(value = "查询文章列表")
    @PostMapping("/listArticle/{current}/{limit}")
    public CommonResult listArticle(@PathVariable(value = "current") Long current,
                                    @PathVariable(value = "limit") Long limit,
                                    @RequestBody BlogArticleVO blogArticleVO) {
        List<BlogArticleVO> blogArticleVOList = blogArticleService.listArticle(current, limit, blogArticleVO);
        return CommonResult.success().put("blogArticleVOList", blogArticleVOList);
    }
}

