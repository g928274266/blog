package com.youlixiang.blog.service;

import com.youlixiang.blog.exception.CustomException;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 服务类
 * </p>
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
     * @return 文件url
     * @throws CustomException 自定义异常
     */
    String uploadOssFile(MultipartFile multipartFile) throws CustomException;

    /**
     * 删除文件
     *
     * @param fileName 文件名
     */
    void deleteOssFile(String fileName);
}
