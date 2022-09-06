package br.com.cursosudemy.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * http://localhost:8000/v3/api-docs
 * http://localhost:8000/swagger-ui.html
 *
 */

@Configuration
@OpenAPIDefinition(info =
    @Info(title = "Cambio Service API", version = "v1", description = "Documentação do Cambio Service API"))
public class OpenApiConfig {

    private OpenAPI info;

    @Bean
    public OpenAPI customOpenAPI(){
        info = new OpenAPI()
                .components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Cambio Service API")
                        .version("v1")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                );
        return info;
    }
}
