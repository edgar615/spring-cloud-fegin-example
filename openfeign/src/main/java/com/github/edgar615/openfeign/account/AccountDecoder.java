package com.github.edgar615.openfeign.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonIOException;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

import static feign.Util.UTF_8;
import static feign.Util.ensureClosed;

public class AccountDecoder implements Decoder {

    private final ObjectMapper objectMapper;

    public AccountDecoder() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        if (response.body() == null)
            return null;
        Reader reader = response.body().asReader(UTF_8);
        try {
//            return objectMapper.readValue(reader, Account.class);
            return objectMapper.readValue(reader, objectMapper.constructType(type));
        } catch (JsonIOException e) {
            if (e.getCause() != null && e.getCause() instanceof IOException) {
                throw IOException.class.cast(e.getCause());
            }
            throw e;
        } finally {
            ensureClosed(reader);
        }
    }
}
