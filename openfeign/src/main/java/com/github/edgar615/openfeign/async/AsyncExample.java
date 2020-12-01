package com.github.edgar615.openfeign.async;

import feign.AsyncFeign;
import feign.Feign;
import feign.gson.GsonDecoder;
import com.github.edgar615.openfeign.hello.GitHub.Contributor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncExample {
    public static void main(String[] args) throws Exception {
        GitHub github = AsyncFeign.asyncBuilder()
                .decoder(new GsonDecoder())
                .target(GitHub.class, "https://api.github.com");

        // Fetch and print a list of the contributors to this library.
        CompletableFuture<List<Contributor>> future = github.contributors("OpenFeign", "feign");
        for (Contributor contributor : future.get(10, TimeUnit.SECONDS)) {
            System.out.println(contributor.getLogin() + " (" + contributor.getContributions() + ")");
        }
    }
}