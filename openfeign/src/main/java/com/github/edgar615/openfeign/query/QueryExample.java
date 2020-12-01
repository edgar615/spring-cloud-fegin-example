package com.github.edgar615.openfeign.query;

import com.github.edgar615.openfeign.account.Account;
import com.github.edgar615.openfeign.base.CustomAPI;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.querymap.BeanQueryMapEncoder;
import feign.slf4j.Slf4jLogger;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class QueryExample {
    public static void main(String[] args) {
        Api api = Feign.builder()
                .decoder(new JacksonDecoder())
                .queryMapEncoder(new BeanQueryMapEncoder())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .target(Api.class, "http://localhost:8080");

        List<Account> accounts = api.list(new Date());
        System.out.println(accounts);

        accounts = api.find(Collections.singletonMap("foo", "bar"));
        System.out.println(accounts);

        accounts = api.find2(new CustomPojo("edgar615", 1));
        System.out.println(accounts);
    }
}