package com.yang.springbootdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springbootdemo.action.ActionUrlConsts;
import com.yang.springbootdemo.service.TestTransactionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * springbootdemo<br> Created by yangxiaohua on 2018/12/11.
 */
@RestController
@RequestMapping(ControllerUrlConsts.URL_HELLO)
public class HelloController {

  @Resource(name = "controllerExcuter")
  ControllerExcuter excuter;

  @GetMapping(value = "hello")
  public String hello(){
    return "hello";
  }

  @RequestMapping(value = "/api/v3/securities/devices/register", method = RequestMethod.POST)

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

  @RequestMapping(value = "/api/v3/member/oils/record/list", method = RequestMethod.GET)
  public String listOrder() {
    String ramdon = String.valueOf(System.currentTimeMillis() / 1000);
    return "{\n"
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
      + "\t\t\"orderSn\": \"286" + ramdon + "\",\n"
      + "\t\t\"orderTime\": 1602504261,\n"
      + "\t\t\"invalidTime\": \"1602507261\",\n"
      + "\t\t\"memberId\": \"CknTR3NNalBp2GuJ\",\n"
      + "\t\t\"statusCode\": \"waitrefueling\",\n"
      + "\t\t\"refundTotalCredit\": null,\n"
      + "\t\t\"orderTotalCredit\": null,\n"
      + "\t\t\"carPlate\": \"苏E xxxxx\",\n"
      + "\t\t\"orderTotalAmount\": \"1232.80\",\n"
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
      + "\t\t\t\"level\": \"4\",\n"
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
      + "\t\t},\n"
      + "\t\t{\n"
      + "\t\t\t\"currency\": \"cny\",\n"
      + "\t\t\t\"paymentAmount\": \"0.20\",\n"
      + "\t\t\t\"paymentSn\": \"805713336623007\",\n"
      + "\t\t\t\"paymentTime\": null,\n"
      + "\t\t\t\"paymentTypeCode\": \"walletDiscount\",\n"
      + "\t\t\t\"paymentTypeName\": \"储值账户优惠\",\n"
      + "\t\t\t\"outTradeNo\": null\n"
      + "\t\t}],\n"
      + "\t\t\"giftItems\":  [{\n"
      + "\t\t\t\"id\": \"4w97a8fd9as79\",\n"
      + "\t\t\t\"giftCode\": \"3004567\",\n"
      + "\t\t\t\"giftName\": \"飞机\",\n"
      + "\t\t\t\"giftPrice\": \"0\",\n"
      + "\t\t\t\"giftRules\": \"rule1122224\",\n"
      + "\t\t\t\"giftNum\": 1,\n"
      + "\t\t\t\"giftUuId\": \"123431237\",\n"
      + "\t\t\t\"giftType\": \"类型\"\n"
      + "\t\t},{\n"
      + "\t\t\t\"id\": \"4w97a8fd9as79\",\n"
      + "\t\t\t\"giftCode\": \"3001234\",\n"
      + "\t\t\t\"giftName\": \"火箭\",\n"
      + "\t\t\t\"giftPrice\": \"0\",\n"
      + "\t\t\t\"giftRules\": \"rule11223344\",\n"
      + "\t\t\t\"giftNum\": 8,\n"
      + "\t\t\t\"giftUuId\": \"1234987\",\n"
      + "\t\t\t\"giftType\": \"类型\"\n"
      + "\t\t}]},{\n"
      + "\t\t\"orderId\": \"CrBQbwWvb1aZvf6t\",\n"
      + "\t\t\"orderSn\": \"286" + ramdon + "1\",\n"
      + "\t\t\"orderTime\": 1602504261,\n"
      + "\t\t\"invalidTime\": \"1602507261\",\n"
      + "\t\t\"memberId\": \"CknTR3NNalBp2GuJ\",\n"
      + "\t\t\"statusCode\": \"waitrefueling\",\n"
      + "\t\t\"refundTotalCredit\": null,\n"
      + "\t\t\"orderTotalCredit\": null,\n"
      + "\t\t\"carPlate\": \"苏E xxxxx\",\n"
      + "\t\t\"orderTotalAmount\": \"280\",\n"
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
      + "\t\t\t\"level\": \"4\",\n"
      + "\t\t\t\"mallId\": \"1\",\n"
      + "\t\t\t\"crmCode\": \"03f09dbe2e4e4bc28e7a1fd4a9df4c7c\",\n"
      + "\t\t\t\"cardCode\": \"xll\"\n"
      + "\t\t},\n"
      + "\t\t\"orderItems\": [{\n"
      + "\t\t\t\"itemName\": \"95#汽油\",\n"
      + "\t\t\t\"count\": \"1\",\n"
      + "\t\t\t\"orderItemPrices\": [{\n"
      + "\t\t\t\t\"currency\": \"cny\",\n"
      + "\t\t\t\t\"currencyName\": null,\n"
      + "\t\t\t\t\"unitPrice\": \"5.88\",\n"
      + "\t\t\t\t\"totalPrice\": \"300\"\n"
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
      + "\t\t\t\"paymentAmount\": \"280\",\n"
      + "\t\t\t\"paymentSn\": \"142461248840051\",\n"
      + "\t\t\t\"paymentTime\": 1602504299,\n"
      + "\t\t\t\"paymentTypeCode\": \"wallet\",\n"
      + "\t\t\t\"paymentTypeName\": \"桥桥钱包\",\n"
      + "\t\t\t\"outTradeNo\": null\n"
      + "\t\t},\n"
      + "\t\t{\n"
      + "\t\t\t\"currency\": \"cny\",\n"
      + "\t\t\t\"paymentAmount\": \"20\",\n"
      + "\t\t\t\"paymentSn\": \"805713336623007\",\n"
      + "\t\t\t\"paymentTime\": null,\n"
      + "\t\t\t\"paymentTypeCode\": \"coupon\",\n"
      + "\t\t\t\"paymentTypeName\": \"券优惠\",\n"
      + "\t\t\t\"outTradeNo\": null\n"
      + "\t\t}],\n"
      + "\t\t\"giftItems\":  [{\n"
      + "\t\t\t\"id\": \"4w97a8fd9as79\",\n"
      + "\t\t\t\"giftCode\": \"3004567\",\n"
      + "\t\t\t\"giftName\": \"飞机\",\n"
      + "\t\t\t\"giftPrice\": \"0\",\n"
      + "\t\t\t\"giftRules\": \"rule1122224\",\n"
      + "\t\t\t\"giftNum\": 1,\n"
      + "\t\t\t\"giftUuId\": \"1234987\",\n"
      + "\t\t\t\"giftType\": \"类型\"\n"
      + "\t\t},{\n"
      + "\t\t\t\"id\": \"4w97a8fd9as79\",\n"
      + "\t\t\t\"giftCode\": \"3001234\",\n"
      + "\t\t\t\"giftName\": \"火箭\",\n"
      + "\t\t\t\"giftPrice\": \"0\",\n"
      + "\t\t\t\"giftRules\": \"rule11223344\",\n"
      + "\t\t\t\"giftNum\": 8,\n"
      + "\t\t\t\"giftUuId\": \"1234987\",\n"
      + "\t\t\t\"giftType\": \"类型\"\n"
      + "\t\t}]\n"
      + "\t}],\n"
      + "\t\"encrypted\": false\n"
      + "}";
  }

