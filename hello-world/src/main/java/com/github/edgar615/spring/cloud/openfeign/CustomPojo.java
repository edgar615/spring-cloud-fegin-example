package com.github.edgar615.spring.cloud.openfeign;

/**
 */
public class CustomPojo {
  private final String name;
  private final int number;

  public CustomPojo(String name, int number) {
    this.name = name;
    this.number = number;
  }

//  public String getName() {
//    return name;
//  }

  public String getName2() {
    return name;
  }

  public int getNumber() {
    return number;
  }
}