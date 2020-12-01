package com.github.edgar615.spring.cloud.openfeign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

public class AccountConfiguration {

    @Bean
    public RequestInterceptor customRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                System.out.println("interceptor");
                template.header("X-Forwarded-For", "origin.host.com");
            }
        };
    }
}