  @RequestMapping(value = "/api/v3/member/oils/record/{orderSn}", method = RequestMethod.GET)
  public String querySpecialOrder(@ApiParam("orderSn") @PathVariable("orderSn") String orderSn) {
    System.out.println("sn:" + orderSn);
//    return "{\n"
//      + "\t\"errorCode\": \"PUB-00000\",\n"
//      + "\t\"errorMessage\": \"成功\",\n"
//      + "\t\"extra\": null,\n"
//      + "\t\"display\": true,\n"
//      + "\t\"exception\": null,\n"
//      + "\t\"reqTime\": 1602761627,\n"
//      + "\t\"costTime\": 4,\n"
//      + "\t\"skipType\": null,\n"
//      + "\t\"serviceTime\": 1602761628,\n"
//      + "\t\"skipParam\": null,\n"
//      + "\t\"body\": {\n"
//      + "\t\t\"orderId\": \"CrBQbwWvb1aZvf6t\",\n"
//      + "\t\t\"orderSn\": \"" + orderSn + "\",\n"
//      + "\t\t\"orderTime\": " + System.currentTimeMillis() / 1000 + ",\n"
//      + "\t\t\"invalidTime\": \"1602507261\",\n"
//      + "\t\t\"memberId\": \"CknTR3NNalBp2GuJ\",\n"
//      + "\t\t\"statusCode\": \"waitrefueling\",\n"
//      + "\t\t\"refundTotalCredit\": null,\n"
//      + "\t\t\"orderTotalCredit\": null,\n"
//      + "\t\t\"carPlate\": \"苏E xxxxx\",\n"
//      + "\t\t\"orderTotalAmount\": \"1233.00\",\n"
//      + "\t\t\"orderReceivedAmount\": \"122.50\",\n"
//      + "\t\t\"refundTotalAmount\": null,\n"
//      + "\t\t\"orderType\": null,\n"
//      + "\t\t\"memberInfo\": {\n"
//      + "\t\t\t\"id\": null,\n"
//      + "\t\t\t\"name\": \"张涛\",\n"
//      + "\t\t\t\"nickName\": \"151****3005\",\n"
//      + "\t\t\t\"headImg\": \"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLPiaj14cVKiaicYsugv4Y9WNwSz0CeVbssD9ZdiaJSia1SiaJkcib4ruf4ia2MMvwKibutFVbrg1zspUiaVRdw/132\",\n"
//      + "\t\t\t\"sex\": null,\n"
//      + "\t\t\t\"birthday\": \"1092672000\",\n"
//      + "\t\t\t\"mobile\": \"15189063005\",\n"
//      + "\t\t\t\"level\": \"4\",\n"
//      + "\t\t\t\"mallId\": \"1\",\n"
//      + "\t\t\t\"crmCode\": \"03f09dbe2e4e4bc28e7a1fd4a9df4c7c\",\n"
//      + "\t\t\t\"cardCode\": null\n"
//      + "\t\t},\n"
//      + "\t\t\"orderItems\": [{\n"
//      + "\t\t\t\"itemName\": \"95#汽油\",\n"
//      + "\t\t\t\"count\": \"1\",\n"
//      + "\t\t\t\"orderItemPrices\": [{\n"
//      + "\t\t\t\t\"currency\": \"cny\",\n"
//      + "\t\t\t\t\"currencyName\": null,\n"
//      + "\t\t\t\t\"unitPrice\": \"5.88\",\n"
//      + "\t\t\t\t\"totalPrice\": \"123.00\"\n"
//      + "\t\t\t}],\n"
//      + "\t\t\t\"source\": \"oilsThird\",\n"
//      + "\t\t\t\"sourceId\": \"Wxy3JoJcbmQ8oVMW\",\n"
//      + "\t\t\t\"shopName\": \"郑州兴隆油站\",\n"
//      + "\t\t\t\"oilGunInfo\": {\n"
//      + "\t\t\t\t\"id\": \"Wxy3JoJcbmQ8oVMW\",\n"
//      + "\t\t\t\t\"shopId\": \"0Cad6pn9mJ9nrQow\",\n"
//      + "\t\t\t\t\"storeNo\": \"000\",\n"
//      + "\t\t\t\t\"gunNo\": \"01\",\n"
//      + "\t\t\t\t\"oilsName\": \"95#汽油\",\n"
//      + "\t\t\t\t\"oilsCode\": \"1020\"\n"
//      + "\t\t\t},\n"
//      + "\t\t\t\"itemImage\": null\n"
//      + "\t\t}],\n"
//      + "\t\t\"orderPaymentItems\": [{\n"
//      + "\t\t\t\"currency\": \"cny\",\n"
//      + "\t\t\t\"paymentAmount\": \"122.50\",\n"
//      + "\t\t\t\"paymentSn\": \"142461248840051\",\n"
//      + "\t\t\t\"paymentTime\": 1602504299,\n"
//      + "\t\t\t\"paymentTypeCode\": \"wallet\",\n"
//      + "\t\t\t\"paymentTypeName\": \"桥桥钱包\",\n"
//      + "\t\t\t\"outTradeNo\": null\n"
//      + "\t\t},{\n"
//      + "\t\t\t\"currency\": \"cny\",\n"
//      + "\t\t\t\"paymentAmount\": \"0.20\",\n"
//      + "\t\t\t\"paymentSn\": \"805713336623007\",\n"
//      + "\t\t\t\"paymentTime\": null,\n"
//      + "\t\t\t\"paymentTypeCode\": \"coupon\",\n"
//      + "\t\t\t\"paymentTypeName\": \"券优惠\",\n"
//      + "\t\t\t\"outTradeNo\": null\n"
//      + "\t\t},{\n"
//      + "\t\t\t\"currency\": \"cny\",\n"
//      + "\t\t\t\"paymentAmount\": \"0.30\",\n"
//      + "\t\t\t\"paymentSn\": \"395487289638366\",\n"
//      + "\t\t\t\"paymentTime\": null,\n"
//      + "\t\t\t\"paymentTypeCode\": \"walletDiscount\",\n"
//      + "\t\t\t\"paymentTypeName\": \"储值账户优惠\",\n"
//      + "\t\t\t\"outTradeNo\": null\n"
//      + "\t\t}],\n"
//      + "\t\t\"giftItems\": [{\n"
//      + "\t\t\t\"id\": \"4w97a8fd9as79\",\n"
//      + "\t\t\t\"giftCode\": \"03050510\",\n"
//      + "\t\t\t\"giftName\": \"飞机\",\n"
//      + "\t\t\t\"giftPrice\": \"0\",\n"
//      + "\t\t\t\"giftRules\": \"rule1122224\",\n"
//      + "\t\t\t\"giftNum\": 1,\n"
//      + "\t\t\t\"giftUuId\": \"3003744\",\n"
//      + "\t\t\t\"giftType\": \"类型\"\n"
//      + "\t\t},{\n"
//      + "\t\t\t\"id\": \"4w97a8fd9as79\",\n"
//      + "\t\t\t\"giftCode\": \"03050505\",\n"
//      + "\t\t\t\"giftName\": \"火箭\",\n"
//      + "\t\t\t\"giftPrice\": \"0\",\n"
//      + "\t\t\t\"giftRules\": \"rule11223344\",\n"
//      + "\t\t\t\"giftNum\": 8,\n"
//      + "\t\t\t\"giftUuId\": \"3003739\",\n"
//      + "\t\t\t\"giftType\": \"类型\"\n"
//      + "\t\t}]\n"
//      + "\t},\n"
//      + "\t\"encrypted\": false\n"
//      + "}";
    return buildTestOrderJson();
  }

