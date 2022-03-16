package com.youlixiang.blog.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.youlixiang.blog.oss.properties.OssProperties;
import com.youlixiang.blog.oss.service.OssService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * * <p>
 * * 服务实现类
 * * </p>
 *
 * @Author 郭非
 * @Date 2022/3/15
 * @Time 7:48
 * @Version 1.0
 */
@Service
public class OssServiceImpl implements OssService {
    @Autowired
    private OssProperties ossProperties;

    /**
     * 上传文件
     *
     * @param multipartFile 上传文件
     * @return 图片地址
     */
    @Override
    public String uploadOssFile(MultipartFile multipartFile) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = ossProperties.getEndpoint();
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ossProperties.getKeyId();
        String accessKeySecret = ossProperties.getKeySecret();
        String bucketName = ossProperties.getBucketName();


        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            // 获取上传文件输入流
            InputStream inputStream = multipartFile.getInputStream();
            //获取文件名称
            String originalFilename = multipartFile.getOriginalFilename();
            // 生成随机id
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获取当前日期
            String datePath = new DateTime().toString("yyyy/MM/dd");
            //拼接成唯一文件名
            String fileName = datePath + "/" + uuid + originalFilename;
            // 填写Bucket名称和Object完整路径。Object完整路径中不能包含Bucket名称。
            ossClient.putObject(bucketName, fileName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
            //返回上传文件路径
            return "https://" + bucketName + "." + endpoint + "/" + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 删除文件
     *
     * @param fileName 文件名
     */
    @Override
    public void deleteOssFile(String fileName) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = ossProperties.getEndpoint();
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ossProperties.getKeyId();
        String accessKeySecret = ossProperties.getKeySecret();
        // 填写Bucket名称。
        String bucketName = ossProperties.getBucketName();
        // 填写文件完整路径。文件完整路径中不能包含Bucket名称。

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 删除文件或目录。如果要删除目录，目录必须为空。
        ossClient.deleteObject(bucketName, fileName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
