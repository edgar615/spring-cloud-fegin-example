package com.github.edgar615.openfeign.header;

import feign.Request;
import feign.RequestTemplate;
import feign.Target;

import java.util.function.Supplier;

public class DynamicAuthTokenTarget<T> implements Target<T> {
    private final Class<T> type;
    private final String url;
    private final ThreadLocal<String> requestIdProvider;
    private final Supplier<String> tokenProvider;
    public DynamicAuthTokenTarget(Class<T> clazz,String url,
                                  Supplier<String> tokenProvider,
                                  ThreadLocal<String> requestIdProvider) {
        this.type = clazz;
        this.url = url;
        this.tokenProvider = tokenProvider;
        this.requestIdProvider = requestIdProvider;
    }

    @Override
    public Class<T> type() {
        return type;
    }

    @Override
    public String name() {
        return url;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Request apply(RequestTemplate input) {
        if (input.url().indexOf("http") != 0) {
            input.target(url());
        }
      input.header("X-Auth-Token", tokenProvider.get());
      input.header("X-Trace-ID", requestIdProvider.get());

      return input.request();
    }
  }