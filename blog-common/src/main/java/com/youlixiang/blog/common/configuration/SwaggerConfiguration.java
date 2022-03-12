package com.youlixiang.blog.common.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * @Author 郭非
 * @Date 2022/3/12
 * @Time 22:03
 * @Version 1.0
 */
@Configuration
public class SwaggerConfiguration {
    /**
     * 配置swagger2
     *
     * @return docket实例
     */
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.enable(true);
        docket.apiInfo(apiInfo());
        docket.select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).build();
        return docket;
    }

    /**
     * 配置Api信息
     *
     * @return api实例
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Blog Documentation"
                , "Laboratory Documentation"
                , "1.0"
                , "urn:tos",
                contact()
                , "Apache 2.0"
                , "http://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList<>());
    }

    /**
     * 配置联系信息
     *
     * @return 联系信息
     */
    public Contact contact() {
        return new Contact("youlixiang", "www.youlixiang.asia", "123@qq.com");
    }
}
