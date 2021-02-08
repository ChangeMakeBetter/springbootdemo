package com.yang.springbootdemo.websocket;

/**
 * </br>
 * Created by yangxiaohua on 2021/1/27.
 */
public class MyMessage {
 // {"message":"你好", "userId":1}

  private String message;

  private String userId;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
