package com.example.chat.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 消息处理程序
 *
 * @author 朱滔
 * @date 2022/10/05 18:18:41
 */
@Component
@Slf4j
public class MessageHandler extends TextWebSocketHandler {

    public static final Map<String, WebSocketSession> SESSIONS = new HashMap<>();

    /**
     * 连接建立
     *
     * @param session 会话
     * @throws Exception 异常
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String uid = getUid(session);
        log.info("{}已连接", uid);
        SESSIONS.put(uid, session);
        session.sendMessage(new TextMessage("来了老弟"));
    }

    /**
     * 连接关闭
     *
     * @param session 会话
     * @param status  状态
     * @throws Exception 异常
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        SESSIONS.remove(getUid(session));
    }

    /**
     * 发送信息
     *
     * @param session 会话
     * @param message 消息
     * @throws Exception 异常
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        log.info("pong={}", message);
    }

    private String getUid(WebSocketSession session) {
        return Optional.ofNullable(session).map(s -> s.getAttributes().get("uid")).map(Object::toString).orElse(null);
    }
}
