package com.api_getway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;
@Component
public class LoggingFilter implements GlobalFilter {



    Logger logger = Logger.getLogger(LoggingFilter.class.getName());
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        logger.info("Starting Request....");
       String uri= exchange.getRequest().getURI().toString();

       String country=exchange.getRequest().getHeaders().getFirst("country");

       logger.info("URI  : " +uri);
        logger.info("Country  : " +country);
        return chain.filter(exchange);
    }
}
