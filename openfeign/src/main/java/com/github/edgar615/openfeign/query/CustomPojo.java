package com.github.edgar615.openfeign.query;

/**
 * 默认使用反射的属性名，所以不需要get方法，要用get可以使用BeanQueryMapEncoder
 */
public class CustomPojo {
  private final String name;
  private final int number;

  public CustomPojo (String name, int number) {
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