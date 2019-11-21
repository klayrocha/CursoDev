package com.klayrocha.auth.docs;

import org.springframework.context.annotation.Configuration;

import com.klayrocha.core.docs.BaseSwaggerConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    public SwaggerConfig() {
        super("com.klayrocha.auth.endpoint.controller");
    }
}
