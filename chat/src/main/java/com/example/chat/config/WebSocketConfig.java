package com.example.chat.config;


import com.example.chat.handler.MessageHandler;
import com.example.chat.handler.MessageHandshakeInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


/**
 * websocket配置
 *
 * @author 朱滔
 * @date 2022/10/05 18:15:51
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Resource
    private MessageHandler messageHandler;

    @Resource
    private MessageHandshakeInterceptor messageHandshakeInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(messageHandler, "/history/{uid}")
                .setAllowedOrigins("*")
                .addInterceptors(messageHandshakeInterceptor);
    }
}
