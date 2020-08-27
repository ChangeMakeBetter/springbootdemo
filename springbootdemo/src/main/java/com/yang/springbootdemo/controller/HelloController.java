package com.yang.springbootdemo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springbootdemo.action.ActionUrlConsts;

/**
 * springbootdemo<br> Created by yangxiaohua on 2018/12/11.
 */
@RestController
@RequestMapping(ControllerUrlConsts.URL_HELLO)
public class HelloController {

  @Resource(name = "controllerExcuter")
  ControllerExcuter excuter;

  @RequestMapping("/say")
  public String sayHello() {
    excuter.excute(ActionUrlConsts.URL_FIRST);
    return "hello world";
  }
}