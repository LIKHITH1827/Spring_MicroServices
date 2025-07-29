package com.programming.microservices.gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routes {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()

                // Route for Product Service
                .route("product_service", r -> r
                        .path("/api/product/**") // incoming request path
                        .uri("http://localhost:8080")) // forward to product-service

                // Route for Order Service
                .route("order_service", r -> r
                        .path("/api/order/**") // incoming request path
                        .uri("http://localhost:8081")) // forward to order-service

                //Route for Inventory Service
                .route("inventory_service", r -> r
                        .path("/api/inventory/**") // incoming request path
                        .uri("http://localhost:8082")) // forward to inventory-service

                .build();
    }
}