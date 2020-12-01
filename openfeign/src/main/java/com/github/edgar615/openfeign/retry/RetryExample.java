package com.github.edgar615.openfeign.retry;

import com.github.edgar615.openfeign.account.Account;
import com.github.edgar615.openfeign.error.CustomErrorDecoder;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RetryExample {
    public static void main(String[] args) {
        Api api = Feign.builder()
                .options(new Request.Options(5, TimeUnit.SECONDS, 1, TimeUnit.SECONDS, false))
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .target(Api.class, "http://localhost:8080");

        List<Account> accounts = api.sleep(5);
        System.out.println(accounts);
    }
}