package com.youlixiang.blog.comment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 郭非
 * @Date 2022/3/13
 * @Time 17:12
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CommentApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommentApplication.class, args);
    }
}
