package com.github.edgar615.openfeign.error;

import com.github.edgar615.openfeign.account.Account;
import com.github.edgar615.openfeign.query.CustomPojo;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.querymap.BeanQueryMapEncoder;
import feign.slf4j.Slf4jLogger;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ErrorExample {
    public static void main(String[] args) {
        Api api = Feign.builder()
                .decoder(new JacksonDecoder())
                .errorDecoder(new CustomErrorDecoder())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .target(Api.class, "http://localhost:8080");

        List<Account> accounts = api.error();
        System.out.println(accounts);
    }
}