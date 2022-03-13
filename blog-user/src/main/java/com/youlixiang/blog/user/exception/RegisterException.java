package com.youlixiang.blog.user.exception;

/**
 * @Author 郭非
 * @Date 2022/3/13
 * @Time 9:58
 * @Version 1.0
 */
public class RegisterException extends Exception {
    private int code;

    public RegisterException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
