package com.github.edgar615.openfeign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class ForwardedForInterceptor implements RequestInterceptor {
  @Override
  public void apply(RequestTemplate template) {
    template.header("X-Forwarded-For", "origin.host.com");
  }
}