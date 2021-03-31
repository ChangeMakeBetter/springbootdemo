package com.yang.springbootdemo.jna.dqsh.api;

import java.math.BigDecimal;
import java.util.Arrays;

import com.sun.jna.Structure;
import com.yang.springbootdemo.util.Converter;

public class BalanceResponse extends Structure {

  public byte[] balance = new byte[12 + 1];

  public static BalanceResponse create() {
    return new BalanceResponse.ByReference();
  }

  public static class ByReference extends BalanceResponse implements Structure.ByReference {
    public ByReference() {
      super();
    }
  }

  public BigDecimal getBalance() {
    return Converter.fenToYuan(Long.parseLong(Converter.toString(balance)));
  }

  public void setBalance(byte[] balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("balance=" + Arrays.toString(balance)).append("\n");
    return sb.toString();
  }
}
