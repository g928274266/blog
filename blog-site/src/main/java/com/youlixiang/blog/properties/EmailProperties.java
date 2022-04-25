package com.youlixiang.blog.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Email配置类
 *
 * @Author 郭非
 * @Date 2022/4/5
 * @Time 17:26
 * @Version 1.0
 */
@Data
@ConfigurationProperties(value = "email")
public class EmailProperties {
    /**
     * 接受地址
     */
    private String receiveAddress;
}
