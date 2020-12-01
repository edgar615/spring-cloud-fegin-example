package com.github.edgar615.openfeign.account;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Content-Type:application/json")
public interface Bank {
  @RequestLine("GET /api/accounts/{id}")
  Account getAccountInfo(@Param("id") String id);

  @RequestLine("POST /api/accounts")
  Account add(Account account);
}