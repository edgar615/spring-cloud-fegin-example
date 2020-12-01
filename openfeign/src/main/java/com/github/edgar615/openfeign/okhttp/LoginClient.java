package com.github.edgar615.openfeign.okhttp;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface LoginClient {
    @RequestLine("POST /")
    @Headers("Content-Type: application/xml")
    @Body("<login \"user_name\"=\"{user_name}\" \"password\"=\"{password}\"/>")
    void xml(@Param("user_name") String user, @Param("password") String password);

    @RequestLine("POST /")
    @Headers("Content-Type: application/json")
    // json curly braces must be escaped!
    @Body("%7B\"user_name\": \"{user_name}\", \"password\": \"{password}\"%7D")
    void json(@Param("user_name") String user, @Param("password") String password);
}
