package com.github.edgar615.openfeign.error;

import com.github.edgar615.openfeign.account.Account;
import com.github.edgar615.openfeign.query.CustomPojo;
import com.github.edgar615.openfeign.query.DateToMillis;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Api {

  @RequestLine("GET /api/accounts/error")
  List<Account> error();

}