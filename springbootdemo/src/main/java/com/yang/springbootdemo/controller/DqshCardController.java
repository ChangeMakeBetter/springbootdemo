package com.yang.springbootdemo.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springbootdemo.jna.dqsh.api.CardInfo;
import com.yang.springbootdemo.jna.dqsh.api.ReadCardRequest;
import com.yang.springbootdemo.jna.dqsh.api.ReturnData;
import com.yang.springbootdemo.service.IcCardReaderService;
import io.swagger.annotations.Api;

/**
 * </br>
 * Created by yangxiaohua on 2021/2/5.
 */
@RestController
@RequestMapping("dqsh")
@Api(tags = "大桥石化卡测试")
public class DqshCardController {

  @Autowired
  private IcCardReaderService service;

  @RequestMapping("/readCard")
  @ResponseBody
  public ReturnData<CardInfo> readCard(@RequestBody @NotNull ReadCardRequest request) {
    try {
      return service.readCard(request.getPasswd());
    } catch (Exception e) {
      e.printStackTrace();
      return ReturnData.fail(e.getMessage());
    }
  }

}
