package com.yang.springbootdemo.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * </br>
 * Created by yangxiaohua on 2021/1/27.
 */
//@Service
public class CustomWebSocketHandler extends TextWebSocketHandler implements WebSocketHandler {
  private Logger logger = LoggerFactory.getLogger(CustomWebSocketHandler.class);
  // 在线用户列表
  private static final Map<String, WebSocketSession> users;
  // 用户标识
  private static final String CLIENT_ID = "mchNo";

  static {
    users = new HashMap<>();
  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    logger.info("成功建立websocket-spring连接");
    String mchNo = getMchNo(session);
    if (StringUtils.isNotEmpty(mchNo)) {
      users.put(mchNo, session);
      session.sendMessage(new TextMessage("成功建立websocket-spring连接"));
      logger.info("用户标识：{}，Session：{}", mchNo, session.toString());
    }
  }

  private class MsgObj{
    private String to;
    private String msg;
    private String mchNo;

    public String getTo() {
      return to;
    }

    public void setTo(String to) {
      this.to = to;
    }

    public String getMsg() {
      return msg;
    }

    public void setMsg(String msg) {
      this.msg = msg;
    }

    public String getMchNo() {
      return mchNo;
    }

    public void setMchNo(String mchNo) {
      this.mchNo = mchNo;
    }
  }

  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message) {
    logger.info("收到客户端消息：{}", message.getPayload());
    MsgObj msgobj = null;

//    try {
//       msgobj = objectMapper.readValue(message.getPayload(),MsgObj.class);
//    } catch (JsonProcessingException e) {
//      e.printStackTrace();
//    }
    String to = Optional.ofNullable(msgobj.getTo()).orElse("");
    String msg = Optional.ofNullable(msgobj.getMsg()).orElse("");
    WebSocketMessage<?> webSocketMessageServer = new TextMessage("server:" +message);
    try {
      session.sendMessage(webSocketMessageServer);
      if ("all".equals(to.toLowerCase())) {
        sendMessageToAllUsers(new TextMessage(getMchNo(session) + ":" + msg));
      } else {
        //TODO
        sendMessageToUser("", new TextMessage(getMchNo(session) + ":" + msg));
      }
    } catch (IOException e) {
      logger.info("handleTextMessage method error：{}", e);
    }
  }

  @Override
  public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    if (session.isOpen()) {
      session.close();
    }
    logger.info("连接出错");
    users.remove(getMchNo(session));
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    logger.info("连接已关闭：" + status);
    users.remove(getMchNo(session));
  }

  @Override
  public boolean supportsPartialMessages() {
    return false;
  }

//  private static final ObjectMapper objectMapper = objectMapper();
//
//  private static ObjectMapper objectMapper() {
//    ObjectMapper mapper = new ObjectMapper();
//    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
//    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//    mapper.registerModule(new JaxbAnnotationModule());
//    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//    mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
//    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//    return mapper;
//  }


//  public void sendMessage(String jsonData) {
//    logger.info("收到客户端消息sendMessage：{}", jsonData);
//    MsgObj msgobj = null;
//    try {
//      msgobj = objectMapper.readValue(jsonData,MsgObj.class);
//    } catch (JsonProcessingException e) {
//      e.printStackTrace();
//    }
//    String mchNo = StringUtils.isEmpty(msgobj.getMchNo()) ? "陌生人" : msgobj.getMchNo();
//    String to = Optional.ofNullable(msgobj.getTo()).orElse("");
//    String msg = Optional.ofNullable(msgobj.getMsg()).orElse("");
//    if("all".equals(to.toLowerCase())) {
//      sendMessageToAllUsers(new TextMessage(mchNo + ":" +msg));
//    }else {
//      sendMessageToUser(to, new TextMessage(mchNo + ":" +msg));
//    }
//  }

  /**
   * 发送信息给指定用户
   * @Title: sendMessageToUser
   * @Description: TODO
   * @Date 2018年8月21日 上午11:01:08
   * @author OnlyMate
   * @param mchNo
   * @param message
   * @return
   */
  public boolean sendMessageToUser(String mchNo, TextMessage message) {
    if (users.get(mchNo) == null)
      return false;
    WebSocketSession session = users.get(mchNo);
    logger.info("sendMessage：{} ,msg：{}", session, message.getPayload());
    if (!session.isOpen()) {
      logger.info("客户端:{},已断开连接，发送消息失败", mchNo);
      return false;
    }
    try {
      session.sendMessage(message);
    } catch (IOException e) {
      logger.info("sendMessageToUser method error：{}", e);
      return false;
    }
    return true;
  }

  /**
   * 广播信息
   * @Title: sendMessageToAllUsers
   * @Description: TODO
   * @Date 2018年8月21日 上午11:01:14
   * @author OnlyMate
   * @param message
   * @return
   */
  public boolean sendMessageToAllUsers(TextMessage message) {
    boolean allSendSuccess = true;
    Set<String> mchNos = users.keySet();
    WebSocketSession session = null;
    for (String mchNo : mchNos) {
      try {
        session = users.get(mchNo);
        if (session.isOpen()) {
          session.sendMessage(message);
        }else {
          logger.info("客户端:{},已断开连接，发送消息失败", mchNo);
        }
      } catch (IOException e) {
        logger.info("sendMessageToAllUsers method error：{}", e);
        allSendSuccess = false;
      }
    }

    return allSendSuccess;
  }

  /**
   * 获取用户标识
   * @Title: getMchNo
   * @Description: TODO
   * @Date 2018年8月21日 上午11:01:01
   * @author OnlyMate
   * @param session
   * @return
   */
  private String getMchNo(WebSocketSession session) {
    try {
      String mchNo = session.getAttributes().get(CLIENT_ID).toString();
      return mchNo;
    } catch (Exception e) {
      return null;
    }
  }
}