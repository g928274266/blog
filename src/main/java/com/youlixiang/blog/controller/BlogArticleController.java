package com.youlixiang.blog.controller;

import com.youlixiang.blog.exception.CustomException;
import com.youlixiang.blog.service.BlogArticleService;
import com.youlixiang.blog.util.CheckLoginUtils;
import com.youlixiang.blog.util.CommonResult;
import com.youlixiang.blog.vo.BlogArticlePublishVO;
import com.youlixiang.blog.vo.BlogArticleVO;
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
 * @since 2022-03-16
 */
@Api(tags = "文章模块")
@RestController
@RequestMapping("/article/blog-article")
@CrossOrigin
public class BlogArticleController {
    @Autowired
    private BlogArticleService blogArticleService;

    /**
     * 查询文章列表
     *
     * @param current       当前页
     * @param limit         页面大小
     * @param blogArticleVO 文章信息
     * @return 通用返回
     */
    @ApiOperation(value = "查询文章列表")
    @PostMapping("/listArticle/{current}/{limit}")
    public CommonResult listArticle(@PathVariable(value = "current") Long current,
                                    @PathVariable(value = "limit") Long limit,
                                    @RequestBody BlogArticleVO blogArticleVO) {
        Map<String, Object> articleMap = blogArticleService.listArticle(current, limit, blogArticleVO);
        return CommonResult.success().put("articleMap", articleMap);
    }

    /**
     * 发布文章
     *
     * @param request   请求头
     * @param publishVO 文章信息
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "发布文章")
    @PostMapping("/publishArticle")
    public CommonResult publishArticle(HttpServletRequest request,
                                       @RequestBody BlogArticlePublishVO publishVO) throws CustomException {
        CheckLoginUtils.isLogin(request);
        blogArticleService.publishArticle(publishVO);
        return CommonResult.success();
    }
}

