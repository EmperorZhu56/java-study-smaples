package com.example.chat;

import com.history.core.inter.Optionable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommandType implements Optionable<Integer> {

    /**
     * 连接
     */
    CONNECTION(10001),
    ERROR(-1),
    ;
    private final Integer value;

    @Override
    public String getDesc() {
        return value.toString();
    }
}
