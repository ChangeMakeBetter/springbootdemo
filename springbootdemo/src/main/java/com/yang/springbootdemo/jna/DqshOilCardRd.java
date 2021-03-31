package com.yang.springbootdemo.jna;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.sun.jna.FunctionMapper;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.yang.springbootdemo.jna.dqsh.api.BalanceResponse;
import com.yang.springbootdemo.jna.dqsh.api.CardInfo;
import com.yang.springbootdemo.jna.dqsh.api.GrayResponse;
import com.yang.springbootdemo.jna.dqsh.api.ReturnData;
import com.yang.springbootdemo.util.Converter;
import lombok.extern.slf4j.Slf4j;

/**
 * 并非标准的IcRd接口，外部使用时自行强转，直接调用public方法
 *
 * @author zhangxinkun
 */
@Slf4j
@Component
public class DqshOilCardRd {

  // 用户卡卡槽索引
  private int userSlotIndex;

  private File dllFile;

  private boolean initSuccess = false;

  private String getMessages(String args, String... values) {
    return args;
  }

  public void load() {
    try {
      Map<String, String> params = new HashMap<>();
      String param = StringUtils.trimToEmpty(params.get("portNo"));
      final File dllHome;
      dllHome = new File("/temp/dqsh/dll/");
      this.dllFile = new File(dllHome, "CardOperator.dll");

      if (!dllFile.exists()) {
        throw new Exception(getMessages("error.dllNotFound", dllFile.getAbsolutePath()));
      }
      log.info("load dll from: " + dllFile.getCanonicalPath());
      if (!Pattern.matches("\\d{1,2}", param)) {
        param = "0";// 配置错误则使用默认值
        // throw new Exception(getMessages("error.slotIndex"));
      }
      if (param.length() == 1) {
        userSlotIndex = 0;
      } else {
        userSlotIndex = Converter.toInt(param.substring(0, 1));
      }
      createLibraryProxy();
      initSuccess = true;
    } catch (Exception e) {
      initSuccess = false;
      log.error(e.getMessage());
    }
  }

  private CardLib library;

  private void createLibraryProxy() throws Exception {
    Map<String, Object> m = new HashMap<>();
    m.put(Library.OPTION_FUNCTION_MAPPER, new DllFunctionMapper());
    Native.setProtected(true);
    try {
      library = (CardLib) Native.loadLibrary(dllFile.getAbsolutePath(), CardLib.class, m);
    } catch (Throwable e) {
      log.error(e.getMessage());
      throw new Exception(e.getMessage());
    }
  }

  public interface CardLib extends Library {

    int getBalance(int userSlotIndex, byte[] password, BalanceResponse balance);

    int getCardInfo(int userSlotIndex, byte[] cardNo);

    int isGray(int userSlotIndex, byte[] password, GrayResponse grayResponse);

  }

  private final static class DllFunctionMapper implements FunctionMapper {

    private final Map<String, String> map = new HashMap<String, String>();

    public DllFunctionMapper() {
      map.put("getBalance", "GetBalance");
      map.put("getCardInfo", "GetCardInfo");
      map.put("isGray", "IsGray");
    }

    @Override
    public String getFunctionName(NativeLibrary nativeLibrary, Method method) {
      return map.get(method.getName());
    }
  }

  /**
   * 卡余额查询。
   *
   * @param password
   * @return
   */
  public ReturnData<CardInfo> queryCard(String password) {
    try {
      if (!initSuccess) {
        throw new Exception("驱动未加载成功");
      }
      boolean onlyQueryCard = password == null;
      byte[] cardNo = new byte[20 + 1];
      int ret = library.getCardInfo(userSlotIndex, cardNo);
      assertCodeOk(ret, getMessages("error.readCardFail"));
      final String cardCode = Converter.toString(cardNo);
      if (onlyQueryCard) {
        return ReturnData.success(new CardInfo(cardCode));
      }
      password = StringUtils.trimToEmpty(password);
      final byte[] passwordByte = Converter.toBytes(password);
      final GrayResponse grayResponse = GrayResponse.create();
      ret = library.isGray(userSlotIndex, passwordByte, grayResponse);
      assertCodeOk(ret, getMessages("error.readCardFail"));
      if (grayResponse.getIsGray()) {
        // 灰卡
        return ReturnData.fail(getMessages("error.isGray"));
      }
      final BalanceResponse balance = BalanceResponse.create();
      ret = library.getBalance(userSlotIndex, passwordByte, balance);
      if (ret != 0) {
        // 卡余额查询失败 不一定会用
        // return ReturnData.fail(getMessages("error.balanceFail"));
      }
      return ReturnData.success(new CardInfo(cardCode, balance.getBalance()));
    } catch (Exception e) {
      log.error(e.getMessage());
      return ReturnData.fail(e.getMessage());
    }
  }

  private void assertCodeOk(int ret, String defaultMessage) throws Exception {
    if (ret != 0) {
      throw new Exception("error:" + defaultMessage);
    }
  }

}
