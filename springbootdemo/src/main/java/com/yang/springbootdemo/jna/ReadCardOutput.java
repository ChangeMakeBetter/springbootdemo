/**
 * caili, 2011-4-7
 */
package com.yang.springbootdemo.jna;

import java.math.BigDecimal;
import java.util.Date;

public class ReadCardOutput {
  private String cardVersion;
  private String cardType;
  private String pCode;
  /** 卡芯片号 */
  private String icCardNum;
  private int carrier;
  private BigDecimal parValue;
  private BigDecimal balance;
  private BigDecimal score;
  private BigDecimal cardCost;
  private Date byDate;
  private Date makeTime;
  private Date lstPayDate;
  private BigDecimal addOcrTotal;

  private String lastAction;
  private Date lastActionTime;
  private int depositCount;
  private int consumeCount;

  /** null= ok;not null= fail */
  private String errorMsg;

  private boolean onlyHasCardCode = false;

  private boolean onlineModeCard = false;

  private String barcode;

  public String getCardVersion() {
    return cardVersion;
  }

  public void setCardVersion(String cardVersion) {
    this.cardVersion = cardVersion;
  }

  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  public String getPCode() {
    return pCode;
  }

  public void setPCode(String code) {
    pCode = code;
  }

  public int getCarrier() {
    return carrier;
  }

  public void setCarrier(int carrier) {
    this.carrier = carrier;
  }

  public BigDecimal getParValue() {
    return parValue;
  }

  public void setParValue(BigDecimal parValue) {
    this.parValue = parValue;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public BigDecimal getScore() {
    return score;
  }

  public void setScore(BigDecimal score) {
    this.score = score;
  }

  public BigDecimal getCardCost() {
    return cardCost;
  }

  public void setCardCost(BigDecimal cardCost) {
    this.cardCost = cardCost;
  }

  public Date getByDate() {
    return byDate;
  }

  public void setByDate(Date byDate) {
    this.byDate = byDate;
  }

  public Date getMakeTime() {
    return makeTime;
  }

  public void setMakeTime(Date makeTime) {
    this.makeTime = makeTime;
  }

  public Date getLstPayDate() {
    return lstPayDate;
  }

  public void setLstPayDate(Date lstPayDate) {
    this.lstPayDate = lstPayDate;
  }

  public BigDecimal getAddOcrTotal() {
    return addOcrTotal;
  }

  public void setAddOcrTotal(BigDecimal addOcrTotal) {
    this.addOcrTotal = addOcrTotal;
  }

  public String getLastAction() {
    return lastAction;
  }

  public void setLastAction(String lastAction) {
    this.lastAction = lastAction;
  }

  public Date getLastActionTime() {
    return lastActionTime;
  }

  public void setLastActionTime(Date lastActionTime) {
    this.lastActionTime = lastActionTime;
  }

  public int getDepositCount() {
    return depositCount;
  }

  public void setDepositCount(int depositCount) {
    this.depositCount = depositCount;
  }

  public int getConsumeCount() {
    return consumeCount;
  }

  public void setConsumeCount(int consumeCount) {
    this.consumeCount = consumeCount;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public boolean isOnlyHasCardCode() {
    return onlyHasCardCode;
  }

  public void setOnlyHasCardCode(boolean onlyHasCardCode) {
    this.onlyHasCardCode = onlyHasCardCode;
  }

  public String getIcCardNum() {
    return icCardNum;
  }

  public void setIcCardNum(String icCardNum) {
    this.icCardNum = icCardNum;
  }

  public boolean isOnlineModeCard() {
    return onlineModeCard;
  }

  public void setOnlineModeCard(boolean onlineModeCard) {
    this.onlineModeCard = onlineModeCard;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public ReadCardOutput copy() {
    ReadCardOutput r = new ReadCardOutput();
    r.cardVersion = this.cardVersion;
    r.cardType = this.cardType;
    r.pCode = this.pCode;
    r.icCardNum = this.icCardNum;
    r.carrier = this.carrier;
    r.parValue = this.parValue;
    r.balance = this.balance;
    r.score = this.score;
    r.cardCost = this.cardCost;
    r.byDate = this.byDate;
    r.makeTime = this.makeTime;
    r.lstPayDate = this.lstPayDate;
    r.addOcrTotal = this.addOcrTotal;
    r.lastAction = this.lastAction;
    r.lastActionTime = this.lastActionTime;
    r.depositCount = this.depositCount;
    r.consumeCount = this.consumeCount;
    r.errorMsg = this.errorMsg;
    r.onlyHasCardCode = this.onlyHasCardCode;
    r.onlineModeCard = this.onlineModeCard;
    r.barcode = this.barcode;
    return r;
  }

  public boolean isOK() {
    return errorMsg == null;
  }
}