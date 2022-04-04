package com.youlixiang.blog.controller;

import com.youlixiang.blog.exception.CustomException;
import com.youlixiang.blog.service.BlogTypeService;
import com.youlixiang.blog.util.CommonResult;
import com.youlixiang.blog.vo.BlogTypeVO;
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
@Api(tags = "分类模块")
@RestController
@RequestMapping("/article/blog-type")
@CrossOrigin
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
    public CommonResult addBlogType(@RequestBody BlogTypeVO blogTypeVO) throws CustomException {
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

