package com.youlixiang.blog.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 用户服务 - 主启动类
 *
 * @Author 郭非
 * @Date 2022/3/12
 * @Time 20:35
 * @Version 1.0
 */
@EnableSwagger2
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.youlixiang.blog.user.feign")
@ComponentScan(basePackages = {"com.youlixiang.blog"})
@MapperScan(basePackages = {"com.youlixiang.blog.user.mapper"})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
