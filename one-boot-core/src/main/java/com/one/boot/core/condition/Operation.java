package com.one.boot.core.condition;

import lombok.Getter;

/**
 * @version 1.0
 * @Author jonn
 * @Date: 2021/6/8
 * @Description:
 */
public enum Operation {
    IN("IN"),
    NOT_IN("NOT IN"),
    LIKE("LIKE"),
    NOT_LIKE("NOT LIKE"),
    EQ("="),
    NE("<>"),
    GT(">"),
    GE(">="),
    LT("<"),
    LE("<=");
    @Getter
    private final String key;

    Operation(String key) {
        this.key = key;
    }

}
