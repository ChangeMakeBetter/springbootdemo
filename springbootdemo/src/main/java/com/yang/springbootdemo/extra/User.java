package com.yang.springbootdemo.extra;

import org.springframework.stereotype.Component;

/**
 * springbootdemo<br> Created by yangxiaohua on 2018/12/11.
 */
@Component
public class User {
  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

}
