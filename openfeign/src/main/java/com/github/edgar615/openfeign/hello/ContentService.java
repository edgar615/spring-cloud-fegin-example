package com.github.edgar615.openfeign.hello;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ContentService {
  @RequestLine("GET /api/documents/{contentType}")
  @Headers("Accept: {contentType}")
  String getDocumentByType(@Param("contentType") String type);
}