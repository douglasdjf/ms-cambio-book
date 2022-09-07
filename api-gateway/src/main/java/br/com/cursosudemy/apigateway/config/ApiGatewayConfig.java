package br.com.cursosudemy.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  A configuração para poder ter o Swagger tem que ser pelo application.yml
 *
 */

//@Configuration
public class ApiGatewayConfig {

    /*@Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f
                                .addRequestHeader("Hello","World")
                                .addRequestParameter("Hello","World")
                        )
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/cambio-service/**").uri("lb://cambio-service"))
                .route(p -> p.path("/book-service/**").uri("lb://book-service"))
                .build();
    }*/
}
