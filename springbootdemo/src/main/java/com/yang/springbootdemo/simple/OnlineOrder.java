package com.yang.springbootdemo.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * </br>
 * Created by yangxiaohua on 2020/10/13.
 */
public class OnlineOrder {
  private String orderNum;
  private List<OnlineOrderLine> lines = new ArrayList<>();
  private MemberInfo m;

  public String getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(String orderNum) {
    this.orderNum = orderNum;
  }

  public List<OnlineOrderLine> getLines() {
    return lines;
  }

  public void setLines(List<OnlineOrderLine> lines) {
    this.lines = lines;
  }

  public MemberInfo getM() {
    return m;
  }

  public void setM(MemberInfo m) {
    this.m = m;
  }
}
