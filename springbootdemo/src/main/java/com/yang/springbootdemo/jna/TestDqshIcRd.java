package com.yang.springbootdemo.jna;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import com.yang.springbootdemo.jna.dqsh.api.CardInfo;
import com.yang.springbootdemo.jna.dqsh.api.ReturnData;

/**
 * @author zhangxinkun
 */
public class TestDqshIcRd {

  private static final String password = "000000";

  private DqshOilCardRd icrd() throws Exception {
    final HashMap<String, String> params = new HashMap<String, String>();
    final DqshOilCardRd cardRd = new DqshOilCardRd();
    cardRd.load();
    return cardRd;
  }

  public static void main(String[] args) {
    try {
      TestDqshIcRd testDqshIcRd = new TestDqshIcRd();
      DqshOilCardRd icrd = testDqshIcRd.icrd();
      testDqshIcRd.doReadCard(icrd);

    } catch (Throwable e) {
      System.out.println(e.getMessage());
    }
  }

  private void doReadCard(DqshOilCardRd cardRd) {
    try {
      final String password = StringUtils.trimToEmpty("000000");
      System.out.println("执行卡查询： 密码=" + password);
      final ReturnData<CardInfo> queryCard = cardRd.queryCard(password);
      System.out.println("卡查询返回：" + queryCard.getData().cardNo + ", " + queryCard.getData().balance);
    } catch (Throwable e) {
      System.out.println(e.getMessage());
    }
  }

}
