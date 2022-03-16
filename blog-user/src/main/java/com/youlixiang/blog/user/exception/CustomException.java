package com.youlixiang.blog.user.exception;

/**
 * 自定义异常类
 *
 * @Author 郭非
 * @Date 2022/3/13
 * @Time 14:13
 * @Version 1.0
 */
public class CustomException extends Exception {
    private final int code;

    public CustomException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
