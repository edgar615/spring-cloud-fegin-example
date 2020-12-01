package com.github.edgar615.openfeign.header;

import com.github.edgar615.openfeign.account.Account;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;

import java.util.Collections;

public class HeaderExample {
    public static void main(String[] args) {
        HeaderApi headerApi = Feign.builder()
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .target(HeaderApi.class, "http://localhost:8080");
        Account account = headerApi.getAccountInfo("1");
        System.out.println(account);

        account = headerApi.getAccountInfo2("1", Collections.singletonMap("X-Request-Id", "2"));
        System.out.println(account);
    }
}