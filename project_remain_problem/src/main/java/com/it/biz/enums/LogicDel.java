package com.it.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum LogicDel {
    NO(0),
    YES(1);

    @Getter
    private final Integer code;
}
