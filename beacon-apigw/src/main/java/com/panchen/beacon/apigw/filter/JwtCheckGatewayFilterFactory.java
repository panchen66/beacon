package com.panchen.beacon.apigw.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class JwtCheckGatewayFilterFactory implements GatewayFilterFactory<Object>{

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            //jwt
            return chain.filter(exchange);           
        };
    }

}
