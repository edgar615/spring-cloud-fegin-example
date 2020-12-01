package com.github.edgar615.openfeign.header;

import com.github.edgar615.openfeign.account.Account;
import feign.HeaderMap;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.Map;

@Headers({"X-Client-Name: feign", "X-Client-Type: Java"})
interface HeaderApi {
  @RequestLine("GET /api/accounts/{id}")
  @Headers("X-Request-Id: {id}")
  Account getAccountInfo(@Param("id") String id);

  @RequestLine("GET /api/accounts/{id}")
  Account getAccountInfo2(@Param("id") String id, @HeaderMap Map<String, Object> headerMap);
}