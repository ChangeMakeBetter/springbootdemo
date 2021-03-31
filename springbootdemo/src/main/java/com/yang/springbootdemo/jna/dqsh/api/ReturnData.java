/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2019，所有权利保留。
 * 
 * 项目名：	jpos-common
 * 文件名：	ReturnData.java
 * 模块说明：	
 * 修改历史：
 * 2019年8月6日 - liuchenghao - 创建。
 */
package com.yang.springbootdemo.jna.dqsh.api;

/**
 * @author liuchenghao
 * 
 */
public class ReturnData<T> extends ReturnCode {
  private static final long serialVersionUID = 1L;

  private T data;

  public static <T> ReturnData<T> fail(String message) {
    return new ReturnData<T>(-1, message);
  }

  public static <T> ReturnData<T> warn(String message, T data) {
    ReturnData<T> returnData = new ReturnData<T>();
    returnData.setCode(ReturnCode.warn);
    returnData.setMessage(message);
    returnData.setData(data);
    return returnData;
  }

  public static <T> ReturnData<T> success(T data) {
    ReturnData<T> returnData = new ReturnData<T>();
    returnData.setData(data);
    return returnData;
  }

  public ReturnData() {
    super();
  }

  public ReturnData(int code, String message) {
    super(code, message);
  }

  public ReturnData(int code, String message, T data) {
    super(code, message);
    setData(data);
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void assertOk() throws Exception {
    if (!isOK()) {
      throw new Exception(getMessage());
    }
  }

}
