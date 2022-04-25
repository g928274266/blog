package com.youlixiang.blog.constant;

/**
 * 友链错误枚举类
 *
 * @Author 郭非
 * @Date 2022/4/7
 * @Time 14:10
 * @Version 1.0
 */
public enum FriendErrorEnum {
    /**
     * 添加友链失败
     */
    ADD_FRIEND_ERROR(20014, "添加友链失败"),
    /**
     * 删除友链失败
     */
    REMOVE_FRIEND_ERROR(20015, "删除友链失败"),
    /**
     * 更新友链失败
     */
    UPDATE_FRIEND_ERROR(20016, "更新友链失败");

    /**
     * 返回状态码
     */
    private int code;
    /**
     * 返回信息
     */
    private String message;

    FriendErrorEnum(int code, String message) {
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
