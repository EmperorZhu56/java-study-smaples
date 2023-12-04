package com.example.chat.handler;


import com.example.chat.Command;
import com.example.chat.CommandType;
import com.example.chat.Result;
import com.history.core.util.EnumUtil;
import com.history.core.util.JsonUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;

import static com.example.chat.CommandType.CONNECTION;

@Slf4j
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame frame) {
        log.info(frame.text());
        Command command = JsonUtil.parse(frame.text(), Command.class);

        try {
            switch (EnumUtil.getEnumByValue(CommandType.class, command.getCode())) {
                case CONNECTION -> ConnectionHandler.execute(ctx, command);
                default -> ctx.channel().writeAndFlush(Result.error("无效code"));
            }
        } catch (Exception e) {
            ctx.channel().writeAndFlush(Result.error(e.getMessage()));
        }

    }
}
