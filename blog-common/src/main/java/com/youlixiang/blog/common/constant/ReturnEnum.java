package com.youlixiang.blog.common.constant;

/**
 * 返回信息枚举类
 *
 * @Author 郭非
 * @Date 2022/3/12
 * @Time 23:00
 * @Version 1.0
 */
public enum ReturnEnum {
    /**
     * 请求成功
     */
    COMMON_SUCCESS(200, "请求成功"),
    /**
     * 请求失败
     */
    COMMON_ERROR(500, "请求失败");

    /**
     * 返回状态码
     */
    private int code;
    /**
     * 返回信息
     */
    private String message;

    ReturnEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
