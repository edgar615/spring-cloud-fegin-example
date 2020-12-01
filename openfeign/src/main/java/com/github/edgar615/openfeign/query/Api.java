package com.github.edgar615.openfeign.query;

import com.github.edgar615.openfeign.account.Account;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Api {
  @RequestLine("GET /api/accounts?since={date}")
  List<Account> list(@Param(value = "date", expander = DateToMillis.class) Date date);

  @RequestLine("GET /api/accounts")
  List<Account> find(@QueryMap Map<String, Object> queryMap);

  @RequestLine("GET /api/accounts")
  List<Account> find2(@QueryMap CustomPojo customPojo);
}