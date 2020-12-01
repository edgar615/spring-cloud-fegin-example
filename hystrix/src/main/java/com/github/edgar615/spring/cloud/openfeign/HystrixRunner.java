package com.github.edgar615.spring.cloud.openfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HystrixRunner implements ApplicationRunner {

    @Autowired
    private HystrixClient hystrixClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Account account =  hystrixClient.getAccountInfo("1");
//        System.out.println(account);

        List<Account> accounts = hystrixClient.error();
        System.out.println(accounts);
    }
}
