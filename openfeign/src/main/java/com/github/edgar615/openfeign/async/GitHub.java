package com.github.edgar615.openfeign.async;

import feign.Param;
import feign.RequestLine;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.github.edgar615.openfeign.hello.GitHub.Contributor;

public interface GitHub {
  @RequestLine("GET /repos/{owner}/{repo}/contributors")
  CompletableFuture<List<Contributor>> contributors(@Param("owner") String owner, @Param("repo") String repo);
}