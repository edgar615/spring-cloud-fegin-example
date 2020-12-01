package com.github.edgar615.spring.cloud.openfeign;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class LogRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println(LogRequestInterceptor.class.getSimpleName());
    }
}
