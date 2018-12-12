package com.yang.springbootdemo.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springbootdemo.extra.User;
import com.yang.springbootdemo.extra.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * springbootdemo<br> Created by yangxiaohua on 2018/12/11.
 */
@RestController
@RequestMapping("api")
@Api("swaggerDemoController相关的api")
public class SwaggerDemoController {
  @Resource(name = "userService")
  private UserService userService;

  private static final Logger logger = LoggerFactory.getLogger(SwaggerDemoController.class);

  @ApiOperation(value = "根据id查询信息", notes = "查询数据库中某人信息")
  @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public User getUser(@PathVariable int id) {
    logger.info("开始查询个人信息");
    return userService.selectStudentById(id);
  }

}
