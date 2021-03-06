package com.youlixiang.blog.controller;

import com.youlixiang.blog.exception.CustomException;
import com.youlixiang.blog.service.OssService;
import com.youlixiang.blog.util.CheckLoginUtils;
import com.youlixiang.blog.util.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @Author 郭非
 * @Date 2022/3/15
 * @Time 7:47
 * @Version 1.0
 */
@RestController
@RequestMapping("/oss/fileOss")
@Api(tags = "oss模块")
public class OssController {
    @Autowired
    private OssService ossService;

    /**
     * 上传文件
     *
     * @param multipartFile 上传文件
     * @return 通用返回
     * @throws CustomException 异常
     */
    @PostMapping("/uploadOssFile")
    @ApiOperation(value = "上传文件")
    public CommonResult uploadOssFile(HttpServletRequest request, MultipartFile multipartFile) throws CustomException {
        CheckLoginUtils.isLogin(request);
        String url = ossService.uploadOssFile(multipartFile);
        return CommonResult.success().put("url", url);
    }

    /**
     * 删除文件
     *
     * @param fileName 文件名
     * @return 通用返回
     * @throws CustomException 异常
     */
    @PostMapping("/deleteOssFile")
    @ApiOperation(value = "删除文件")
    public CommonResult deleteOssFile(HttpServletRequest request, @RequestParam("fileName") String fileName) throws CustomException {
        CheckLoginUtils.isLogin(request);
        ossService.deleteOssFile(fileName);
        return CommonResult.success();
    }
}
