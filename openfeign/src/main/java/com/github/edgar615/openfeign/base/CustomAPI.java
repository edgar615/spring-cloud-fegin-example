package com.github.edgar615.openfeign.base;

import com.github.edgar615.openfeign.account.Account;
import com.github.edgar615.openfeign.account.Bank;
import feign.RequestLine;

import java.util.List;

/**
 * 仅支持单层继承
 */
public interface CustomAPI extends Bank {
  @RequestLine("GET /api/accounts")
  List<Account> accounts();
}