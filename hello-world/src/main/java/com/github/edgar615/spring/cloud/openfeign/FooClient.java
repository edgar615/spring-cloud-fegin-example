package com.github.edgar615.spring.cloud.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface FooClient {
    @RequestMapping("/api/accounts/{id}")
    Account getAccountInfo(@PathVariable("id") String id);
}
