package com.github.edgar615.spring.cloud.openfeign;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "account", url = "http://localhost:8080", configuration = AccountConfiguration.class)
public interface AccountClient {
    @GetMapping("/api/accounts/{id}")
    Account getAccountInfo(@PathVariable("id") String id);

    @GetMapping("/api/accounts")
    List<Account> find(@SpringQueryMap CustomPojo customPojo);

    @PostMapping("/api/accounts")
    void add(Account account);

//    @GetMapping("/api/accounts/{matrixVars}")
//    Map<String, List<String>> getObjects(@MatrixVariable Map<String, List<String>> matrixVars);
}
