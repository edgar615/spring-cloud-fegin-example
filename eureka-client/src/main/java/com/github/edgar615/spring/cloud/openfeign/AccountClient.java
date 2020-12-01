package com.github.edgar615.spring.cloud.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "eureka-client")
public interface AccountClient {
    @GetMapping("/api/accounts/{id}")
    Account getAccountInfo(@PathVariable("id") String id);
}
