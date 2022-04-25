package com.youlixiang.blog.controller;

import com.youlixiang.blog.exception.CustomException;
import com.youlixiang.blog.service.BlogTypeService;
import com.youlixiang.blog.util.CheckLoginUtils;
import com.youlixiang.blog.util.CommonResult;
import com.youlixiang.blog.vo.BlogTypeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
     * @param request    请求头
     * @param blogTypeVO 文章分类信息
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "增加文章分类")
    @PostMapping("/addBlogType")
    public CommonResult addBlogType(HttpServletRequest request, @RequestBody BlogTypeVO blogTypeVO) throws CustomException {
        CheckLoginUtils.isLogin(request);
        blogTypeService.addBlogType(blogTypeVO);
        return CommonResult.success("增加文章分类成功");
    }

    /**
     * 删除文章分类
     *
     * @param request 请求头
     * @param typeId  分类编号
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "删除文章分类")
    @DeleteMapping("/removeBlogType/{typeId}")
    public CommonResult removeBlogType(HttpServletRequest request, @PathVariable("typeId") Integer typeId) throws CustomException {
        CheckLoginUtils.isLogin(request);
        blogTypeService.removeBlogType(typeId);
        return CommonResult.success("删除文章分类成功");
    }

    /**
     * 修改分类信息
     *
     * @param request    请求头
     * @param blogTypeVO 分类信息
     * @return 通用返回
     * @throws CustomException 异常
     */
    @ApiOperation(value = "修改分类信息")
    @PutMapping("/updateBlogType")
    public CommonResult updateBlogType(HttpServletRequest request, @RequestBody BlogTypeVO blogTypeVO) throws CustomException {
        CheckLoginUtils.isLogin(request);
        blogTypeService.updateBlogType(blogTypeVO);
        return CommonResult.success("修改分类信息成功");
    }

    /**
     * 查询文章分类列表
     *
     * @return 通用返回
     */
    @ApiOperation(value = "查询文章分类列表")
    @GetMapping("/listBlogType")
    public CommonResult listBlogType() {
        List<BlogTypeVO> blogTypeVOList = blogTypeService.listBlogType();
        return CommonResult.success().put("blogTypeVOList", blogTypeVOList);
    }

    /**
     * 获取文章分类
     *
     * @param articleId 文章编号
     * @return 文章分类
     */
    @ApiOperation(value = "获取文章分类")
    @GetMapping("/getBlogType/{articleId}")
    public CommonResult getBlogType(@PathVariable("articleId") Integer articleId) {
        String blogType = blogTypeService.getBlogType(articleId);
        return CommonResult.success().put("blogType", blogType);
    }

}

