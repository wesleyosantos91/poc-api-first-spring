package com.gitlab.wesleyosantos91.backend.apifirst.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by wesleyosantos91 on 2019-05-30.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gitlab.wesleyosantos91.backend.apifirst.api"))
                .build()
                .apiInfo(info());
    }

    public ApiInfo info() {
        return new ApiInfoBuilder()
                .title("API")
                .description("api Demo")
                .version("1.0")
                .build();
    }


}
