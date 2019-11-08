package com.yang.springbootdemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * springbootdemo<br> Created by yangxiaohua on 2019/11/8.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {

  /**
   * 取自{@link com.yang.springbootdemo.controller.ControllerUrlConsts}的属性
   *
   * 以 "/" 开头, 结尾没有 "/" 的的servlet路径
   *
   * @return
   */
  String value() default "";
}
