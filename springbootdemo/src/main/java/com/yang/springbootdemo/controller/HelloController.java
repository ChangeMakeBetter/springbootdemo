package com.yang.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springbootdemo<br> Created by yangxiaohua on 2018/12/11.
 */
@RestController
@RequestMapping(ControllerUrlConsts.URL_HELLO)
public class HelloController {
  @RequestMapping("/say")
  public String sayHello() {
    return "hello world";
  }

  //测试分支

    //测试啊啊啊啊啊

    //emmm
}