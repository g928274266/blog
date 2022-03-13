package com.youlixiang.blog.common.constant;

/**
 * @Author 郭非
 * @Date 2022/3/13
 * @Time 14:15
 * @Version 1.0
 */
public enum LoginErrorEnum {
    /**
     * 用户不存在
     */
    USER_NOT_EXIST(20004, "用户不存在"),
    /**
     * 密码错误
     */
    PASSWORD_NOT_CORRECT(20005, "密码错误");

    private final int code;

    private final String message;

    LoginErrorEnum(int code, String message) {
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
