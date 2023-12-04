package com.example.chat.handler;

import com.history.core.util.EmptyUtil;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * 消息拦截器
 *
 * @author 朱滔
 * @date 2022/10/05 18:27:36
 */
@Component
public class MessageHandshakeInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        String path = request.getURI().getPath();
        if (EmptyUtil.isEmpty(path)) {
            return false;
        }
        String[] ss = path.split("/");
        if (ss == null) {
            return false;
        }
        attributes.put("uid", ss[2]);
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
