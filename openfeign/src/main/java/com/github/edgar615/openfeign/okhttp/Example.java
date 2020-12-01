package com.github.edgar615.openfeign.okhttp;

import com.github.edgar615.openfeign.hello.GitHub;
import feign.Feign;
import feign.Logger;
import feign.Response;
import feign.ResponseMapper;
import feign.jackson.JacksonDecoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

import java.lang.reflect.Type;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        GitHub github = Feign.builder()
                .client(new OkHttpClient())
                .mapAndDecode(new ResponseMapper() {
                    @Override
                    public Response map(Response response, Type type) {
                        // 修改response
                        return response;
                    }
                }, new JacksonDecoder())
//                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .target(GitHub.class, "https://api.github.com");

        List<GitHub.Contributor> contributors = github.contributors("OpenFeign", "feign");
        for (GitHub.Contributor contributor : contributors) {
            System.out.println(contributor.getLogin() + " (" + contributor.getContributions() + ")");
        }
    }
}