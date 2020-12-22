package com.yang.springbootdemo.service;

import java.beans.Transient;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * </br>
 * Created by yangxiaohua on 2020/10/17.
 */
@Service
public class TestTransactionService {

  public void methodA() {
    System.out.println("do methodA");
    methodB();
  }

  @Transactional
  public void methodB() {
    System.out.println("do methodB");
  }
}
