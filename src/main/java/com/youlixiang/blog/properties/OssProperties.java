package com.youlixiang.blog.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Oss配置类
 *
 * @Author 郭非
 * @Date 2022/3/15
 * @Time 7:45
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "aliyun.oss")
public class OssProperties {
    /**
     * 地域编号
     */
    private String endpoint;
    /**
     * 编号
     */
    private String keyId;
    /**
     * 密钥
     */
    private String keySecret;
    /**
     * 存储桶名称
     */
    private String bucketName;
}
