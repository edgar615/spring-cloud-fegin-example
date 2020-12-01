package com.github.edgar615.spring.cloud.openfeign;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(FeignClientsConfiguration.class)
//@Configuration
class FooController {

    private final FooClient fooClient;

    @Autowired
    public FooController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
        this.fooClient = Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder)
                .contract(contract)
//                .requestInterceptor(new BasicAuthRequestInterceptor("user", "user"))
                .target(FooClient.class, "http://localhost:8080");

    }

    public FooClient getFooClient() {
        return fooClient;
    }
}