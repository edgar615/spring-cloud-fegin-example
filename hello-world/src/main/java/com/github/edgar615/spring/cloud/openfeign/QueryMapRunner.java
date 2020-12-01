package com.github.edgar615.spring.cloud.openfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class QueryMapRunner implements ApplicationRunner {

    @Autowired
    private AccountClient accountClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Account> accounts =  accountClient.find(new CustomPojo("foo", 1));
        System.out.println(accounts);

        accountClient.add(accounts.get(0));

//        Map<String, List<String>> matrixVars = new HashMap<>();
//        matrixVars.put("foo", Collections.singletonList("bar"));
//
//        accountClient.getObjects(matrixVars);

    }
}
