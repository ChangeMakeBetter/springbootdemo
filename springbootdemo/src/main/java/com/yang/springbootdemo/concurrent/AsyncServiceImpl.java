package com.yang.springbootdemo.concurrent;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by yangxiaohua on 2020/7/16.
 */
@Service
public class AsyncServiceImpl implements AsyncService {
  @Override
  @Async
  public void asyncTest(int count) {
    if (count > 20 && count < 51) {
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("执行编号：" + count + ",【Thread】- " + Thread.currentThread().getName());
  }
}