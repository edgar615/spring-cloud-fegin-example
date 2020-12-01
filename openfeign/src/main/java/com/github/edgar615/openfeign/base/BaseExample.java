package com.github.edgar615.openfeign.base;

import com.github.edgar615.openfeign.account.Account;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;

import java.util.Collections;
import java.util.List;

public class BaseExample {
    public static void main(String[] args) {
        CustomAPI customAPI = Feign.builder()
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .target(CustomAPI.class, "http://localhost:8080");
        Account account = customAPI.getAccountInfo("1");
        System.out.println(account);

        List<Account> accounts = customAPI.accounts();
        System.out.println(accounts);
    }
}