package com.yang.springbootdemo.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.yang.springbootdemo.action.AbstractAction;
import com.yang.springbootdemo.annotation.TestAnnotation;
import lombok.extern.slf4j.Slf4j;

/**
 * springbootdemo<br> Created by yangxiaohua on 2019/11/7.
 */
@Component
@Slf4j
public class ControllerExcuter {
  private HashMap<String, Class> urlAction = null;

  public ControllerExcuter() {
    init();
  }

  private void init() {
    try {
      urlAction = new LinkedHashMap<String, Class>();
      ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
      // 类名正则
      provider.addIncludeFilter(new RegexPatternTypeFilter(Pattern.compile(".*")));
      // 包路径
      final Set<BeanDefinition> classes = provider.findCandidateComponents("com.yang.springbootdemo.action");
      for (BeanDefinition bean : classes) {
        Class<?> clazz = Class.forName(bean.getBeanClassName());
        if (clazz.isAnnotationPresent(TestAnnotation.class)) {
          String value = clazz.getAnnotation(TestAnnotation.class).value();
          urlAction.put(value, clazz);
        }
      }
      for (String s : urlAction.keySet()) {
        System.out.println("key:" + s);
      }
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }

  public void excute(String uri) {
    AbstractAction action = getAction(uri);
    action.doSomethings();
  }

  private AbstractAction getAction(String uri) {
    try {
      if (CollectionUtils.isEmpty(urlAction)) {
        log.debug("不会出现这种情况，map为空只可能是服务启动失败。");
      }
      Class aClass = urlAction.get(uri);
      return (AbstractAction) aClass.newInstance();
    } catch (Exception e) {
      return null;
    }
  }

}
