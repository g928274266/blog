package com.youlixiang.blog.oss;

import com.youlixiang.blog.oss.properties.OssProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Oss服务 - 主启动类
 *
 * @Author 郭非
 * @Date 2022/3/15
 * @Time 7:36
 * @Version 1.0
 */
@EnableSwagger2
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(value = {OssProperties.class})
@ComponentScan(basePackages = "com.youlixiang.blog")
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
    }
}
