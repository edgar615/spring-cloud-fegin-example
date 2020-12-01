package com.github.edgar615.openfeign.error;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

import java.io.IOException;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        byte[] body = {};
        try {
            if (response.body() != null) {
                body = Util.toByteArray(response.body().asInputStream());
            }
        } catch (IOException ignored) { // NOPMD
        }
        return new RuntimeException(new String(body));
    }
}
