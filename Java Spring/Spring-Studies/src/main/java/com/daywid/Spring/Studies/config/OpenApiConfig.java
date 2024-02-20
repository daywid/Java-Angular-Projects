package com.daywid.Spring.Studies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
    /*
     * Custom OpenAPI bean confiiguration
     * @Return OpenAPI object
     */
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
            .info(new Info()
                .title("RESTful API with Java and Spring")
                .version("Studies project")
                .description("")
                .termsOfService("")
                .license(new License().name("Apache 2.0")
                .url("")));
    }

}
