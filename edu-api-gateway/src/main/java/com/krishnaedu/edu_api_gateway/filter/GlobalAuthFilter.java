package com.krishnaedu.edu_api_gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GlobalAuthFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("----Pre filter----");
        // Check whether token is valid or not
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            System.out.println("----Post filter----");
            System.out.println("Response status code: " + exchange.getResponse().getStatusCode());
        }));
    }
}
