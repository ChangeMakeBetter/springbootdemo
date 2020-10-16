package com.yang.springbootdemo;

import java.util.List;

import org.assertj.core.util.Lists;

import com.yang.springbootdemo.extra.User;

/**
 * </br>
 * Created by yangxiaohua on 2020/10/10.
 */
public class GuavaCollectionTest {

  public static void main(String[] args) {
    User user = new User();
    user.setName("test");
    List<User> userList = Lists.newArrayList(user);
    userList.stream().forEach(u -> System.out.println(u.getName()));
  }
}