  private String buildTestOrderJson() {
    return "{\"errorCode\":\"PUB-00000\",\"errorMessage\":\"成功\",\"extra\":null,\"display\":true,\"exception\":null,\"reqTime\":1612667957,\"costTime\":7,\"skipType\":null,\"serviceTime\":1612667959,\"skipParam\":null,\"body\":{\"orderId\":\"CGIUvunOSgx7Fu1c\",\"orderSn\":\"391185574342352\",\"orderTime\":1612665441,\"invalidTime\":\"1612665741\",\"memberId\":\"Cp9qYkve6Af0H2YX\",\"statusCode\":\"waitrefueling\",\"refundTotalCredit\":null,\"orderTotalCredit\":null,\"carPlate\":\"豫A12345\",\"carType\":\"轿车\",\"carColor\":\"特殊颜色\",\"orderTotalAmount\":\"200.00\",\"orderReceivedAmount\":\"200.00\",\"refundTotalAmount\":null,\"orderType\":\"refueling\",\"memberInfo\":{\"id\":null,\"name\":\"李清帅\",\"nickName\":\"RAIN\",\"headImg\":\"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKQvK6qicyk2krl86Wu2dJE6mVmBVJsvVZqVMybtNdWliaT4hz6nANq14TPSkowdzcqv1RyJxiaVlXSQ/132\",\"sex\":null,\"birthday\":\"614271600\",\"mobile\":\"13838273229\",\"level\":\"002\",\"mallId\":\"1\",\"crmCode\":\"bda7d0f3d4e34ea8977211aae4d8981b\",\"cardCode\":\"885923194692570773\"},\"orderItems\":[{\"itemName\":\"92#汽油\",\"count\":\"1\",\"orderItemPrices\":[{\"currency\":\"cny\",\"currencyName\":null,\"unitPrice\":\"5.18\",\"totalPrice\":\"200.00\"}],\"source\":\"refueling\",\"sourceId\":\"WsMmHJLzEorq1rmb\",\"shopName\":\"郑州花园路油站\",\"oilGunInfo\":{\"id\":\"WsMmHJLzEorq1rmb\",\"shopId\":\"qheE0XKJkpkIawB4\",\"storeNo\":\"11102202\",\"gunNo\":\"03\",\"oilsName\":\"92#汽油\",\"oilsCode\":\"1020\"},\"itemImage\":null}],\"orderPaymentItems\":[{\"currency\":\"cny\",\"paymentAmount\":\"200.00\",\"paymentSn\":\"475258834374372\",\"paymentTime\":1612665469,\"paymentTypeCode\":\"thirdWxpay\",\"paymentTypeName\":\"微信支付\",\"outTradeNo\":\"4200000913202102070295939011\"}],\"giftItems\":[]},\"encrypted\":false}";
  }

