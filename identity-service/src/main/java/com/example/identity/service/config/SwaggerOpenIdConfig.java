package com.example.identity.service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Max.Jimenez
 */
@Configuration
@OpenAPIDefinition
public class SwaggerOpenIdConfig {

    @Bean
    OpenAPI customOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    @Bean
    public GroupedOpenApi publicApi() {
        String[] packagesToScan = {"com.example.identity.service.rest"};

        return GroupedOpenApi.builder()
                .group("identity-api").packagesToScan(packagesToScan)
                .build();
    }

    private Info apiInfo() {
        return new Info()
                .title("identity-service")
                .description("identity management")
                .license(new License()
                        .name("Apache License Version 2.0")
                        .url("http://www.apache.org/licenses/LICENSE-2.0"))
                .version(getClass().getPackage().getImplementationVersion());
    }
}