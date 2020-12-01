package com.github.edgar615.spring.cloud.openfeign;

import java.util.Collections;
import java.util.List;

public class HystrixClientFallback implements HystrixClient {

    @Override
    public Account getAccountInfo(String id) {
        return null;
    }

    @Override
    public List<Account> error() {
        Account account = new Account();
        account.setId("fallback");
        account.setName("fallback");
        return Collections.singletonList(account);
    }

    @Override
    public List<Account> sleep(Integer second) {
        return null;
    }
}