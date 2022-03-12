package com.youlixiang.blog.gateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * 网关跨域配置类
 *
 * @Author 郭非
 * @Date 2022/3/12
 * @Time 21:02
 * @Version 1.0
 */
@Configuration
public class WebCorsConfiguration {
    /**
     * 配置跨域请求过滤器
     *
     * @return 跨域请求过滤器
     */
    @Bean
    public CorsWebFilter corsFilter() {
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        //配置跨域请求头
        configuration.addAllowedHeader("*");
        //配置跨域请求方式
        configuration.addAllowedMethod("*");
        //配置跨域请求来源
        configuration.addAllowedOrigin("*");
        //配置跨域请求是否携带Cookie
        configuration.setAllowCredentials(true);
        //过滤所有路径
        corsConfigurationSource.registerCorsConfiguration("/**", configuration);
        return new CorsWebFilter(corsConfigurationSource);
    }
}
