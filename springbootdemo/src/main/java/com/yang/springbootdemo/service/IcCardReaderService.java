package com.yang.springbootdemo.service;

import org.springframework.stereotype.Service;

import com.yang.springbootdemo.jna.DqshOilCardRd;
import com.yang.springbootdemo.jna.dqsh.api.CardInfo;
import com.yang.springbootdemo.jna.dqsh.api.ReturnData;

/**
 * </br>
 * Created by yangxiaohua on 2021/3/31.
 */
@Service
public class IcCardReaderService {

  public ReturnData<CardInfo> readCard(String passwd) {
    return getIcrd().queryCard(passwd);
  }

  private static DqshOilCardRd icrd;

  private static synchronized DqshOilCardRd getIcrd() {
    if (icrd == null) {
      icrd = new DqshOilCardRd();
      icrd.load();
    }
    return icrd;
  }
}
