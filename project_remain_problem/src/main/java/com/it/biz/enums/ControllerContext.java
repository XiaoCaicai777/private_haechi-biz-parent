package com.it.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum  ControllerContext {
    PROJECT_PROBLEM_GRADE("PROJECT_PROBLEM_GRADE"),
    PROJECT_PROBLEM_TYPE("PROJECT_PROBLEM_TYPE");

    @Getter
    private final String type;
}
