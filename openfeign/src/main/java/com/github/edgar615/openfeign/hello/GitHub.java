package com.github.edgar615.openfeign.hello;

import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface GitHub {
  @RequestLine("GET /repos/{owner}/{repo}/contributors")
  List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

  @RequestLine("GET /repos/{owner:[a-zA-Z]*}/{repo}/contributors")
  List<Contributor> contributors2(@Param("owner") String owner, @Param("repo") String repo);

  @RequestLine("POST /repos/{owner}/{repo}/issues")
  void createIssue(Issue issue, @Param("owner") String owner, @Param("repo") String repo);

  public static class Contributor {
    String login;
    int contributions;

    public String getLogin() {
      return login;
    }

    public int getContributions() {
      return contributions;
    }
  }

  public static class Issue {
    String title;
    String body;
    List<String> assignees;
    int milestone;
    List<String> labels;

    public String getTitle() {
      return title;
    }

    public String getBody() {
      return body;
    }

    public List<String> getAssignees() {
      return assignees;
    }

    public int getMilestone() {
      return milestone;
    }

    public List<String> getLabels() {
      return labels;
    }
  }
}