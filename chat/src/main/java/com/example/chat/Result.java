package com.example.chat;

import com.history.core.util.DateTimeUtil;
import com.history.core.util.JsonUtil;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Result {

    /**
     * 名字
     */
    private String name;
    /**
     * 时间
     */
    private LocalDateTime time;
    /**
     * 消息
     */
    private String message;

    public static TextWebSocketFrame error(String message) {
        return new TextWebSocketFrame(JsonUtil.format(new Result("系统消息", DateTimeUtil.now(), message)));
    }

    public static TextWebSocketFrame ok(String message) {
        return new TextWebSocketFrame(JsonUtil.format(new Result("系统消息", DateTimeUtil.now(), message)));
    }

    public static TextWebSocketFrame ok(String user, String message) {
        return new TextWebSocketFrame(JsonUtil.format(new Result(user, DateTimeUtil.now(), message)));
    }
}
