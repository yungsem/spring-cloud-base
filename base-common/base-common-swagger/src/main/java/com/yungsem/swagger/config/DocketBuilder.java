package com.yungsem.swagger.config;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author yangsen
 * @version 1.0
 * @since 2021-07-23
 */
@Data
public class DocketBuilder {
    private String basePackage;
    private String title;
    private String beanName;

    public DocketBuilder() {
    }

    public DocketBuilder(String basePackage, String title, String beanName) {
        this.basePackage = basePackage;
        this.title = title;
        this.beanName = beanName;
    }

    /**
     * 构建Docket对象
     *
     * @return Docket
     */
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(this.basePackage))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .apiInfo(apiInfo());
    }

    /**
     * 构建 securitySchemes
     *
     * @return List<SecurityScheme>
     */
    private List<SecurityScheme> securitySchemes() {
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
        return Lists.newArrayList(apiKey);
    }

    /**
     * 构建 securityContexts
     *
     * @return List<SecurityContext>
     */
    private List<SecurityContext> securityContexts() {
        SecurityContext securityContext = SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(regex("^(?!auth).*$"))
                .build();
        return Lists.newArrayList(securityContext);
    }

    /**
     * 授权范围
     *
     * @return List<SecurityReference>
     */
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

    /**
     * 构建 apiInfo
     *
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(this.title)
                .description(this.title)
                .version("1.0.0")
                .build();
    }
}
