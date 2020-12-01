package com.github.edgar615.spring.cloud.openfeign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<HystrixClient> {
    @Override
    public HystrixClient create(Throwable cause) {
        System.out.println(cause);
        return new HystrixClientFallback();
    }
}