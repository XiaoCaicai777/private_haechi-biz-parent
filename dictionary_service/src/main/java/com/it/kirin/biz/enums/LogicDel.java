package com.it.kirin.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum  LogicDel {
    YES(1),
    NO(0);

    @Getter
    private final Integer code;
}
