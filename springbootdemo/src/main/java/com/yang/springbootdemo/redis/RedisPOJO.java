package com.yang.springbootdemo.redis;

import java.io.Serializable;

/**
 * Created by yangxiaohua on 2021/7/26.
 */
public class RedisPOJO implements Serializable {
  private static final long serialVersionUID = 1818367900093105912L;
  /**
   * 存入的对象
   */
  private Object value;
  /**
   * 对象存入时 / 修改时的时间戳
   */
  private long modifyTime;
  /**
   * 过期时间 单位int:秒
   */
  private int expireTime;

  public RedisPOJO(Object value, long modifyTime, int expireTime) {
    this.value = value;
    this.modifyTime = modifyTime;
    this.expireTime = expireTime;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public long getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(long modifyTime) {
    this.modifyTime = modifyTime;
  }

  public int getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(int expireTime) {
    this.expireTime = expireTime;
  }
}
