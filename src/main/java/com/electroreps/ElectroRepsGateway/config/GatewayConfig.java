package com.electroreps.ElectroRepsGateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("electroreps-client-service", r -> r.path("/clients/**")
                        .uri("lb://electroreps-client-service"))
                .route("electroreps-employee-service", r -> r.path("/employees/**")
                        .uri("lb://electroreps-employee-service"))
                .route("electroreps-reparation-service", r -> r.path("/reparations/**")
                        .uri("lb://electroreps-reparation-service"))
                .build();
    }
}
