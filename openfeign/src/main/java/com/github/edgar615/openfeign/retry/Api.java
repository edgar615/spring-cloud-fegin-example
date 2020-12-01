package com.github.edgar615.openfeign.retry;

import com.github.edgar615.openfeign.account.Account;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface Api {

  @RequestLine("GET /api/accounts/sleep?second={second}")
  List<Account> sleep(@Param("second") Integer second);

}