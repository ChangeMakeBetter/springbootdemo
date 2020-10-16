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
  public String register(@RequestParam String deviceId, @RequestParam String appKey, @RequestParam String rnd) {
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

  private String ramdon;

  private String json = "{\n"
    + "\t\"errorCode\": \"PUB-00000\",\n"
    + "\t\"errorMessage\": \"成功\",\n"
    + "\t\"extra\": null,\n"
    + "\t\"display\": true,\n"
    + "\t\"exception\": null,\n"
    + "\t\"reqTime\": 1602730229,\n"
    + "\t\"costTime\": 6,\n"
    + "\t\"skipType\": null,\n"
    + "\t\"serviceTime\": 1602730230,\n"
    + "\t\"skipParam\": null,\n"
    + "\t\"body\": [{\n"
    + "\t\t\"orderId\": \"CrBQbwWvb1aZvf6t\",\n"
    + "\t\t\"orderSn\": \"286339423738739\",\n"
    + "\t\t\"orderTime\": 1602504261,\n"
    + "\t\t\"invalidTime\": \"1602507261\",\n"
    + "\t\t\"memberId\": \"CknTR3NNalBp2GuJ\",\n"
    + "\t\t\"statusCode\": \"waitrefueling\",\n"
    + "\t\t\"refundTotalCredit\": null,\n"
    + "\t\t\"orderTotalCredit\": null,\n"
    + "\t\t\"cardPlate\": \"苏E xxxxx\",\n"
    + "\t\t\"orderTotalAmount\": \"122.80\",\n"
    + "\t\t\"refundTotalAmount\": null,\n"
    + "\t\t\"orderType\": null,\n"
    + "\t\t\"memberInfo\": {\n"
    + "\t\t\t\"id\": null,\n"
    + "\t\t\t\"name\": \"张涛\",\n"
    + "\t\t\t\"nickName\": \"151****3005\",\n"
    + "\t\t\t\"headImg\": \"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLPiaj14cVKiaicYsugv4Y9WNwSz0CeVbssD9ZdiaJSia1SiaJkcib4ruf4ia2MMvwKibutFVbrg1zspUiaVRdw/132\",\n"
    + "\t\t\t\"sex\": null,\n"
    + "\t\t\t\"birthday\": \"1092672000\",\n"
    + "\t\t\t\"mobile\": \"15189063005\",\n"
    + "\t\t\t\"level\": null,\n"
    + "\t\t\t\"mallId\": \"1\",\n"
    + "\t\t\t\"crmCode\": \"03f09dbe2e4e4bc28e7a1fd4a9df4c7c\",\n"
    + "\t\t\t\"cardCode\": null\n"
    + "\t\t},\n"
    + "\t\t\"orderItems\": [{\n"
    + "\t\t\t\"itemName\": \"95#汽油\",\n"
    + "\t\t\t\"count\": \"1\",\n"
    + "\t\t\t\"orderItemPrices\": [{\n"
    + "\t\t\t\t\"currency\": \"cny\",\n"
    + "\t\t\t\t\"currencyName\": null,\n"
    + "\t\t\t\t\"unitPrice\": \"5.88\",\n"
    + "\t\t\t\t\"totalPrice\": \"123.00\"\n"
    + "\t\t\t}],\n"
    + "\t\t\t\"source\": \"oilsThird\",\n"
    + "\t\t\t\"sourceId\": \"Wxy3JoJcbmQ8oVMW\",\n"
    + "\t\t\t\"shopName\": \"郑州兴隆油站\",\n"
    + "\t\t\t\"oilGunInfo\": {\n"
    + "\t\t\t\t\"id\": \"Wxy3JoJcbmQ8oVMW\",\n"
    + "\t\t\t\t\"shopId\": \"0Cad6pn9mJ9nrQow\",\n"
    + "\t\t\t\t\"storeNo\": \"11102101\",\n"
    + "\t\t\t\t\"gunNo\": \"01\",\n"
    + "\t\t\t\t\"oilsName\": \"95#汽油\",\n"
    + "\t\t\t\t\"oilsCode\": \"1040\"\n"
    + "\t\t\t},\n"
    + "\t\t\t\"itemImage\": null\n"
    + "\t\t}],\n"
    + "\t\t\"orderPaymentItems\": [{\n"
    + "\t\t\t\t\"currency\": \"cny\",\n"
    + "\t\t\t\t\"paymentAmount\": \"122.80\",\n"
    + "\t\t\t\t\"paymentSn\": \"142461248840051\",\n"
    + "\t\t\t\t\"paymentTime\": 1602504299,\n"
    + "\t\t\t\t\"paymentTypeCode\": \"wallet\",\n"
    + "\t\t\t\t\"paymentTypeName\": \"桥桥钱包\",\n"
    + "\t\t\t\t\"outTradeNo\": null\n"
    + "\t\t\t}\n"
    + "\t\t],\n"
    + "\t\t\"giftItems\": []\n"
    + "\t}],\n"
    + "\t\"encrypted\": false\n"
    + "}";

  @RequestMapping("/api/v3/member/oils/record/list")
  public String listOrder() {
    return json;
  }

  @RequestMapping("/api/v3/member/oils/record/{orderSn}")
  public String querySpecialOrder(@ApiParam("orderSn") @PathVariable("orderSn") String orderSn) {
    System.out.println("sn:" + orderSn);
    return "{\n"
      + "\t\"errorCode\": \"PUB-00000\",\n"
      + "\t\"errorMessage\": \"成功\",\n"
      + "\t\"extra\": null,\n"
      + "\t\"display\": true,\n"
      + "\t\"exception\": null,\n"
      + "\t\"reqTime\": 1602761627,\n"
      + "\t\"costTime\": 4,\n"
      + "\t\"skipType\": null,\n"
      + "\t\"serviceTime\": 1602761628,\n"
      + "\t\"skipParam\": null,\n"
      + "\t\"body\": {\n"
      + "\t\t\"orderId\": \"CrBQbwWvb1aZvf6t\",\n"
      + "\t\t\"orderSn\": \"286" + System.currentTimeMillis() / 1000000 + "389\",\n"
      + "\t\t\"orderTime\": 1602504261,\n"
      + "\t\t\"invalidTime\": \"1602507261\",\n"
      + "\t\t\"memberId\": \"CknTR3NNalBp2GuJ\",\n"
      + "\t\t\"statusCode\": \"waitrefueling\",\n"
      + "\t\t\"refundTotalCredit\": null,\n"
      + "\t\t\"orderTotalCredit\": null,\n"
      + "\t\t\"cardPlate\": \"苏E xxxxx\",\n"
      + "\t\t\"orderTotalAmount\": \"122.80\",\n"
      + "\t\t\"refundTotalAmount\": null,\n"
      + "\t\t\"orderType\": null,\n"
      + "\t\t\"memberInfo\": {\n"
      + "\t\t\t\"id\": null,\n"
      + "\t\t\t\"name\": \"张涛\",\n"
      + "\t\t\t\"nickName\": \"151****3005\",\n"
      + "\t\t\t\"headImg\": \"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLPiaj14cVKiaicYsugv4Y9WNwSz0CeVbssD9ZdiaJSia1SiaJkcib4ruf4ia2MMvwKibutFVbrg1zspUiaVRdw/132\",\n"
      + "\t\t\t\"sex\": null,\n"
      + "\t\t\t\"birthday\": \"1092672000\",\n"
      + "\t\t\t\"mobile\": \"15189063005\",\n"
      + "\t\t\t\"level\": null,\n"
      + "\t\t\t\"mallId\": \"1\",\n"
      + "\t\t\t\"crmCode\": \"03f09dbe2e4e4bc28e7a1fd4a9df4c7c\",\n"
      + "\t\t\t\"cardCode\": null\n"
      + "\t\t},\n"
      + "\t\t\"orderItems\": [{\n"
      + "\t\t\t\"itemName\": \"95#汽油\",\n"
      + "\t\t\t\"count\": \"1\",\n"
      + "\t\t\t\"orderItemPrices\": [{\n"
      + "\t\t\t\t\"currency\": \"cny\",\n"
      + "\t\t\t\t\"currencyName\": null,\n"
      + "\t\t\t\t\"unitPrice\": \"5.88\",\n"
      + "\t\t\t\t\"totalPrice\": \"123.00\"\n"
      + "\t\t\t}],\n"
      + "\t\t\t\"source\": \"oilsThird\",\n"
      + "\t\t\t\"sourceId\": \"Wxy3JoJcbmQ8oVMW\",\n"
      + "\t\t\t\"shopName\": \"郑州兴隆油站\",\n"
      + "\t\t\t\"oilGunInfo\": {\n"
      + "\t\t\t\t\"id\": \"Wxy3JoJcbmQ8oVMW\",\n"
      + "\t\t\t\t\"shopId\": \"0Cad6pn9mJ9nrQow\",\n"
      + "\t\t\t\t\"storeNo\": \"11102101\",\n"
      + "\t\t\t\t\"gunNo\": \"01\",\n"
      + "\t\t\t\t\"oilsName\": \"95#汽油\",\n"
      + "\t\t\t\t\"oilsCode\": \"1040\"\n"
      + "\t\t\t},\n"
      + "\t\t\t\"itemImage\": null\n"
      + "\t\t}],\n"
      + "\t\t\"orderPaymentItems\": [{\n"
      + "\t\t\t\"currency\": \"cny\",\n"
      + "\t\t\t\"paymentAmount\": \"122.80\",\n"
      + "\t\t\t\"paymentSn\": \"142461248840051\",\n"
      + "\t\t\t\"paymentTime\": 1602504299,\n"
      + "\t\t\t\"paymentTypeCode\": \"wallet\",\n"
      + "\t\t\t\"paymentTypeName\": \"桥桥钱包\",\n"
      + "\t\t\t\"outTradeNo\": null\n"
      + "\t\t}],\n"
      + "\t\t\"giftItems\": []\n"
      + "\t},\n"
      + "\t\"encrypted\": false\n"
      + "}";
  }

  @RequestMapping("/api/v3/member/oils/record/confirm")
  public String confirm(@RequestParam String accessToken,
    @RequestBody String request) {
    return "{\n"
      + "\t\"errorCode\": \"PUB-00000\",\n"
      + "\t\"errorMessage\": \"失败了\"\n"
      + "}";
  }

  @RequestMapping("/api/v3/member/oils/record/refueling/cancel")
  public String cancel(@RequestParam String accessToken,
    @RequestBody String request) {
    return "{\n"
      + "\t\"errorCode\": \"PUB-00000\",\n"
      + "\t\"errorMessage\": \"失败了\"\n"
      + "}";
  }

  @RequestMapping("/api/v3/member/oils/record/refund")
  public String refund(@RequestParam String accessToken,
    @RequestBody String request) {
    return "{\n"
      + "\t\"errorCode\": \"PUB-00000\",\n"
      + "\t\"errorMessage\": \"失败了\"\n"
      + "}";
  }

  @RequestMapping("/api/v3/member/oils/record/refuelSuccess")
  public String refuelSuccess(@RequestParam String accessToken,
    @RequestBody String request) {
    return "{\n"
      + "\t\"errorCode\": \"PUB-00000\",\n"
      + "\t\"errorMessage\": \"失败了\"\n"
      + "}";
  }

  @RequestMapping("/v1/dqsh/ims/order/sync")
  public String invoice() {
    System.out.println("sn:");
    return "{\"code\":1,\"message\":\" test\"}";
  }
}