package com.youlixiang.blog.comment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 评论服务 - 主启动类
 *
 * @Author 郭非
 * @Date 2022/3/13
 * @Time 17:12
 * @Version 1.0
 */
@EnableSwagger2
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.youlixiang.blog"})
@MapperScan(basePackages = {"com.youlixiang.blog.comment.mapper"})
public class CommentApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommentApplication.class, args);
    }
}
