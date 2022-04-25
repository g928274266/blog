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
 * @Date 2022/4/25
 * @Time 15:36
 * @Version 1.0
 */
@Configuration
public class GatewayConfiguration {
    /**
     * 配置跨域属性
     *
     * @return 跨域过滤器
     */
    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        //配置跨域请求头
        configuration.addAllowedHeader("*");
        //配置跨域请求方式
        configuration.addAllowedMethod("*");
        //配置跨域请求来源
        configuration.addAllowedOrigin("*");
        //配置跨域请求是否携带Cookie
        configuration.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", configuration);
        return new CorsWebFilter(source);
    }

}
