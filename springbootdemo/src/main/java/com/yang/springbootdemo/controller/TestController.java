package com.yang.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springbootdemo.concurrent.AsyncService;

/**
 * Created by yangxiaohua on 2020/7/16.
 */
@RestController
public class TestController {
  @Autowired
  AsyncService asyncService;

  @GetMapping("/testAsync")
  public String test() {
    for (int i = 0; i < 200; i++) {
      try {
        asyncService.asyncTest(i);
      } catch (Exception e) {
        System.out.println("MAX COUNT:" + i);
        throw e;
      }
    }
    return "test async";
  }
}
