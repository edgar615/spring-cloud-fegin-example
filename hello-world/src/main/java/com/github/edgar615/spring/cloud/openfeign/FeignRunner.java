package com.github.edgar615.spring.cloud.openfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class FeignRunner implements ApplicationRunner {

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private AccountClient2 accountClient2;

//    @Autowired
    private FooController fooController;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account =  accountClient.getAccountInfo("1");
        System.out.println(account);

        account =  accountClient2.getAccountInfo("1");
        System.out.println(account);

//        account =  fooController.getFooClient().getAccountInfo("1");
//        System.out.println(account);
    }
}
