package com.youlixiang.blog.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * * <p>
 * * 服务类
 * * </p>
 *
 * @Author 郭非
 * @Date 2022/3/15
 * @Time 7:48
 * @Version 1.0
 */
public interface OssService {
    /**
     * 上传文件
     *
     * @param multipartFile 上传文件
     * @return 返回地址
     */
    String uploadOssFile(MultipartFile multipartFile);

    /**
     * 删除文件
     *
     * @param fileName 文件名
     */
    void deleteOssFile(String fileName);
}
