package com.yang.springbootdemo.controller;

import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * </br>
 * Created by yangxiaohua on 2021/2/5.
 */
@RestController
@RequestMapping("file")
@Api(tags = "下载文件")
public class DownFileController {

  @RequestMapping("/download")
  @ResponseBody
  public void downloadExampleExcel(HttpServletResponse response) {
    InputStream inputStream = null;
    ServletOutputStream servletOutputStream = null;
    try {
      Resource resource = new DefaultResourceLoader().getResource("classpath:download/data2.zip");

      response.setContentType("application/force-download");
      response.setHeader("Content-Disposition", "attachment;fileName=" + "data2.zip");

      inputStream = resource.getInputStream();
      servletOutputStream = response.getOutputStream();
      IOUtils.copy(inputStream, servletOutputStream);
      response.flushBuffer();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (servletOutputStream != null) {
          servletOutputStream.close();
          servletOutputStream = null;
        }
        if (inputStream != null) {
          inputStream.close();
          inputStream = null;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

}
