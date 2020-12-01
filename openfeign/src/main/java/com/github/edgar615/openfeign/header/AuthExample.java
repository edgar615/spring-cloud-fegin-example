package com.github.edgar615.openfeign.header;

import com.github.edgar615.openfeign.account.Account;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;

import java.util.Collections;
import java.util.UUID;

public class AuthExample {
    public static void main(String[] args) {
        ThreadLocal<String> requestIdProvider = new ThreadLocal<>();
        requestIdProvider.set(UUID.randomUUID().toString());
        HeaderApi headerApi = Feign.builder()
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .target(new DynamicAuthTokenTarget<>(HeaderApi.class, "http://localhost:8080",
                        () -> UUID.randomUUID().toString(), requestIdProvider));
        Account account = headerApi.getAccountInfo("1");
        System.out.println(account);

    }
}