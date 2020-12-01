package com.github.edgar615.openfeign.account;

import feign.Feign;
import feign.gson.GsonEncoder;

public class BankService {
  public static void main(String[] args) {
    Bank bank = Feign.builder()
            .decoder(        new AccountDecoder())
            .encoder(new GsonEncoder())
        .target(Bank.class, "http://localhost:8080");
    Account account = bank.getAccountInfo("1");
    System.out.println(account);

    account = bank.add(account);
    System.out.println(account);
  }
}