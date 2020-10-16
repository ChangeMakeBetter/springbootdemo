package com.yang.springbootdemo.simple;

import java.io.File;
import java.net.URL;

import org.springframework.util.ResourceUtils;

/**
 * </br>
 * Created by yangxiaohua on 2020/10/16.
 */
public class ResourceTest {
  public static void main(String[] args) {
    URL formatFileUrl = null;
    try {
      File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "format/oilRetail.jft");
      if (file.exists()) {
        formatFileUrl = new URL("file:///" + file.getCanonicalPath());
      } else {
        formatFileUrl = Thread.currentThread().getContextClassLoader().getResource("format/oilRetail.jft");
      }
      if (formatFileUrl == null) {
        throw new Exception("打印模板没找到");
      }

      System.out.println(formatFileUrl.getPath());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
