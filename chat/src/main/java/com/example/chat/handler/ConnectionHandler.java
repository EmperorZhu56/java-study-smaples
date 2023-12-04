package com.example.chat.handler;

import com.example.chat.ChatServer;
import com.example.chat.Command;
import com.example.chat.Result;
import io.netty.channel.ChannelHandlerContext;

public class ConnectionHandler {
    public static void execute(ChannelHandlerContext ctx, Command command) {
        ChatServer.addUser(command.getName(), ctx.channel());

        ctx.channel().writeAndFlush(Result.ok("与服务器连接成功"));
    }

}
