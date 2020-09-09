package com.yang.springbootdemo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springbootdemo.action.ActionUrlConsts;
import io.swagger.annotations.ApiParam;

/**
 * springbootdemo<br> Created by yangxiaohua on 2018/12/11.
 */
@RestController
@RequestMapping(ControllerUrlConsts.URL_HELLO)
public class HelloController {

  @Resource(name = "controllerExcuter")
  ControllerExcuter excuter;

  @RequestMapping("/api/v3/securities/devices/register")
  public String sayHello(@RequestParam String deviceId, @RequestParam String appKey, @RequestParam String rnd) {
    excuter.excute(ActionUrlConsts.URL_FIRST);
    System.out.println(deviceId);
    return "{\n"
      + "  \"errorCode\": \"PUB-00000\",\n"
      + "  \"errorMessage\": \"成功\",\n"
      + "  \"extra\": null,\n"
      + "  \"display\": true,\n"
      + "  \"exception\": null,\n"
      + "  \"reqTime\": 1501492416,\n"
      + "  \"costTime\": 146,\n"
      + "  \"skipType\": null,\n"
      + "  \"skipParam\": null,\n"
      + "  \"body\": { \n"
      + "           \"accessToken\": \"A1mk0rUGEMdljtP1\",\n"
      + "           \"registerTime\": 1501490789,\n"
      + "           \"sessionValiditySeconds\": 3600\n"
      + "      },\n"
      + "  \"encrypted\":false\n"
      + "}";
  }

  @RequestMapping("/api/v3/oil/record/list")
  public String listOrder() {
    return "{\n"
      + "\t\"errorCode\": \"PUB-00000\",\n"
      + "\t\"errorMessage\": \"成功\",\n"
      + "\t\"extra\": null,\n"
      + "\t\"display\": true,\n"
      + "\t\"exception\": null,\n"
      + "\t\"reqTime\": 1589268953,\n"
      + "\t\"costTime\": 1941,\n"
      + "\t\"skipType\": null,\n"
      + "\t\"serviceTime\": 1589268955,\n"
      + "\t\"skipParam\": null,\n"
      + "\t\"body\": [{\n"
      + "\t\t\"orderId\": \"CaEe7KlCRMgYYYWw\",\n"
      + "\t\t\"orderSn\": \"207013142095985\",\n"
      + "\t\t\"orderTime\": 1591101013,\n"
      + "\t\t\"invalidTime\": 1591101313,\n"
      + "\t\t\"memberId\": \"CaEax7HkMX8wPbQr\",\n"
      + "\t\t\"orderCount\": 1,\n"
      + "\t\t\"statusCode\": \"finished\",\n"
      + "\t\t\"orderType\": \"oneKeyRefuel\",\n"
      + "\t\t\"canRefund\": true,\n"
      + "\t\t\"refunded\": false,\n"
      + "\t\t\"canInvoice\": false,\n"
      + "\t\t\"invoiced\": false,\n"
      + "\t\t\"vipUserInfo\": {\n"
      + "\t\t\t\"id\": \"CaEax7HkMX8wPbQr\",\n"
      + "\t\t\t\"name\": \"姓名\",\n"
      + "\t\t\t\"nickName\": \"昵称\",\n"
      + "\t\t\t\"headImg\": \"头像\",\n"
      + "\t\t\t\"sex\": \"性别\",\n"
      + "\t\t\t\"birthday\": \"\",\n"
      + "\t\t\t\"mobile\": \"手机号\",\n"
      + "\t\t\t\"level\": \"会员等级编码\",\n"
      + "\t\t\t\"mallId\": \"1\",\n"
      + "\t\t\t\"crmCode\": \"第三方会员ID\",\n"
      + "\t\t\t\"cardCode\": \"第三方会员卡号\"\n"
      + "\n"
      + "\t\t},\n"
      + "\t\t\"orderItems\": [{\n"
      + "\t\t\t\"itemName\": \"商品名称\",\n"
      + "\t\t\t\"itemImage\": \"图片地址\",\n"
      + "\t\t\t\"count\": 1,\n"
      + "\t\t\t\"orderItemPrices\": [{\n"
      + "\t\t\t\t\"currency\": \"cny\",\n"
      + "\t\t\t\t\"currencyName\": \"cny\",\n"
      + "\t\t\t\t\"unitPrice\": \"1.10\",\n"
      + "\t\t\t\t\"totalPrice\": null\n"
      + "\t\t\t}],\n"
      + "\t\t\t\"source\": \"来源\",\n"
      + "\t\t\t\"sourceId\": \"来源ID\",\n"
      + "\t\t\t\"shopId\": \"站点ID\",\n"
      + "\t\t\t\"shopName\": \"站点名称\"\n"
      + "\n"
      + "\t\t}],\n"
      + "\t\t\"orderPaymentItems\": [{\n"
      + "\t\t\t\"currency\": \"credit\",\n"
      + "\t\t\t\"outTradeNo\": \"0220200724102645048400\",\n"
      + "\t\t\t\"paymentAmount\": \"300.00\",\n"
      + "\t\t\t\"paymentSn\": \"115803441690651\",\n"
      + "\t\t\t\"paymentSource\": \"credit\",\n"
      + "\t\t\t\"paymentTime\": 1595557605,\n"
      + "\t\t\t\"paymentTypeCode\": \"credit\",\n"
      + "\t\t\t\"paymentTypeId\": \"a1\",\n"
      + "\t\t\t\"paymentTypeName\": \"积分\"\n"
      + "\t\t}],\n"
      + "\t\t\"giftItems\": [{\n"
      + "\t\t\t\"id\": \"主键ID \",\n"
      + "\t\t\t\"giftCode\": \"第三方赠品Code\",\n"
      + "\t\t\t\"giftName\": \"第三方赠品名称\",\n"
      + "\t\t\t\"giftPrice\": 80.0,\n"
      + "\t\t\t\"giftRules\": \"第三方赠品规则\",\n"
      + "\t\t\t\"giftNum\": 5,\n"
      + "\t\t\t\"giftUUId\": \"第三方赠品uuId\",\n"
      + "\t\t\t\"giftType\": \"第三方赠品类型\"\n"
      + "\t\t}]\n"
      + "\t}],\n"
      + "\t\"encrypted\": false\n"
      + "}";
  }

  @RequestMapping("/oil/record/{orderSn}")
  public String listOrder(@ApiParam("orderSn") @PathVariable("orderSn") String orderSn) {
    System.out.println("sn:" + orderSn);
    return "{\"errorCode\":\"0\"}";
  }

  @RequestMapping("/v1/dqsh/ims/order/sync")
  public String invoice() {
    System.out.println("sn:");
    return "{\"code\":1,\"message\":\" test\"}";
  }
}