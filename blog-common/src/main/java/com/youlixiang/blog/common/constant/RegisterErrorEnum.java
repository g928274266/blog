package com.youlixiang.blog.common.constant;

/**
 * @Author 郭非
 * @Date 2022/3/13
 * @Time 10:37
 * @Version 1.0
 */
public enum RegisterErrorEnum {
    /**
     * 用户名重复
     */
    DUPLICATE_USERNAME(20001, "用户名重复"),
    /**
     * 两次密码输入不一致
     */
    PASSWORD_NOT_EQUAL(20002, "两次输入密码不同"),
    /**
     * 参数校验错误
     */
    ARGUMENT_NOT_VALID(20003, "参数校验错误");

    private final int code;

    private final String message;

    RegisterErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
