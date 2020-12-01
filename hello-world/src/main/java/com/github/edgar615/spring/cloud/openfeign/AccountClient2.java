package com.github.edgar615.spring.cloud.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "account2", url = "http://localhost:8080")
public interface AccountClient2 {
    @RequestMapping("/api/accounts/{id}")
    Account getAccountInfo(@PathVariable("id") String id);
}
