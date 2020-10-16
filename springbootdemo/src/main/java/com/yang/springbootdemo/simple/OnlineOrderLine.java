package com.yang.springbootdemo.simple;

/**
 * </br>
 * Created by yangxiaohua on 2020/10/13.
 */
public class OnlineOrderLine {
  private String name;
  private String code;

  public OnlineOrderLine(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
