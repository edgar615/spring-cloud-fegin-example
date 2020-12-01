package com.github.edgar615.openfeign.interceptor;

import com.github.edgar615.openfeign.account.Account;
import com.github.edgar615.openfeign.account.Bank;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;

public class InterceptorExample {
    public static void main(String[] args) {
        Bank bank = Feign.builder()
                .decoder(new JacksonDecoder())
                .requestInterceptor(new ForwardedForInterceptor())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .target(Bank.class, "http://localhost:8080");
        Account account = bank.getAccountInfo("1");
        System.out.println(account);
    }
}
