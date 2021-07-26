package com.yang.springbootdemo.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yangxiaohua on 2021/7/26.
 */
public class RedisTest {

  public static void main(String[] args) {

    RedisCache cache = RedisCache.getInstance();
    List<Object> list = new ArrayList<>();
    Map<String, Object> map = new ConcurrentHashMap<>();
    map.put("Key1", "Value1");
    map.put("Key2", "Value2");
    list.add(map);

    cache.putValue("R1", "12345", 2);
    for (int i = 0; i < 5; i++) {
      try {
        Thread.sleep(1000);
        System.out.println("获取成功 : " + cache.getValue("R1"));
        if (i == 2) {
          cache.remove("R1");
        }
      } catch (Exception e) {
        System.out.println("获取失败..");
      }
    }
  }
}