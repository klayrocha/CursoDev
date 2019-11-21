package com.klayrocha.core.docs;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class BaseSwaggerConfig {
    private final String basePackage;

    public BaseSwaggerConfig(String basePackage) {
        this.basePackage = basePackage;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot Microservices")
                .description("Spring Boot Microservices")
                .version("1.0")
                .contact(new Contact("Francis Klay Rocha", "https://www.linkedin.com/in/francis-rocha-21455215/", "klayrocha@gmail.com"))
                .license("Klay Rocha")
                .licenseUrl("https://github.com/klayrocha")
                .build();
    }
}