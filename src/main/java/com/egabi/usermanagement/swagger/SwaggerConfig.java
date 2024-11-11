package com.egabi.usermanagement.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.base-package}")
    private String basePackage;
    @Value("${swagger.allowed-urls}")
    private String allowedUrls;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.ant(allowedUrls))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("User Management Application",
                "A Spring App for User Management Services",
                "1.0.0",
                "Terms of service",
                new Contact("User Management","https://egabi.com/","customercare@egabi.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
}
