package com.youlixiang.blog.article.controller;


import com.youlixiang.blog.article.service.BlogTypeService;
import com.youlixiang.blog.article.vo.BlogTypeVO;
import com.youlixiang.blog.common.exception.CustomException;
import com.youlixiang.blog.common.util.CommonResult;
import com.youlixiang.blog.common.validate.InsertGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
@Api(tags = "分类模块")
@RestController
@RequestMapping("/article/blog-type")
public class BlogTypeController {
    @Autowired
    private BlogTypeService blogTypeService;

    /**
     * 增加文章分类
     *
     * @param blogTypeVO 文章分类信息
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "增加文章分类")
    @PostMapping("/addBlogType")
    public CommonResult addBlogType(@Validated(value = {InsertGroup.class})
                                    @RequestBody BlogTypeVO blogTypeVO) throws CustomException {
        blogTypeService.addBlogType(blogTypeVO);
        return CommonResult.success("增加文章分类成功");
    }

    /**
     * 查询文章分类
     *
     * @return 通用返回
     */
    @ApiOperation(value = "查询文章分类")
    @GetMapping("/listBlogType")
    public CommonResult listBlogType() {
        List<BlogTypeVO> blogTypeVOList = blogTypeService.listBlogType();
        return CommonResult.success().put("blogTypeVOList", blogTypeVOList);
    }
}

