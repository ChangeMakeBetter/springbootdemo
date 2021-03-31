package com.yang.springbootdemo.jna.dqsh.api;

import java.io.Serializable;

/**
 * 由各个方法自行定义code和message的含义
 * 
 * @author caili
 * 
 */
public class ReturnCode implements Serializable {
  public static final int warn = -10, success = 0;
  private static final long serialVersionUID = 1L;
  private int code = 0;
  private String message;

  public ReturnCode() {
  }

  public static ReturnCode ok() {
    return new ReturnCode(0, null);
  }

  public static ReturnCode error(String message) {
    return new ReturnCode(-1, message);
  }

  public ReturnCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean isOK() {
    return code == 0;
  }

  public boolean isWarn() {
    return code == warn;
  }
}