  @RequestMapping(value = "/api/v3/member/oils/record/confirm", method = RequestMethod.POST)
  public String confirm(@RequestParam String accessToken,
    @RequestBody String request) {
    String test = "1";
    return "{\n"
      + "\t\"errorCode\": \"PUB-00000\",\n"
      + "\t\"errorMessage\": \"失败了\"\n"
      + "}";
  }

  @RequestMapping(value = "/api/v3/member/oils/record/refueling/cancel", method = RequestMethod.POST)
  public String cancel(@RequestParam String accessToken,
    @RequestBody String request) {
    return "{\n"
      + "\t\"errorCode\": \"PUB-00000\",\n"
      + "\t\"errorMessage\": \"失败了\"\n"
      + "}";
  }

  @RequestMapping(value = "/api/v3/member/oils/record/refund", method = RequestMethod.POST)
  public String refund(@RequestParam String accessToken,
    @RequestBody String request) {
    return "{\n"
      + "\t\"errorCode\": \"PUB-00000\",\n"
      + "\t\"errorMessage\": \"失败了\"\n"
      + "}";
  }

  @RequestMapping(value = "/api/v3/member/oils/record/refuelSuccess", method = RequestMethod.POST)
  public String refuelSuccess(@RequestParam String accessToken,
    @RequestBody String request) {
    return "{\n"
      + "\t\"errorCode\": \"PUB-00000\",\n"
      + "\t\"errorMessage\": \"失败了\"\n"
      + "}";
  }

  @RequestMapping(value = "/v1/dqsh/ims/order/sync", method = RequestMethod.POST)
  public String invoice() {
    System.out.println("sn:");
    return "{\"code\":1,\"message\":\" test\"}";
  }

  @Autowired
  private TestTransactionService service;

  @ApiOperation("transaction测试")
  @RequestMapping(value = "/testTransaction", method = RequestMethod.POST)
  public void testTransaction() {
    try {
      service.methodA();
      service.methodB();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}