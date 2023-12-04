package com.example.chat;

import lombok.Data;

@Data
public class Command {

    /**
     * 连接信息码
     */
    private Integer code;
    /**
     * 昵称
     */
    private String name;

}
