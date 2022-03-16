package com.youlixiang.blog.user.feign;

import com.youlixiang.blog.common.util.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 远程调用 - oss接口
 *
 * @Author 郭非
 * @Date 2022/3/15
 * @Time 8:12
 * @Version 1.0
 */
@FeignClient(value = "blog-oss")
public interface OssFeignClient {
    /**
     * 删除文件
     *
     * @param fileName 文件名
     * @return 通用返回
     */
    @PostMapping("/deleteOssFile")
    @ApiOperation(value = "删除文件")
    CommonResult deleteOssFile(@RequestParam("fileName") String fileName);
}
