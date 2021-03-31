package com.yang.springbootdemo.runner;

import java.util.HashMap;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.yang.springbootdemo.jna.DqshOilCardRd;
import lombok.extern.slf4j.Slf4j;

/**
 * </br>
 * Created by yangxiaohua on 2021/3/31.
 */

@Slf4j
public class TestRunner implements ApplicationRunner {
  private DqshOilCardRd cardRd;

  @Override
  public void run(ApplicationArguments applicationArguments) throws Exception {
    log.info("我是Spring容器启动后立即执行的方法，当前时间：" + System.currentTimeMillis());
    final HashMap<String, String> params = new HashMap<String, String>();
    final DqshOilCardRd cardRd = new DqshOilCardRd();
  }
}