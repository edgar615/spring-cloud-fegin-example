package com.github.edgar615.spring.cloud.openfeign;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "hystrix", url = "http://localhost:8080", fallbackFactory = HystrixClientFallbackFactory.class)
public interface HystrixClient {
    @GetMapping("/api/accounts/{id}")
    Account getAccountInfo(@PathVariable("id") String id);

    @GetMapping("/api/accounts/error")
    List<Account> error();

    @GetMapping("/api/accounts/sleep?second={second}")
    List<Account> sleep(@Param("second") Integer second);
}
