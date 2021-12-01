package com.lessons.home.springsecurity.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("ProBar")
                                .version("0.0.1-SNAPSHOT")
                                .contact(
                                        new Contact()
                                                .email("r.vitalik.skuratov@gmail.com")
                                                .name("Vitalij Skuratovskij")
                                )
                );
    }
}
