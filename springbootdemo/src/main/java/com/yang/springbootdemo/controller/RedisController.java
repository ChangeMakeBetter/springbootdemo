package com.yang.springbootdemo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springbootdemo.redis.BillLockMgr;
import com.yang.springbootdemo.redis.RedisCache;

/**
 * Created by yangxiaohua on 2021/7/26.
 */
@RestController
@RequestMapping("redis")
public class RedisController {

  @Autowired
  private BillLockMgr lockMgr;

  @RequestMapping(value = "/execute", method = RequestMethod.POST)
  public String execute(@RequestParam String key) {
    try {
      String lockValue = UUID.randomUUID().toString();
      //      key 构造应该包含门店+订单号

      lockMgr.lock(key, lockValue, 5000, 10000, 2000);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return e.getMessage();
    }
    return "hello";
  }

  @RequestMapping(value = "/more")
  public String more() {
    RedisCache cache = RedisCache.getInstance();
    try {
      return (String) cache.getValue("K1");
    } catch (Exception e) {
      return e.getMessage();
    }
  }
}
