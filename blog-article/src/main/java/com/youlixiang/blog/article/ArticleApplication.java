package com.youlixiang.blog.article;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 文章服务 - 主启动类
 *
 * @Author 郭非
 * @Date 2022/3/14
 * @Time 12:03
 * @Version 1.0
 */
@EnableSwagger2
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.youlixiang.blog"})
@MapperScan(basePackages = {"com.youlixiang.blog.article.mapper"})
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }
}
