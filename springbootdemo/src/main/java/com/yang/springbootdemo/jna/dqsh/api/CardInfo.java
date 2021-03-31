package com.yang.springbootdemo.jna.dqsh.api;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * </br>
 * Created by yangxiaohua on 2021/3/31.
 */
public class CardInfo {
  public final String cardNo;

  public final BigDecimal balance;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    CardInfo cardInfo = (CardInfo) o;

    return new EqualsBuilder().append(cardNo, cardInfo.cardNo).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(cardNo).toHashCode();
  }

  public CardInfo(String cardNo) {
    this.cardNo = cardNo;
    this.balance = null;
  }

  public CardInfo(String cardNo, BigDecimal balance) {
    this.cardNo = cardNo;
    this.balance = balance;
  }
}
