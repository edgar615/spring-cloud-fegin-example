package com.github.edgar615.openfeign.metrics;

import com.github.edgar615.openfeign.hello.GitHub;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.metrics5.Metrics5Capability;
import io.dropwizard.metrics5.*;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class MetricsExample {
  public static void main(String... args) {
    GitHub github = Feign.builder()
            .addCapability(new Metrics5Capability())
                         .decoder(new GsonDecoder())
                         .target(GitHub.class, "https://api.github.com");

    // Fetch and print a list of the contributors to this library.
    List<GitHub.Contributor> contributors = github.contributors("OpenFeign", "feign");

    MetricRegistry metricRegistry = SharedMetricRegistries.getOrCreate("feign");
    Map<MetricName, Metric> metricMap =  metricRegistry.getMetrics();
    for (MetricName metricName : metricMap.keySet()) {
      System.out.println(metricName.getKey());
      System.out.println(metricMap.get(metricName));
    }
  }
}