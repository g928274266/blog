package com.youlixiang.blog;

import com.youlixiang.blog.properties.EmailProperties;
import com.youlixiang.blog.properties.OssProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 博客系统 - 主启动类
 *
 * @Author 郭非
 * @Date 2022/4/3
 * @Time 18:34
 * @Version 1.0
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = {"com.youlixiang.blog.mapper"})
@EnableConfigurationProperties({OssProperties.class, EmailProperties.class })
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}