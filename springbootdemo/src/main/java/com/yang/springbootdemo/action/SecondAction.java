package com.yang.springbootdemo.action;

import com.yang.springbootdemo.annotation.TestAnnotation;
import lombok.extern.slf4j.Slf4j;

/**
 * springbootdemo<br> Created by yangxiaohua on 2019/11/12.
 */
@TestAnnotation(value = ActionUrlConsts.URL_SECOND)
@Slf4j
public class SecondAction extends AbstractAction {

  @Override
  public void doSomethings() {
    log.info("SecondAction.doSomethings");
  }
}
