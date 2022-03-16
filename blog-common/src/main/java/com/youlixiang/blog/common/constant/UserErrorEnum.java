package com.youlixiang.blog.common.constant;

/**
 * @Author 郭非
 * @Date 2022/3/15
 * @Time 8:38
 * @Version 1.0
 */
public enum UserErrorEnum {
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
    ARGUMENT_NOT_VALID(20003, "参数校验错误"),
    /**
     * 用户不存在
     */
    USER_NOT_EXIST(20004, "用户不存在"),
    /**
     * 密码错误
     */
    PASSWORD_NOT_CORRECT(20005, "密码错误"),
    /**
     * 用户不存在
     */
    NOT_SUCH_USER(20006, "用户不存在"),
    /**
     * 用户没有登录
     */
    NOT_LOGIN(20007, "请先登录"),
    /**
     * 头像上传失败
     */
    AVATAR_NOT_UPLOAD(20008, "头像上传失败");

    private final int code;

    private final String message;

    UserErrorEnum(int code, String message) {
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
