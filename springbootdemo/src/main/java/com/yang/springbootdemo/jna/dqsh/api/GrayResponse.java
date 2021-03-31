package com.yang.springbootdemo.jna.dqsh.api;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.sun.jna.Structure;
import com.yang.springbootdemo.util.Converter;

/**
 * @author zhangxinkun
 */
public class GrayResponse extends Structure {

  // 是否为灰卡，非0：灰卡，0：不是灰卡
  public byte[] isGray = new byte[1 + 1];

  public static GrayResponse create() {
    return new ByReference();
  }

  public static class ByReference extends GrayResponse implements Structure.ByReference {
    public ByReference() {
      super();
    }
  }

  public boolean getIsGray() {
    return Converter.toInt(StringUtils.trimToEmpty(Converter.toString(isGray)), 0) == 1;
  }

  public void setIsGray(byte[] isGray) {
    this.isGray = isGray;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("isGray=" + Arrays.toString(isGray)).append("\n");
    return sb.toString();
  }

}
